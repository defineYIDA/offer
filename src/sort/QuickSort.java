package sort;

/**
 * @Author: zl
 * @Date: 2019/4/4 23:07
 */
public class QuickSort {
    public static void main(String var[]){
        //int[] arr={8,2,1,4,3,7,2,9,5};
        int[] arr = {1, 3, 1};
        QSort(arr,0,2);

        System.out.println(arrayToString(arr));
        int[]arr1={1,2};
        swap(arr1,0,1);
        int[]arr2={2,2};
        swap(arr2,0,1);
        int[]arr3={2};
        swap(arr3,0,0);
        System.out.println(arrayToString(arr1));
        System.out.println(arrayToString(arr2));
        System.out.println(arrayToString(arr3));
    }

    /**
     * 船新版本
     * QSort[小于base] base QSort[大于base]
     * @param num
     * @param left 当前数组的头指针
     * @param right 尾指针
     */
    /*public static void QSort(int[] num,int left,int right){
        //如果left等于right，即数组只有一个元素，直接返回
        if(left>=right) {
            return;
        }
        //设置最左边的元素为基准值
        int key=num[left];
        //数组中比key小的放在左边，比key大的放在右边，key值下标为i
        int i=left;
        int j=right;
        //将基准值右边的值，根据基准值大小比较后交换位置：得到[base,k1,k2,k3,f1,f2,f3],其中k代表小于base，f代表大于base，其中k3,的索引为i
        while(i<j){
            //j向左移，直到遇到比key小的值
            while(num[j]>=key && i<j){
                j--;
            }
            //i向右移，直到遇到比key大的值
            while(num[i]<=key && i<j){
                i++;
            }
            //i和j指向的元素交换
            if(i<j){
                int temp=num[i];
                num[i]=num[j];
                num[j]=temp;
            }
        }
        //将索引为i的元素和base交换
        num[left]=num[i];
        num[i]=key;
        //左边递归
        QSort(num,left,i-1);
        //右边递归
        QSort(num,i+1,right);
    }*/

    /**
     * 将一个int类型数组转化为字符串
     * @param arr
     * @return
     */
    public static String arrayToString(int[] arr) {
        String str = "";
        for (int a : arr) {
            str += a + "\t";
        }
        return str;
    }
    //快排
    public static void QSort(int[] a,int left,int right) {
        //当只有一个元素直接返回
        if(left>=right) {
            return;
        }
        //选择最左边元素为基线值
        int base =a[left];
        int i=left;
        int j=right;
        //移动元素使得基线值
        while(i<j) {
            //左移放前面，不然会导致需要和base的替换的i值改变
            while(i<j&&base<=a[j]) {
                j--;
            }
            //右移
            while(i<j&&base>=a[i]) {
                i++;
            }

            if(i<j) {
                swap(a,i,j);
            }
        }
        //交换base和比base小的最后一个元素的值
        swap(a,left,i);

        QSort(a,left,i-1);//左边递归
        QSort(a,i+1,right);
    }

    private static void swap(int[] a,int i,int j) {
        /*a[i]=a[tar]^a[i];
        a[tar]=a[i]^a[tar];
        a[i]=a[i]^a[tar];*/
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }






    /**
     * 快排
     * 思考：辅助空间怎么开？
     *           不开行吗？
     *总结，
     * 对int[]开辅助空间是愚蠢的算法，
     * 首先，不好合并，其次，对辅助空间设置其length，
     * 让人头大，可以采用传入辅助变量的方式，直接修改原数组
     */
    public static int[] qSort(int[] arr){
        /*基线条件：arr.length==0 or 1*/
        if(arr.length==0){
            return arr;
        }
        if (arr.length==1){
            return arr;
        }
        /*递归条件*/
        int length=arr.length;
        int[] tmp1=new int[length];
        int x=0;
        int[] tmp2=new int[length];
        int y=0;
        for(int i=1;i<length;i++){
            if(arr[0]>=arr[i]){
                tmp1[x]=arr[i];
                x=x+1;
            } else {
                tmp2[y]=arr[i];
                y=y+1;
            }
        }
        //合并数组
        return merge(qSort(tmp1),arr[0],qSort(tmp2));
    }

    /**
     * 合并数组
     * @param arr1
     * @param m
     * @param arr2
     * @return
     */
    public static int[] merge(int[] arr1,int m,int[] arr2){
        int mid=(arr1==null?0:arr1.length);//m的位置
        int length=mid+1+(arr2==null?0:arr1.length);
        int[] mer=new int[length];
        for (int i=0;i<length;i++){
            if(i<mid){
                mer[i]=arr1[i];
            }else if(i==mid){
                mer[i]=m;
            }else {
                mer[i]=arr2[i-mid-1];
            }
        }
        return mer;
    }
}
