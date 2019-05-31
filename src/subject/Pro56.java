package subject;

/**
 * @Author: zl
 * @Date: 2019/5/29 11:17
 */
public class Pro56 {
    /**
     *题56：整型数组中两个只出现一次的数
     *     思路：
     *         使用异或运算将重复出现的元素删除
     *         由于存在两个不同的整型，考虑寻找最终结果的第一个bit为1的位置
     *         以此划分数组，将两个不同的数值分开
     *      该题其实是一个位运算的题。
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int length = array.length;
        if (array == null || length < 2) {
            return ;
        }
        int resultOr = 0;
        for (int i = 0; i < length; i++) {
            resultOr ^= array[i];
        }
        int index = findFirstBitIs1(resultOr);
        num1[0] = num2[0] = 0;
        for (int j = 0; j < length; j++) {
            if (isBit1(array[j], index)) {
                num1[0] ^= array[j];
            } else {
                num2[0] ^= array[j];
            }
        }
    }
    private int findFirstBitIs1(int num) {
        int index = 0;
        //寻找到第一个bit为1的元素
        while ((num & 1) == 0 && index < 8 * 4){
            num = num >> 1;
            index++;
        }
        return index;
    }
    private boolean isBit1(int num, int index) {
        num = num >> index;
        //java里不能使用01直接代表boolean
        return (num & 1) == 1;
    }
}
