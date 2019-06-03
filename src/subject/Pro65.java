package subject;

/**
 * @Author: zl
 * @Date: 2019/6/3 11:29
 */
public class Pro65 {
    /**
     *题：不使用四则运算符，进行加法
     *      思路：1）相加但不进位(异)5 + 17 = 12
     *           2）做进位         5 + 7 = 10
     *           3）相加           10 + 12 = 22
     */
    public int Add(int num1,int num2) {
        //以5：101 和 12：10100为例
        while (num2 != 0) {
            int temp = num1 ^ num2;
            //出现进位的情况是num1 和 num2的字节位上都是1的
            //找到所有进位的bit(会被置1)，则递归的含义是进位后还可能进位
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }
        return num1;
    }
}
