package subject;

/**
 * @Author: zl
 * @Date: 2019/5/13 11:23
 */
public class Pro14 {
    public static void main(String[] var) {
        System.out.println(solution2(8));
    }
    /**
     * 思路一：动态规划
     *
     * @param length
     * @return
     */
    public static int solution1(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        //用一个数组来存储计算过的结果
        int[] products = new int[length + 1];
        //注意这里区分，公式为：f(n)=max(f(i)*f(n-i))
        //products中存的是f()的值不是总的结果，f(0)=0,f(1)=1
        products[0] = 0;
        products[1] = 1;//长度为2
        products[2] = 2;//长度为3
        products[3] = 3;//长度为4
        //从4开始，计算所有的可能，自下而上
        for (int i = 4; i <= length; i++) {
            int max = 0;
            //0<i<j 的f(j)都已经求出来了
            //过程：例如i=4,代表求长度为4的f(4),那就要么{1，3}，要么{2，2}，并且f(1)f(2)f(3)
            //都已经求出来了
            //同理求f(5),{1,4}{2,3},
            for (int j = 1; j <= i / 2; j++) {
                int product = products[j] * products[i - j];
                if (max < product) {
                    max = product;
                }
                products[i] = max;
            }
        }
        return products[length];
    }
    /**
     * 思路二：贪婪算法，公式总结
     *3(n-3)>2(n-2)>n
     * 一个数n，在分为3和2相乘(当余为4时为2*2)
     * @param length
     * @return
     */
    public static int solution2(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        int timeOf3 = length / 3;
        //余1，代表最后一次可以余4，3*1换为2*2
        if (length - timeOf3 == 1) {
            timeOf3--;
        }
        int timeOf2 = (length - timeOf3 * 3) / 2;
        return (int)(Math.pow(3, timeOf3)) * (int)(Math.pow(2, timeOf2));
    }
}
