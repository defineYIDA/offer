package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zl
 * @Date: 2019/6/6 10:06
 */
public class RuntimeConstantPoolOOM {

    /**
     *VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
     */
    public static void main(String[] args) {
        // 使用List保持着常量池的引用，避免Full GC回收常量池
        List<String> list = new ArrayList<>();
        // 10MB的PermSize在Integer范围内足够产生OOM了
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
