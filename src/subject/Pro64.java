package subject;

/**
 * @Author: zl
 * @Date: 2019/6/2 22:36
 */
public class Pro64 {
    /**
     * 使用&&的短路性质
     * @param n
     * @return
     */
    public int Sum_Solution(int n) {
        int sum = n;
        boolean flag = (sum>0)&&((sum+=Sum_Solution(--n))>0);
        return sum;
    }

    /**
     * 使用异常
     * @param n
     * @return
     */
    public int Sum_Solution1(int n) {
        return sum(n);
    }
    int sum(int n){
        try{
            int i = 1%n;
            return n+sum(n-1);
        }
        catch(Exception e){
            return 0;
        }
    }

    /**
     * 使用库函数
     * @param n
     * @return
     */
    public int Sum_Solution2(int n) {
        n = (int) (Math.pow(n, 2)+n)>>1;
        return n;
    }

    /**
     * 自己使用位运算完成乘法
     *n*(n+1)/2
     * @param n
     * @return
     */
    public int Sum_Solution3(int n) {
        return multi(n, n + 1) >> 1;
    }

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/7a0da8fc483247ff8800059e12d7caf1
     * 来源：牛客网
     *
     * 原理是把a拆成2的幂的和，a = 2^e0 + 2^e1 + 2^e2....
     *  那么 a * b = (2^e0 + 2^e1 + 2^e2+...) * b
     *                       = b * 2^e0 + b * 2^e1 + b * 2^e2 + ...
     *                       = (b << e0) + (b << e1) + ....
     *                       既是b的左移的递归
     *
     * @param a
     * @param b
     * @return
     */
    private int multi(int a, int b) {
        int res = 0;
        //循环体内部, if ((a & 1) == 1), res += b;
        boolean flag1 = ((a & 1) == 1) && (res += b) > 0;
        a >>= 1;//a右移
        b <<= 1;//
        // while (a != 0) {}循环条件
        boolean flag2 = (a != 0) && (res += multi(a,b)) > 0 ;
        return res;
    }

    /**
     * 理解：
     *  以2为例：
     *   2 == 10
     *
     * @param n
     * @return
     */
    public static int Sum_Solution3_1(int n) {
        int res = 0;
        //计算：n * (n + 1)
        int a = n;//若a=2=10
        int b = n + 1;//b=3=11
        while (a != 0) {
            //即代表二进制的乘法也一样，最后一个bit为0，乘没意义
            //所以a右移一位，b左移一位，因为a已经是高位了
            if ((a & 1) == 1)
                res += b;
            a >>= 1;//a右移1位 1
            b <<= 1;//b左移动1位 110
        }
        return res>>=1;//n(n+1)/2
    }
}
