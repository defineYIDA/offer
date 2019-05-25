package subject;

/**
 * @Author: zl
 * @Date: 2019/5/24 10:24
 */
public class Pro47 {


    /**
     * 题47：获得礼物的最大值
     *         思路：动态规划，f(i, j) = max(f(i - 1, j), f(i, j - 1)) + gift(i, j);
     *         使用一个辅助空间来存储计算过的值
     *         并且只需要使用一个一维数组的辅助空间就可以了
     * @return
     */
    public int getMaxValue(int[] values, int rows, int cols) {
        if (values.length == 0 || rows == 0 || cols == 0) {
            return 0;
        }
        int [] maxValues = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int left = 0;//左边到达该点的最大值
                int up = 0;
                if (i > 0) {
                    //因为是使用一维的数组来存储之前计算过的值
                    //其从上面到达的最大值，为maxValues[j],
                    up = maxValues[j];
                }
                if (j > 0) {
                    //从右面到达的最大值，为maxValues[j - 1],
                    left = maxValues[j - 1];
                }
                //注意用一维数组替代二维数组，将二维索引转化为一维索引的换算法：
                //row * cols + col == 总列数 X 当前行 + 当前列
                //这里i是当前行
                //这里是按照行进行的遍历
                maxValues[j] = Math.max(up, left) + values[i * cols + j];
            }
        }
        return maxValues[cols - 1];
    }
}
