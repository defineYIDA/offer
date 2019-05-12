/**
 * @Author: zl
 * @Date: 2019/5/12 23:59
 */
public class problem12 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        //参数校验
        if (matrix == null || matrix.length != rows * cols || str.length < 1) {
            return false;
        }
        //初始化，赋值变量
        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < rows * cols; i++) {
            visited[i] = false;
        }
        //记录满足路径的当前长度
        int pathLength = 0;
        //以二维数组的每一个点为起点，排查
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (hasPathCore(matrix, rows, cols, str, visited, row, col , pathLength)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean hasPathCore(char[] matrix, int rows, int cols, char[] str,
                               boolean[] visited, int row, int col, int pathLength) {
        //字符路径上的值已经都满足
        if (pathLength == str.length) {
            return true;
        }
        boolean hasPath = false;
        int now = row * cols + col;//当前判断的点
        //1）判断当前位置是否满足字符路径
        //2）将对索引越界的判断放在这里，可以使代码逻辑更加清晰
        //3）判断未被访问
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && matrix[now] == str[pathLength] && !visited[now]) {
            visited[now] = true;
            pathLength++;
            //遍历起上下左右
            hasPath = hasPathCore(matrix, rows, cols, str, visited, row, col - 1, pathLength)
                    || hasPathCore(matrix, rows, cols, str, visited, row, col + 1, pathLength)
                    || hasPathCore(matrix, rows, cols, str, visited, row - 1, col, pathLength)
                    || hasPathCore(matrix, rows, cols, str, visited, row + 1, col, pathLength);
            if (!hasPath) {
                //回溯
                //这里的pathLength其实是递归的一个外部变量，原来记录当前需要匹配的路径字符串的下标
                //str[pathLength+1]，为需要匹配的字符，如当前位置的上下左右的位置都未匹配到，即代表
                //str[pathLength]的字符在在矩阵中定位不正确，则需要回到前一个pathLength-1字符重新定位
                //即执行或的下一个递归
                pathLength--;
                visited[now] = false;
            }
        }
        return hasPath;
    }
}
