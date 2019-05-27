package subject;

/**
 * @Author: zl
 * @Date: 2019/5/27 11:10
 */
public class Pro51 {
    public int InversePairs(int [] array) {
        if(array==null||array.length==0){
            return 0;
        }
        //创建等长的临时数组，避免递归过程中频繁的开辟空间
        int[] temArr = new int[array.length];
        return mergeSort(array, 0, array.length - 1, temArr);
    }
    private int mergeSort(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return 0;
        }
        int count = 0;
        int mid = (left + right) >> 1;
        int countL = mergeSort(nums, left, mid, temp)%1000000007;
        int countR = mergeSort(nums, mid + 1, right, temp)%1000000007;
        int countM = merge(nums, left, mid, right, temp);
        count = countL + countR + countM;
        return count%1000000007;
    }
    private int merge(int[] nums, int left, int mid, int right, int[] temp) {
        //必须从后往前遍历，不然不能确定右序列比左序列某个节点小的元素个数
        int i = mid;//左序列指针
        int j = right;//右序列指针
        int t = right;//临时数组指针
        int count = 0;//逆序对数
        while (i >= left && j > mid) {
            if (nums[i] > nums[j]) {
                //当出现左序列大于右序列时则逆序列存在j - mid 个
                count += j - mid;
                temp[t--] = nums[i--];
                if(count>=1000000007) {
                    count%=1000000007;
                }
            } else {
                temp[t--] = nums[j--];
            }
        }
        while (i >= left) {
            //count += (right - mid);
            temp[t--] = nums[i--];
        }
        while (j > mid) {
            temp[t--] = nums[j--];
        }
        //这一步不能缺
        while (left <= right) {
            nums[left] = temp[left];
            left++;
        }
        return count;
    }
}
