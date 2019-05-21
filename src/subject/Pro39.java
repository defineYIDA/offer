package subject;

/**
 * @Author: zl
 * @Date: 2019/5/21 15:44
 */
public class Pro39 {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array.length == 0) {
            return 0;
        }
        int result = array[0];
        int times = 1;
        for (int i = 1; i < array.length; i++) {
            if (times == 0) {
                result = array[i];
                times = 1;
            } else if (array[i] == result) {
                times++;
            } else {
                times--;
            }
        }
        if (!moreThanHalf(array, result)) {
            result = 0;
        }
        return result;
    }
    public boolean moreThanHalf(int [] array, int result) {
        int times = 0;
        for (int i = 0; i < array.length; i++) {
            if (result == array[i]) {
                times++;
            }
        }
        if (times * 2 <= array.length) {
            return false;
        }
        return true;
    }
}
