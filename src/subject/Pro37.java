package subject;

/**
 * @Author: zl
 * @Date: 2019/5/20 18:04
 */
public class Pro37 {
    /**
     *序列化和反序列化二叉搜索树
     *按照前序遍历进行序列化，二叉树需要对空值进行填充
     *
     *
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)
            return "";
        String s=root.val+",";
        s+=serialize(root.left);
        s+=serialize(root.right);
        return s;
    }

    //解码过程和以前的根据先序和后序构建二叉树一样
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals(""))
            return null;
        String[] s=data.split(",");
        int n=s.length;
        //System.out.println(n);
        return build(s,0,n);
    }
    public TreeNode build(String[] s,int start,int end){

        if (start == end) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s[start]));
        //找到左子树最后节点的index
        int i;
        for(i = start + 1; i < end; i++) {
            //注意这里由于end是长度，当满足条件时return，即此时的i已经是长度了
            //例如：N = 10, 序列：10，1，2，3，11，12，13
            //则 i = 4;
            //即 end - start = 长度
            //长度为0时停止递归
            if (Integer.parseInt(s[start]) < Integer.parseInt(s[i])) {
                break;
            }
        }
        root.left = build(s, start + 1, i);
        root.right = build(s, i ,end);
        return root;
    }
}
