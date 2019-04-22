import tree.TreeNode;

/**
 * @Author: zl
 * @Date: 2019/4/2 16:53
 */
public class test {
    //METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
/*    public static int canArrangeWords(String arr[])
    {
        int length=arr.length;
        if(length<2){
            return -1;
        }
        for(int i=0;i<=length;i++){
            if(i!=length-1){
                return 1;
            }
            System.out.println(arr[i].get(0));
            if(!arr[i].get(arr[i].length()).equals(arr[i+1].get(0))){
                return -1;
            }
        }
        return -1;
    }*/

    public static void main (String[] args) {
        String arr[]=new String[2];
        arr[0]="qwe";
        arr[1]="efg";
        for(int i=0;i<=arr.length;i++){
            if(i==arr.length-1){
                System.out.println("1");
                return;
            }
            if(!(arr[i].charAt(arr[i].length()-1)==arr[i+1].charAt(0))){
                System.out.println("-1");
            }
        }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return DFS(preorder,0,preorder.length,inorder,0);
    }

    /**
     * 注意各个参数的含义，这道题其实也是和数组相关的题
     * @param arr 前序遍历数组
     * @param i 前序遍历数组的起点index
     * @param j 前序遍历数组的长度
     * @param brr
     * @param l 中序遍历起点
     * @return
     */
    public TreeNode DFS(int []arr,int i,int j,int []brr,int l){
        if(j==0)
            return null;
        TreeNode now=new TreeNode(arr[i]);
        int count=0;
        //注意这里只限定最大长度
        while(count<j){
            if(brr[count+l]==arr[i])
                break;
            count++;
        }
        now.left=DFS(arr,i+1,count,brr,l);
        now.right=DFS(arr,i+count+1,j-count-1,brr,l+count+1);
        return now;
    }

    /**
     * ### 总结：
     * 在重建二叉树时，函数参数设置为：
     * > 由于不想copy数组，所以一般采用对数组设置一定的索引范围方法来模拟对数组的截取
     * > 则重要的为设置递归的索引范围，则范围的设置方法：
     * > 1）首位索引
     * > 2）索引+length
     * 该题的数组截取，采用如下方式：
     * 前序/后续，的首索引，和长度
     * 中序的起始索引
     * 其实这里的length是相对两个数组都有效的
     * @param in
     * @param Istart
     * @param post
     * @param Pstart
     * @param length
     * @return
     */
    public TreeNode BFS(int[] in,int Istart,int[] post,int Pstart,int length ){
        if(length==0){
            return null;
        }
        TreeNode root=new TreeNode(post[Pstart+length-1]);//后序遍历如何确定根节点
        int count =0;
        while(count<length){
            if(in[count+Istart]==post[Pstart+length-1]){
                break;
            }
            count++;
        }
        root.left= BFS(in,Istart,post,Pstart,count);
        root.right=BFS(in,count+Istart+1,post,count+Pstart,length-count-1);
        return root;
    }
}
