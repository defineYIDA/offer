package tree;

/**
 * @Author: zl
 * @Date: 2019/5/16 20:19
 */
public class BinarySearchTree<T extends Comparable<? super T>> {
    /**
     * 内部静态结点类
     * @param <T>
     */
    private static class BinaryNode<T> {
        T element;
        BinaryNode<T> left;
        BinaryNode<T> right;

        BinaryNode(T element, BinaryNode<T> left, BinaryNode<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }

        BinaryNode(T element) {
            this(element, null, null);
        }
    }

    /**
     * 二叉树的查找，时间复杂度为log(n), 栈的深度为log(n)
     * 查找二叉搜索树中是否存在元素为element的节点
     * @param element
     * @param root
     * @return
     */
    public boolean contains(T element, BinaryNode<T> root) {
        if (null == root) {
            return false;
        }
        //注意compareTo返回的是int
        int comparResult = root.element.compareTo(element);

        if (comparResult > 0) {
            return contains(element, root.right);
        } else if (comparResult < 0) {
            return contains(element, root.left);
        } else {
            return true;
        }
    }

    /**
     * 递归实现
     * @param root
     * @return
     */
    private BinaryNode<T> findMin(BinaryNode<T> root) {
        if (root == null) {
            return null;
        } else if (root.left == null) {
            return root;
        }
        return findMin(root.left);
    }

    /**
     * 非递归实现
     * @param root
     * @return
     */
    private BinaryNode<T> findMax(BinaryNode<T> root) {
        if (root != null)
            while (root.right != null)
                root = root.right;
        return root;
    }

    /**
     * 元素插入
     * @param element
     * @param root
     * @return
     */
    public BinaryNode<T> insert(T element, BinaryNode<T> root) {
        if (null == root) {
           return new BinaryNode<>(element);
        }
        int comparResult = root.element.compareTo(element);
        if (comparResult > 0) {
            root.left = insert(element, root.left);
        } else if (comparResult < 0) {
            root.right = insert(element, root.right);
        }
        return root;
    }

    /**
     * 删除算法：
     * case 1: 叶子节点 --> 立即删除
     * case 2:一个子节点 --> 直接将该节点指向删除节点的父节点
     * case 3:两个字节点 --> 用其右子树的最小节点替换该节点再删除
     * @param element
     * @param root
     * @return
     */
    public BinaryNode<T> remove(T element, BinaryNode<T> root) {
        if (root == null) {
            return root;
        }
        int comparResult = root.element.compareTo(element);
        if (comparResult > 0) {
            root.left = remove(element, root.left);
        } else if (comparResult < 0) {
            root.right = remove(element, root.right);
        }//equals ,need delete
        else if(root.left != null && root.right != null) { //two children
            root.element = findMin(root.right).element;//找到右子树的最小节点,并赋值给该要删除的节点实现懒惰删除
            root.right = remove(root.element, root.right);//删除右子树最小节点
        }
        else {
            root = (root.left != null) ? root.left : root.right;
        }
        return root;
    }
}
