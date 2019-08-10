package subject;

/**
 * @Author: zl
 * @Date: 2019/8/10 9:43
 */
public class problem1 {

    /**
     * 调整数组顺序使奇数位于偶数前面
     * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     * @param array
     */
    public void reOrderArray(int [] array) {
        int len = array.length;
        if (len <= 1) {
            return;
        }
        int[] arr1 = new int[len];
        int[] arr2 = new int[len];
        int i = 0, p1 = 0, p2 = 0;
        while (i < len) {
            if ((array[i] & 1) == 1) {
                arr1[p1] = array[i];
                p1++;
            } else {
                arr2[p2] = array[i];
                p2++;
            }
            i++;
        }
        merge(array, arr1, p1, arr2, p2);
    }
    private void merge(int [] array, int[] arr1, int l1, int[] arr2, int l2) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            if (i < l1) {
                array[i] = arr1[i];
            } else {
                array[i] = arr2[i - l1];
            }
        }
    }

    /**
     * 冒泡法
     * @param array
     */
    public void reOrderArray1(int [] array) {
        //冒泡法
        int len = array.length;
        if (len <= 1) {
            return;
        }
        int count = len;
        for (int i = 0; i < count;) {
            for (int j = i; j < count; j++) {
                if (j + 1 < count && (array[j] & 1) == 0 && (array[j + 1] & 1) == 1) {
                    swap(array, j, j + 1);
                }
            }
            count--;
        }
    }
    private void swap(int [] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
