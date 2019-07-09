package subject;

/**
 * @Author: zl
 * @Date: 2019/7/9 10:29
 */
public class Pro13 {
    public int movingCount(int threshold, int rows, int cols)
    {
        //参数校验
        if (threshold < 0 || rows < 1 || cols < 1) {
            return 0;
        }
        //要记录走过的位置，要初始化visited变量
        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        return movingCountCore(threshold, rows, cols, 0, 0, visited);
    }

    public int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        int count = 0;
        int now = row * cols + col;
        if (checkCount(threshold, rows, cols, row, col, visited)) {
            visited[now] = true;
            count = 1 +
                    movingCountCore(threshold, rows, cols, row + 1, col, visited) +
                    movingCountCore(threshold, rows, cols, row, col + 1, visited) +
                    movingCountCore(threshold, rows, cols, row - 1, col, visited) +
                    movingCountCore(threshold, rows, cols, row, col - 1, visited);
        }
        return count;
    }
    //1）索引越界
    //2）未访问
    //3）满足小于等于threshold
    public boolean checkCount(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        int now = row * cols + col;
        //注意判断索引时row >= 0
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && checkThreshold(threshold, row, col) && !visited[now]){
            return true;
        }
        return false;
    }
    //
    public boolean checkThreshold(int threshold, int row, int col) {
        return threshold >= (getCount(row) + getCount(col));
    }
    //
    public int getCount(int num) {
        int result = 0;
        while (num > 0) {
            result += num % 10;
            num /= 10;
        }
        return result;
    }
}
