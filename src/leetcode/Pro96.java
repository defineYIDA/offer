package leetcode;

/**
 * @Author: zl
 * @Date: 2019/8/5 9:32
 */
public class Pro96 {
    //思路：动态规划，G(n)表示0~n为节点的二叉树种类
    //f（i，n）= 以i为根节点时的类别数
    //G(i) = f(1,n)+...+f(i,n)
    //f(i,n) = G(i - 1)*G(n - i)
    //G(i) = G(1-1)*G(n-1)+...+G(i - 1)*G(n - i)
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;//为0的话做乘的话就没了
        G[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
