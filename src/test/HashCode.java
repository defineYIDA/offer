package test;

/**
 * @Author: zl
 * @Date: 2019/8/4 0:36
 */
public class HashCode {
    public static void main(String[] args){
        String a = new String("hhh");
        String b = new String("hhh");
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(System.identityHashCode(a));
        System.out.println(System.identityHashCode(b));
        System.out.println("-----------------------------------------");
        Object o1 = new Object();
        Object o2 = new Object();
        System.out.println(o1.hashCode());
        System.out.println(o2.hashCode());
        System.out.println(System.identityHashCode(o1));
        System.out.println(System.identityHashCode(o2));
        /**
         * 103272
         * 103272
         * 460141958
         * 1163157884
         * -----------------------------------------
         * 1956725890
         * 356573597
         * 1956725890
         * 356573597
         */
    }
}
