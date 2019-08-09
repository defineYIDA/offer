package blockQueue;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: zl
 * @Date: 2019/8/9 23:27
 */
public class BlockingQueue<T> {
    private List<T> queue = new LinkedList<>();

    private int limit = 10;

    public BlockingQueue(int limit) {
        this.limit = limit;
    }

    public synchronized void put(T item) throws InterruptedException {
        //队列到达限制时阻塞
        while (queue.size() == limit) {
            wait();
        }
        //到达下限是唤醒
        if (queue.size() == 0) {
            notifyAll();
        }
        queue.add(item);
    }

    public synchronized T take() throws InterruptedException {
        //队列为空时阻塞
        while (queue.size() == 0) {
            wait();
        }
        //到达此时代表队列中存在元素可以被移除，那么重要size != limit 就可以唤醒wait线程
        if (queue.size() == limit) {
            notifyAll();
        }
        return queue.remove(0);
    }

}
