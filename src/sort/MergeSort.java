package sort;

/**
 * @Author: zl
 * @Date: 2019/5/27 10:20
 */
public class MergeSort {
    /**
     * 归并排序
     *            1）先将数组对半分别进行排序
     *            2）合并两个排序好的子数组
     * @param nums
     */
    public void mergeSort(int[] nums) {
        //创建等长的临时数组，避免递归过程中频繁的开辟空间
        int[] temArr = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temArr);
    }

    private void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) >> 1;
            mergeSort(nums, left, mid, temp);
            mergeSort(nums, mid + 1, right, temp);
            merge(nums, left, mid, right, temp);
        }
    }

    /**
     *合并两个排列的数组
     */
    private void merge(int[] nums, int left, int mid, int right, int[] temp) {
        int i = left;//左序列指针
        int j = mid + 1;//右序列指针
        int t = left;//临时数组的指针
        //将两个排序好的数组合并
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[t++] = nums[i++];
            } else {
                temp[t++] = nums[j++];
            }
        }
        //将左边剩余元素填充进temp
        while (i <= mid) {
            temp[t++] = nums[i++];
        }
        //将右边剩余元素填充进temp
        while (j <= right) {
            temp[t++] = nums[j++];
        }
        while (left <= right) {
            nums[left] = temp[left];
            left++;
        }
    }
}
