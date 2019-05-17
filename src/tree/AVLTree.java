package tree;

/**
 * @Author: zl
 * @Date: 2019/5/17 23:00
 * AVL树
 * 平衡条件：
 *  每个节点的左右子树的高度最多差1，空树高度为-1
 */
public class AVLTree <T extends Comparable<? super T>> {
    public class AVLNode <T> {
        T element;
        int height;//高度
        AVLNode<T> left;
        AVLNode<T> right;

        AVLNode(T element) {
            this(element, null, null);
        }

        AVLNode(T element, AVLNode left, AVLNode right) {
            this.element = element;
            this.left = left;
            this.right = right;
            this.height = 0;
        }
    }

    /**
     * 树的高度
     * @param node
     * @return
     */
    private int height(AVLNode<T> node) {
        return node == null ? -1 : node.height;
    }
    //--------------------------------------------------------------------------------------------rotate_start
    /**
     * 不平衡的节点为k2，其左节点为k1
     * LL：左单旋转 【左儿子的左子树发生了一次插入】
     * 操作：
     *         k1为根节点，k2为k1的右节点，k1原来的右节点为k2的左节点
     * @param k2 旋转后的根节点
     * @return
     */
    private AVLNode<T> rotateWithLeftChild(AVLNode<T> k2) {
        AVLNode<T> k1 = k2.left;
        k2.left = k1.right; //k2原来的右节点为k1的左节点
        k1.right = k2; //k1为k2的右节点
        //修改高度
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        return k1;
    }
    /**
     * 不平衡的节点为k1，其左节点为k2
     * RR：右单旋转 【右儿子的右子树发生了一次插入】
     * 操作：
     *         k2为根节点，k1为k2的左节点，k2原来的左节点为k1的右节点
     * @param k1 旋转后的根节点
     * @return
     */
    private AVLNode<T> rotateWithRightChild(AVLNode<T> k1) {
        AVLNode<T> k2 = k1.right;
        k1.right = k2.left; //k2原来的左节点为k1的右节点
        k2.left = k1; //k1为k2的左节点
        //修改高度
        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        return k2;
    }


    /**
     * 不平衡节k3，左儿子k1，右子树k3
     * LR：左双旋转【左儿子的右子树发生插入】
     * 操作：
     *         k1进行RR旋转
     *         K3进行LL旋转
     * @param k3
     * @return
     */
    private AVLNode<T> doubleWithLeftChild(AVLNode<T> k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    /**
     * 不平衡节k1，右儿子k3，左子树k2
     * RL：右双旋转【右儿子的左子树发生插入】
     * 操作：
     *         k3进行LL旋转
     *         K1进行RR旋转
     * @param k1
     * @return
     */
    private AVLNode<T> doubleWithRightChild(AVLNode<T> k1) {
        k1.right = rotateWithLeftChild(k1.right);
        return rotateWithRightChild(k1);
    }
    //-----------------------------------------------------------------------------------------------rotate_end



}
