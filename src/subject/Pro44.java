package subject;

/**
 * @Author: zl
 * @Date: 2019/5/23 9:59
 */
public class Pro44 {

    public static void main(String[] var) {
/*        String nums = "";
        for (int i = 0; i < 100; i++) {
            nums += String.valueOf(i);
        }*/
        System.out.println(digitAtIndex(8));
        System.out.println(digitAtIndex(11));
        System.out.println(digitAtIndex(12));
        System.out.println(digitAtIndex(13));
        System.out.println(digitAtIndex(19));
        System.out.println(digitAtIndex(198));
    }
    /**
     * 题目44：数字序列（0123...规律的无限序列）中的某一位数
     *           思路：因为序列是有规律的，所以一位的占10位(0~9)
     *                     两位的占180(10~99),三位的占2700(100~999)
     * @param index
     * @return
     */
    public static int digitAtIndex(int index) {
        if (index < 0) {
            return -1;
        }
        int digit = 1;//当前位数
        while (true) {
            //求当前位数的个数
            int number = countOf(digit);
            if (index < digit * number) {
                return indexOf(digit, index);
            }
            index -= digit * number;
            digit++;
        }
    }

    public static int countOf(int digit) {
        if (digit == 1) {
            return 10;
        }
        return (int) Math.pow(10, digit - 1) * 9;
    }
    public static int indexOf(int digit, int index) {
        int num = beginNum(digit) + index / digit;//找到index对应的数字是那个，则index对应的数就在这里面
        int indexFromNum = digit - index % digit;
        for (int i = 1; i < indexFromNum; i++) {
            num /= 10;
        }
        return num % 10;
    }
    public static int beginNum(int digit) {
        if (digit == 1) {
            return 0;
        }else {
            return (int)Math.pow(10, digit - 1);
        }
    }
    public int findNthDigit(int n) {
        long len = 1, base = 1;
        long m = n;
        while (m > 9 * base * len) {
            m -= 9 * base * len;
            len++;
            base *= 10;
        }
        int curNum = (int) (base + (m - 1) / len);
        return ((curNum + "").charAt((int) ((m - 1) % len)) - '0');
    }
}
