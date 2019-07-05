package sort;

/**
 * @Author: zl
 * @Date: 2019/6/15 23:13
 */
public class QuickSortOptimize {
    public static void main(String var[]) {
        QuickSortOptimize optimize = new QuickSortOptimize();
        //int[] arr={8,2,1,4,3,7,2,9,5};
        int[] arr = {1, 2, 1, 2, 1};
        optimize.QSort(arr, 0, arr.length - 1);
        System.out.println(QuickSort.arrayToString(arr));
    }
    /**
     *
     * @param a
     * @param left
     * @param right
     */
    public void QSort(int[] a, int left, int right) {
        //当只有一个元素直接返回
        if(left >= right) {
            return;
        }
        //选择最左边元素为基线值
        int base = median3(a, left, right);
        int i = left;
        int j = right - 1;
        //移动元素使得基线值
        while(i < j) {
            //先右移
            while(i < j && base > a[++i]) {
                //i++;
            }
            while(i < j && base < a[--j]) {
                //j--;
            }
            if(i < j) {
                swap(a, i, j);
            }
        }
        //交换base和比base小的最后一个元素的值
        swap(a, i ,right - 1);

        QSort(a, left, i - 1);//左边递归
        QSort(a, i + 1, right);
    }
    final private void swap(int[] a,int i,int j) {
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    private int median3(int[] a,int i,int j) {
        //对三个数组进行排序
        int m = (i + j) >> 1;
        if (a[m] < a[i]) {
            swap(a, i, m);
        }
        if (a[j] < a[i]) {
            swap(a, i, j);
        }
        if (a[j] < a[m]) {
            swap(a, j, m);
        }
        //将枢纽值放在j - 1;
        swap(a, m, j - 1);
        return a[j - 1];
    }
}
