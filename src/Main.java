
public class Main {
    /**
     * 重载运算符
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");
        double d1 = 0.0000000000000000000000000000000001;
        double d2 = 0.0000000000000000000000000000000001;
        Integer.valueOf("123");
        if (Double.doubleToLongBits(d1) == Double.doubleToLongBits(d2)) {
            System.out.println("true");
        }
    }

}
