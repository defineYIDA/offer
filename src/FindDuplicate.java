import java.util.Arrays;

/**
 * 题三：数组中重复数字
 */
public class FindDuplicate {

    /**
     * 排序大法
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate1(int numbers[],int length,int [] duplication) {
        if(numbers == null||length==0)return false;
        Arrays.sort(numbers);
        for(int i=0;i<length-1;i++){
            if(numbers[i]==numbers[i+1]){
                duplication[0]=numbers[i];
                return true;
            }
        }
        return false;
    }

    /**
     * 推荐的做法，通过交换元素，将值i保存到numbers[i]，不开辅助空间
     * 在numbers[i]不和i相等时，如果numbers[i]和numbers[numbers[i]]相等就说明重复元素；
     * 否则就交换这两个元素，这个过程相当于排序。举个例子，通过交换将2放入numbers[2]。
     */
    public boolean duplicate(int[] numbers,int length,int [] duplication) {
        if (numbers == null || length <= 0) {
            return false;
        }
        for (int i = 0;i < length;i++){
            if (numbers[i] < 0 || numbers[i] > length -1) {
                return false;
            }
        }

        for (int i = 0; i< length; i++) {
            while (numbers[i] != i) {
                // 现在numbers[i] != i ，设numbers[i] = j,所以如果下面的if成立,就是numbers[i] == numbers[j],说明找到 重复
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                //数组不可复制，为指向首地址的指针
                swap(numbers, i, numbers[i]);
            }
        }
        return false;
    }
    private void swap(int[] numbers, int p, int q) {
        int temp = numbers[p];
        numbers[p] = numbers[q];
        numbers[q] = temp;
    }

    /**
     * 哈希法1，开辅助空间，这里用到布尔的数组
     *
     * (1)boolean不是占1位，计算机处理处理数据的最小单元是1字节，一般1位的话，其余7位会被0补齐。
     * (2)在java虚拟机规范中，JVM没有用于操作boolean的字节码指令，在编译后用int的数据类型代替boolean，此时boolean占4字节。
     * (3)boolean[]数组编译后会被byte[]数组代替，此时的boolean占1字节。
     * 总结:boolean单独存在占4字节，在boolean[]中占1字节。
     *
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate2(int[] numbers,int length,int [] duplication) {
        boolean[] k = new boolean[length];
        for (int i = 0; i < k.length; i++) {
            if (k[numbers[i]] == true) {
                duplication[0] = numbers[i];
                return true;
            }
            k[numbers[i]] = true;
        }
        return false;
    }

    /**
     * 哈希法2,用数组实现简单的hash表
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate3(int[] numbers,int length,int [] duplication) {
        if ( numbers==null ) return false;

        // 判断数组是否合法（每个数都在0~n-1之间）
        for ( int i=0; i<length; i++ ) {
            if ( numbers[i]<0 || numbers[i]>length-1 ) {
                return false;
            }
        }
        // key step
        int[] hash = new int[length];
        for( int i=0; i<length; i++ ){
            hash[numbers[i]]++;
        }
        for(int i=0; i<length; i++){
            if ( hash[i]>1 ) {
                duplication[0] = i;
                return true;
            }
        }
        return false;
    }

    /**
     * {2,3,4,5,6,4,3,7}找出任意重复数字，不能修改输入数组
     * 思路：
     * 二分查找，找到0到length的middle，计算0到middle在数组中count，if大于
     * @param numbers
     * @param length
     * @return 0-非法输入；-1-没有重复数字；其他值为重复值
     */
    public static int getDuplication(int[] numbers,int length){
        if(numbers==null||length<=0){
            return 0;
        }
        int start=1;
        int end=length-1;
        while (end>=start){
            int middle=(end-start)/2+start;
            int count=countRange(numbers,length,start,middle);
            if(end==start){
                if(count>1){
                    return start;
                }else {
                    break;
                }
            }
            if(count>(middle-start+1)){
                end=middle;
            }else {
                start=middle+1;
            }
        }
        return -1;
    }
    private static int countRange(int[] n,int length,int start,int end){
        if(null==n){
            return 0;
        }
        int count=0;
        for(int i=0;i<length;i++){
            if(n[i]>=start&&n[i]<=end){
                count++;
            }
        }
        return count;
    }

    /**
     * 二维数组判断数字是否存在
     * 思路二：把每一行当作一次二分查找
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int [][] array) {
        boolean found=false;
        int rows=array.length;
        int columns=array[0].length;
        if(array!=null&&rows!=0&&columns!=0){
            int row=0;
            int column=columns-1;
            while(row<rows&&column>=0){
                if(array[row][column]==target){
                    found=true;
                    break;
                }else if(array[row][column]>target){
                    --column;
                }else{
                    ++row;
                }
            }
        }
        return found;
    }
    public static void main(String[] args){
        int[] nums={1,4,4,5,6,3,2,7};
        int result=getDuplication(nums,8);
        int [][] array=new int[2][2];
        System.out.println(result);
    }
}
