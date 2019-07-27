package sort;

/**
 * @Author: zl
 * @Date: 2019/7/27 8:52
 */
public class BubbleSort {

    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        int[] arr = {8,1,7,5,4,1,22,6};
        sort.bubbSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "-");
        }
    }
    public void bubbSort(int[] arr) {
        int len = arr.length;
        if (len <= 1) {
            return;
        }
        int sortCount = len;
        for (int i = 0; i < sortCount; ) {
            for (int j = i; j < sortCount; j++) {
                if (j + 1 < sortCount && arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
            sortCount--;
        }
    }
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
