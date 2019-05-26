package subject;

/**
 * @Author: zl
 * @Date: 2019/5/26 21:44
 */
public class Pro49 {
    /**
     *丑数：只包含因子：2，3，5
     *    方法一：暴力遍历法 超时
     *    方法二：空间换时间
     *          将已经获得的数进行排序，假如当前最大丑数为M
     *          那么下一个丑数一定是前面丑数中最小的一个*2/*3/*5
     *          由于是递增如果要求下一个丑数M1，也就是
     *
     */
    public int nthUglyNumber(int n) {
        if (n == 0) {
            return 0;
        }
        int[] uglyNum = new int[n];
        uglyNum[0] = 1;
        int nextIndex = 1;
        //注意起始是0
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        while (nextIndex < n) {
            int ugly2 = uglyNum[p2];
            int ugly3 = uglyNum[p3];
            int ugly5 = uglyNum[p5];
            int min = min(ugly2 * 2, ugly3 * 3, ugly5 * 5);
            uglyNum[nextIndex] = min;
            while (uglyNum[p2] * 2 <= min) {
                p2++;
            }
            while (uglyNum[p3] * 3 <= min) {
                p3++;
            }
            while (uglyNum[p5] * 5 <= min) {
                p5++;
            }
            nextIndex++;
        }
        return uglyNum[n-1];
    }

    public int min(int num1, int num2, int num3) {
        int min = (num1 < num2) ? num1 : num2;
        min = (min < num3) ? min : num3;
        return min;
    }


    public boolean isUgly(int num) {
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return (num == 1) ? true : false;
    }

}
