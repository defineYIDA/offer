package subject;

/**
 * @Author: zl
 * @Date: 2019/5/22 22:06
 */
public class Pro43 {
    public class Solution {
        public int NumberOf1Between1AndN_Solution(int n) {
            int num = 0;
            for(int i = 0; i <= n; i++) {
                num += numOf(i);
            }
            return num;
        }
        public int numOf(int n) {
            int num = 0;
            while (n != 0) {
                if (n % 10 == 1) {
                    num++;
                }
                n = n / 10;
            }
            return num;
        }
    }
}
