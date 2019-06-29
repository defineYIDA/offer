package leetcode;

/**
 * @Author: zl
 * @Date: 2019/6/29 23:24
 */
public class Pro777 {
    //L只能向左移，R只能向右移
    //去掉X后的字符串应该相等
    public boolean canTransform(String start, String end) {
        if (start.length() != end.length()) {
            return false;
        }
        int len = start.length();
        char[] startArr = start.toCharArray();
        char[] endArr = end.toCharArray();
        int i = 0;
        int j = 0;
        while (i < len && j < len) {
            //step 1 skip x
            while (i < len - 1 && startArr[i] == 'X') {
                i++;
            }
            while (j < len - 1 && endArr[j] == 'X') {
                j++;
            }
            //step 2 判断去掉'X'是否相同
            if (startArr[i] != endArr[j]) {
                return false;
            }
            //step 3 检查start的'L'左边'X'的个数是否不少于end中对应位置的'L'左边的'X'个数
            //step 4 检查start的'R'左边'X'的个数是否不多于end中对应位置的'R'左边的'X'个数
            if ((startArr[i] == 'L' && i < j) || (endArr[j] == 'R' && i > j)) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}
