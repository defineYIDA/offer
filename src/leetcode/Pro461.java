package leetcode;

/**
 * @Author: zl
 * @Date: 2019/9/15 9:35
 */
public class Pro461 {
    public int hammingDistance(int x, int y) {
        int t = x ^ y;
        int c = 1;
        int count = 0;
        while (c != 0) {
            if ((t & c) != 0) {
                count++;
            }
            //注意没有无符号左移，只存在无符号右移
            c = c << 1;
        }
        return count;
    }
}
