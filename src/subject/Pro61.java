package subject;

import java.util.Arrays;

/**
 * @Author: zl
 * @Date: 2019/5/31 20:23
 */
public class Pro61 {
    /**
     *题：扑克牌的顺子
     *          先把数组排序
     *          统计0的个数
     *          统计空缺个数
     */
    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        //排序
        Arrays.sort(numbers);
        int length = numbers.length;
        int zero = 0;
        int miss = 0;
        for (int i = 0; i < length && numbers[i] == 0; i++) {
            zero++;
        }

        //第一个非0元素的位置
        int small = zero;
        int big = small + 1;
        //遍历数组计数空缺
        while (big < length) {
            //出现对子
            if (numbers[small] == numbers[big]) {
                return false;
            }
            miss += (numbers[big] - numbers[small] - 1);
            small = big;
            big++;
        }
        return miss <= zero;
    }
}
