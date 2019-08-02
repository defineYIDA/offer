package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zl
 * @Date: 2019/8/2 10:33
 */
public class Pro39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<Integer> sub = new ArrayList<>();
        combinationSumCore(candidates, target, sub, 0);
        return list;
    }

    List<List<Integer>> list = new ArrayList<>();

    private void combinationSumCore(int[] candidates, int target, List<Integer> sub, int s) {
        int len = candidates.length;
        if (s >= len && target != 0) {
            return;
        }
        if (target < 0) {
            return;
        }
        if (target == 0) {
            list.add(new ArrayList<>(sub));
            return;
        }

        for (int i = s; i < len; i++) {
            sub.add(candidates[i]);
            //一个数可以使用多次【2，2，3】，但是又需要防止重复的【3，2，2】之类的
            //就需要一个递增的值来限制不能使用已经遍历过的值，这里用 s 参数来控制
            //不能重复使用一个值：【s = i + 1】能重复使用【s = i】任意顺序【int i = 0】
            combinationSumCore(candidates, target - candidates[i], sub, i);
            sub.remove(sub.size() - 1 );
        }

    }
}
