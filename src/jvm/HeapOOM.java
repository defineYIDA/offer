package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zl
 * @Date: 2019/6/6 0:09
 */
public class HeapOOM {
    public static class OOMObject {
    }

    /**
     *VM Args:
     * -verbose:gc
     * -Xms20M
     * -Xmx20M
     * -XX:+HeapDumpOnOutOfMemoryError
     */
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
