package subject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zl
 * @Date: 2019/5/18 16:28
 */
public class Pro29 {
    /**
     *顺时针打印矩阵
     *    思路：
     *因为打印一圈的起点为(0,0),(1,1)...(n,n)，推导出限制条件为：
     *   <col > start * 2 && row > start * 2>
     *
     *       1）确认打印的圈数，每一个打印圈调用一次打印圈的函数
     *       2）打印圈的函数将打印一圈分为4种情况
     *         1.只能右移一次，一行的情况
     *         起始
     *         2.能右移一次,然后下移一次,竖着的情况
     *
     *         3.下移之后再左移，为两行的情况
     *
     *         4.左移后再上移的情况，为多行的情况
     *可见上面的步骤其实是渐进的过程，当满足第一步才能第二步，而进行这几步的条件都和需要打印的圈的
     *行列数有关。
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        if (matrix == null) {
            return list;
        }
        int rows = matrix.length;//行
        if(rows == 0) {
            return list;
        }
        int cols = matrix[0].length;//列
        int start = 0;
        while(rows > start * 2 && cols > start * 2) {
            list = spiralOrderCore(matrix, start, list);
            start++;
        }
        return list;
    }
    public List<Integer> spiralOrderCore(int[][] matrix, int start, List<Integer> list) {
        int rows = matrix.length;//行
        int cols = matrix[0].length;//列
        int endX = cols - 1 - start;//起始点的对立点
        int endY = rows - 1 - start;
        //1从左到右
        for(int i = start; i <= endX; i++) {
            list.add(matrix[start][i]);
        }
        //2从上到下，要求行数大于2
        if(start < endY) {
            for(int i = start + 1; i <= endY; i++) {
                list.add(matrix[i][endX]);
            }
        }
        //3从右到左,要求类数大于1
        if(start < endY && start < endX) {
            for(int i = endX - 1; i >= start; i--) {
                list.add(matrix[endY][i]);
            }
        }
        //4从下到上,要求行数大于3
        if(start < endY - 1 && start < endX) {
            //这里出错了一次，从下往上打印的起始坐标为(start,endY-1)
            for(int i = endY - 1; i >= start + 1; --i) {
                list.add(matrix[i][start]);
            }
        }
        return list;
    }
}
