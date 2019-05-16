package subject;

/**
 * @Author: zl
 * @Date: 2019/5/14 15:32
 */
public class Pro16 {
    boolean invalidInput = false;
    public double Power(double base, int exponent) {
        //base等于0，次数小于0的非法输入
        if (Double.doubleToLongBits(base) == Double.doubleToLongBits(0.0) && exponent < 0) {
            invalidInput = true;
            return 0.0;
        }

        int absExponent = exponent;
        //先将负次方转化为正，最后再求倒数
        if (exponent < 0) {
            absExponent = -exponent;
        }
        double result = powerWithPower(base, absExponent);
        if (exponent < 0) {
            result = 1.0 / result;
        }
        return result;
    }
    //进行次方运算，注意这里可以优化运算过程
    public double powerWithPower(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        //即当前求的次方，例如4或者5，的结果为2的结果的平方，如果为奇数乘base
        double result = powerWithPower(base, exponent >> 1);
        result *= result;
        //奇数的末字节为1
        if ((exponent & 0x1) == 1) {
            result *= base;
        }
        return result;
    }
}
