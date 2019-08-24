package subject;

/**
 * @Author: zl
 * @Date: 2019/6/3 11:29
 */
public class Pro65 {
    /**
     * 题：不使用四则运算符，进行加法
     * 思路：1）相加但不进位(异)5 + 17 = 12
     * 2）做进位         5 + 7 = 10
     * 3）相加           10 + 12 = 22
     */
    public int Add(int num1, int num2) {
        //以5：101 和 12：10100为例
        while (num2 != 0) {
            //不进位相加
            int temp = num1 ^ num2;
            //出现进位的情况是num1 和 num2的字节位上都是1的
            //找到所有进位的bit(会被置1)，则递归的含义是进位后还可能进位
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }
        return num1;
    }

    public int mult(int a, int b) {
        int res = 0;
        //a=10
        //b=11
        while (a != 0) {
            if ((a & 1) == 1)
                res += b;
            a >>= 1;//a右移1位 1
            b <<= 1;//b左移动1位 110
        }
        return res;
    }

    public static void main(String[] args) {
        Pro65 p = new Pro65();
        //注意负数的运算是以补码的形式出现的
        // -2 的补码：          1111  ... 1110 （除最高位取反再加1）
        //4的二进制码          0000  ... 0100
        //相加不进位temp：1111 ... 1010
        //计算进位：           0000 ... 1000（由于一位的结果）

        p.Add(-2, 4);
        System.out.println(p.mult(1, 1));
        System.out.println(p.mult(0, 1));
        System.out.println(p.mult(1, -1));
        System.out.println(p.mult(9, 9));
        System.out.println(p.mult(111, 9));
        System.out.println(p.mult(111, 888));
    }
}
