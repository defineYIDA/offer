package subject;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author: zl
 * @Date: 2019/5/21 10:58
 */
public class Pro38 {
    /**
     * 字符串的全排列
     *     思路：
     *             alibaba
     *           1）概率论：C(3,7) * C(2,4) *  2
     *           2）将字符串分为两部分，第一个char和其余的，每一次将第一个和它后面的字符逐个交换
     *           3）重复的用判断是否存在进行筛选：res.contains(val)
     *           4）str.toCharArray()，将字符串转化为char[]
     * @param str
     * @return
     */
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str != null && str.length() > 0) {
            PermutationCore(str.toCharArray(), 0, res);
            Collections.sort(res);//整理顺序
        }
        return res;
    }
    private void PermutationCore(char[] cs, int i, ArrayList<String> res) {
        if (i == cs.length - 1) {
            String val = String.valueOf(cs);
            if (!res.contains(val)) {
                res.add(val);
            }
        } else {
            for (int j = i; j < cs.length; j++) {
                swap(cs, i, j);
                PermutationCore(cs, i + 1, res);
                swap(cs, i, j);//交换回来
            }
        }
    }
    public void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
}
