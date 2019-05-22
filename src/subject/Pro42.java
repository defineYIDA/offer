package subject;

/**
 * @Author: zl
 * @Date: 2019/5/22 21:58
 */
public class Pro42 {
    /**
     *题42连续子数组的最大和
     *    思路：维护一个累加子数组和(curNum)和最大子数组和(greatestNum)
     *         只有当 curNum > greatestNum 时数组才算有效的元素
     *
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int curNum = 0;//访问当前元素时的最大累加
        //最大和
        int greatestNum = 0x80000000;//int的最小值
        for(int i = 0; i < array.length; i++) {
            //curNum小于0代表，前面一个数为负数，则累加负数只会更小
            //所以直接设置为当前元素
            if (curNum < 0) {
                curNum = array[i];
            } else {
                curNum += array[i];
            }
            if (curNum > greatestNum) {
                greatestNum = curNum;
            }
        }
        return greatestNum;
    }
}
