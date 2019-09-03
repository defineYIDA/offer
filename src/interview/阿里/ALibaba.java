package interview.阿里;

import java.util.Scanner;

/**
 * @Author: zl
 * @Date: 2019/8/30 21:12
 */
public class ALibaba {
    static int res=Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int n = Integer.parseInt(line);
        int[][] area = new int[n][n];
        for (int i = 0; i < n; i++) {
            line = scanner.nextLine();
            String[] split = line.split(",");
            if (split.length != n) {
                throw new IllegalArgumentException("错误输入");
            }
            int j = 0;
            for (String num : split) {
                area[i][j++] = Integer.parseInt(num);
            }
        }
        int minimumTimeCost = getMinimumTimeCost(n,area);
        System.out.println(res);
    }

    /** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    private static int getMinimumTimeCost(int n, int[][] area) {
        for(int i=0;i<n;i++) {
            dfsHelper(0,i,n,area,0);
        }
        return 0;

    }
    private static void dfsHelper(int i,int j,int n,int[][] area,int record) {
        if(i==n-1) {
            res=Math.min(res, record);
            return;
        }
        if(i==n-2) {
            dfsHelper(i+1,j,n,area,record+area[i+1][j]);
        }
        if(i<n-2) {
            dfsHelper(i+2,j,n,area,record+area[i+1][j]);
        }
        if(j<n-2) {
            dfsHelper(i,j+2,n,area,record+area[i][j+1]);
        }
    }
}
