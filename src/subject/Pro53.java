package subject;

/**
 * @Author: zl
 * @Date: 2019/5/28 10:37
 */
public class Pro53 {


    public static void main(String[]  v) {
        int[] array = {3,3,3,3,4,5};
        System.out.println(GetNumberOfK(array, 3));
    }


    public static int GetNumberOfK(int [] array , int k) {
        if (array.length == 0) {
            return 0;
        }
        int start = 0;
        int end = array.length - 1;
        int pos = 0;
        while (start < end) {
            int mid = (end - start) >> 1;
            if (end == mid || start == mid) {
                pos = array[start] == k ? start : array[end] == k ? end : 0;
                break;
            }
            if (array[mid] == k) {
                pos = mid;
                break;
            } else if (array[mid] < k) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return getK(array, k, pos);
    }
    /**
     *根据一个k的位置，找到所以的k
     */
    private static int getK(int [] array , int k, int pos) {
        if (array[pos] != k) {
            return 0;
        }
        int count = 0;
        int prev = pos;
        //往pos前遍历
        while (prev >= 0) {
            if (k == array[prev]) {
                count++;
                prev--;
            } else {
                break;
            }
        }
        int next = pos + 1;
        //往pos后遍历
        while (next < array.length) {
            if (k == array[next]) {
                count++;
                next++;
            } else {
                break;
            }
        }
        return count;
    }



}
