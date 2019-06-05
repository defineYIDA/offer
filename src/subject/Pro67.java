package subject;

/**
 * @Author: zl
 * @Date: 2019/6/5 19:53
 */
public class Pro67 {
    //用来标识输入是否合法
    public boolean isVail = false;
    /**
     *题：str to int
     *      思路：特殊情况的考虑：
     *               1）正负号
     *               2）大数判断
     */
    public int StrToInt(String str) {
        if (str == null || "".equals(str)) {
            isVail = true;
            return 0;
        }
        char[] nums = str.toCharArray();
        int cur = 0;
        //标识正负
        boolean minus = false;
        if (nums[0] == '+') {
            cur++;
        } else if (nums[0] == '-') {
            minus = true;
            cur++;
        }
        long number = 0;
        //判断只存在正负号的特殊情况
        if (cur < nums.length) {
            number = strToIntCore(nums, cur, minus);
        }
        return (int)number;
    }

    private long strToIntCore(char[] nums, int cur, boolean minus) {
        long num = 0;
        while (cur < nums.length) {
            if (nums[cur] >= '0' && nums[cur] <= '9') {
                int flag = minus ? -1 : 1;
                num = num * 10 + flag * (nums[cur] - '0');
                if (!minus && num > 0x7FFFFFFF || (minus && num < 0x80000000)) {
                    num = 0;
                    break;
                }
                cur++;
            } else {
                num = 0;
                isVail = true;
                break;
            }
        }
        return num;
    }
}
