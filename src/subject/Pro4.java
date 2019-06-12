package subject;

/**
 * @Author: zl
 * @Date: 2019/6/12 10:14
 */
public class Pro4 {
    //二分查找
    //和二维数组相关的算法
    //建立坐标轴
    public boolean searchMatrix(int[][] matrix, int target) {
        /*验证*/
        if (matrix == null) {
            return false;
        }
        int rows = matrix.length;
        if (rows == 0) {
            return false;
        }
        int cols = matrix[0].length;
        if (cols == 0) {
            return false;
        }

        for (int row = 0; row < rows; row++) {
            if (matrix[row][0] > target) {
                return false;
            }  else if (matrix[row][0] <= target && matrix[row][cols - 1] >= target) {
                int s = 0;
                int e = cols - 1;
                //二分查找,整理注意只有一个元素的处理,采用while使用（s <= e）
                //内部：matrix[row][s] == target ? true : matrix[row][e] == target;
                while (s <= e) {
                    int mid = (e + s) >> 1;
                    if (mid == s || mid == e) {
                        return matrix[row][s] == target || matrix[row][e] == target;
                    }
                    if (matrix[row][mid] == target) {
                        return true;
                    } else if (matrix[row][mid] > target) {
                        e = mid;
                    }else {
                        s = mid;
                    }
                }
                return false;
            }
        }
        return false;
    }

    /**
     * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
     *
     * 每行的元素从左到右升序排列。
     * 每列的元素从上到下升序排列。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        int rows = matrix.length;
        if (rows == 0) {
            return false;
        }
        int cols = matrix[0].length;
        if (cols == 0) {
            return false;
        }
        //方法一：复杂度：log(m) + log(n)
        //较于上一题，存在新的可利用条件，从上到下升序，思路从上到下二分查找，找到
        //所在行后在在行内进行二分查找
        //方法二：log( m + n)
        //右上角开始查找，小于target往下走，大于target往左走
        int i = 0;
        int j = cols - 1; //右上开始
        while (j >= 0 && i < rows) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
