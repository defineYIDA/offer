package subject;

/**
 * @Author: zl
 * @Date: 2019/5/19 16:19
 */
public class Pro33 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        return VerifySquenceOfBSTCore(sequence, 0, sequence.length - 1);
    }
    public boolean VerifySquenceOfBSTCore(int [] sequence, int start, int end) {
        int length = end - start + 1;
        if (length <= 0) {
            return false;
        }
        if (start == end) {
            return true;
        }
        int root = sequence[length - 1];
        //序列中搜索左子树的节点
        int i = start;
        for(; i < end - 1; i++) {
            if (sequence[i] > root) {
                break;
            }
        }
        //搜索右子树
        int j = i;
        for(; j < end - 1; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }
        //判断左子树
        boolean left = true;
        if (i > start) {
            left = VerifySquenceOfBSTCore(sequence, start, i);
        }
        boolean right = true;
        if (j > i) {
            right = VerifySquenceOfBSTCore(sequence, i + 1, j);
        }
        return left && right;
    }
}
