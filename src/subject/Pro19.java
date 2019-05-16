package subject;

/**
 * @Author: zl
 * @Date: 2019/5/15 20:32
 */
public class Pro19 {
    public boolean match(char[] str, char[] pattern)
    {
        if (str == null || pattern == null) {
            return false;
        }
        return matchCore(str, 0, pattern, 0);
    }
    public static boolean matchCore(char[] str, int i, char[] pattern, int j) {
        //匹配串和模式串都到达尾，说明成功匹配
        if (i >= str.length && j >= pattern.length) {
            return true;
        }
        //只有模式串到达结尾，说明匹配失败
        if (i < str.length && j >= pattern.length) {
            return false;
        }

        //模式串为结束，匹配串可能结束也可能未结束
        //注意越界的判断
        //后一位为 *
        if (j < pattern.length - 1 && pattern[j + 1] == '*') {
            if (i < str.length && (pattern[j] == str[i] || '.' == pattern[j])){
                return matchCore(str, i + 1, pattern, j +2) ||
                        matchCore(str, i + 1, pattern, j) ||
                        matchCore(str, i, pattern, j +2);
            } else {
                return matchCore(str, i, pattern, j +2);
            }
        } else {
            //相等条件：字符相等，匹配为'.'且
            if (i < str.length && (pattern[j] == str[i] || '.' == pattern[j])) {
                return matchCore(str, i + 1, pattern, j +1);
            }
        }
        return false;
    }
}
