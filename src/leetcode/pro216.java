package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zl
 * @Date: 2019/8/2 10:07
 */
public class pro216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k < 1 || n <= 0) {
            return list;
        }
        List<Integer> sub = new ArrayList<>();
        combinationSum3Core(sub, k, n, 1);
        return list;
    }
    List<List<Integer>> list = new ArrayList<>();
    private void combinationSum3Core(List<Integer> sub, int k, int n, int s) {
        if (k <= 0) {
            if (n == 0) {
                list.add(new ArrayList<>(sub));
            }
            return;
        }

        for (int i = s; i <= Math.min(n, 9); i++) {
            if (sub.contains(i)) {
                return;
            }
            sub.add(i);
            combinationSum3Core(sub, k - 1, n - i, i + 1);
            sub.remove(sub.size() - 1);

        }
    }
}
