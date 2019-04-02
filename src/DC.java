/**
 * @Author: zl
 * @Date: 2019/4/2 17:32
 * 分而治之
 */
public class DC {

    public static void main(String[] var){
       /* int[] arr={1,2,3,4,5,6,7,8,8,8,6};
        System.out.println(sum(arr));*/
        System.out.println(find(0,arr.length-1));
    }
    public static int sum(int[] arr){
        /*基线条件*/
        if(arr.length==0){
            return 0;
        }else if(arr.length==1){
            return arr[0];
        }else{//递归条件
            int[] n=new int[arr.length-1];
            for(int i=1;i<arr.length;i++){
                n[i-1]=arr[i];
            }
            return arr[0]+sum(n);
        }
    }
    static int[] arr={1,2,3,4,5,6,7,10};
    static int target=11;
    /**
     * 二分查找的分而治之算法
     * @param i
     * @param j
     * @return
     * result:该方法造成了satck溢出，可能基线条件未设置好
     */
    public static int find(int i,int j){
        if(j<=0){
            return -1;
        }
        /*基线条件*/
        if(j-i==1||j-i==0){
            if(arr[i]==target){
                return i;
            }
            if(arr[j]==target){
                return j;
            }
            return -1;
        }
        int middle=(i+j)/2;
        if(arr[middle]==target){
            return middle;
        }
        /*递归条件*/
        if(arr[middle]>target){
            return find(i,middle);
        }else {
            return find(middle,j);
        }
    }
}
