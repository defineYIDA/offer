package thread.AQS;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Author: zl
 * @Date: 2019/8/27 22:51
 */
public class DoubleLock {
    private static class Sync extends AbstractQueuedSynchronizer {
        public Sync() {
            super();
            //初始化状态
            setState(2);
        }

        @Override
        protected int tryAcquireShared(int arg) {
            while (true) {
                int cur = getState();
                int next = getState() - arg;
                //因为存在并发线程更改同步状态，所以需要cas确保线程安全
                //这个地方注意添加对当前值的判断，如果同步状态未0即需要进行挂起
                if (next < 0 || compareAndSetState(cur, next)) {
                    //返回的是状态量
                    return next;
                }
            }
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            while (true) {
                int cur = getState();
                int next = getState() + arg;
                if (compareAndSetState(cur, next)) {
                    return true;
                }
            }
        }

        private Sync sync = new Sync();

        public void lock() {
            sync.acquireShared(1);
        }

        public void unlock() {
            sync.releaseShared(1);
        }

    }
}
