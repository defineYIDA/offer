package subject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: zl
 * @Date: 2019/5/25 9:56
 */
public class Pro48 {

    /**
     * 暴力法：枚举所有情况
     *            时间复杂度：O(n*n*n)
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        // 子串窗口：      [i, j)
        //   j  范围：       [i + 1, n)
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
        return ans;
    }

    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            //这里对String的处理没有采用转换为数组的形式
            Character ch = s.charAt(i);
            //判断子串每一个元素是否重复，存在大量重复操作
            if (set.contains(ch))
                return false;
            set.add(ch);
        }
        return true;
    }

    /**
     * 滑动窗口：
     *             使用HashSet作为滑动窗口
     *             可以在O(1)时间进行一次是否存在的判断
     *             时间复杂度为：O(2n)，每一个元素被 i 和 j访问两次
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                //如果元素不存在则右边界右移，窗口增大，将新的元素添加到窗口
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                //如果元素存在则左边界右移，窗口减少，同时将左边界对应的元素移除窗口
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * 优化的滑动窗口：
     *                前面使用HashSet的方式，需要一个时间复杂度为O(j - i)的操作
     *                寻找到重复的元素,判断存在通过hash函数只需要O(1)
     *                可以进一步通过HashMap，记录子串中元素的位置
     *                快速的找到重复元素的位置
     *  注意窗口的移动：
     *                窗口范围：[ i, j)
     *                "abba" 为例：
     *                [(a, 1),(b, 2)] 时窗口为[0, 2) ans = 2
     *                判断j = 2，时集合中已经包含，则 窗口变为[2, 3) ans = 2
     *                判断j = 3，时a存在集合中，但是不在窗口里，则窗口[2, 4) ans = 2
     *  为什么容器中存储字符的位置是index + 1？
     *                只有存在才会调用元素的位置，即获取带重复元素的位置，加一为窗口的新左边界
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {//元素存在于当前的子串中
                i = Math.max(map.get(s.charAt(j)), i);//找到位置,并和i比较，因为这里并不是只包含字串，还有窗口之外的元素
            }
            ans = Math.max(ans, j - i + 1);//每一次都计算最大值
            map.put(s.charAt(j), j + 1);//滑动
        }
        return ans;
    }

    /**
     * 最终优化：
     *            确定的元素范围：时使用数组替代map
     *
     * int [26] 用于字母 ‘a’ - ‘z’ 或 ‘A’ - ‘Z’
     * int [128] 用于ASCII码
     * int [256] 用于扩展ASCII码(ISO)
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring4(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);//如元素不存在那==0
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
}
