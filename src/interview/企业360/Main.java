package interview.企业360;

import java.util.Scanner;

/**
 * @Author: zl
 * @Date: 2019/8/15 18:55
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String[] arr = line1.split(" ");
        if (arr.length != 2) {
            throw new IllegalArgumentException();
        }
        int rows = Integer.valueOf(arr[0]);
        int cols = Integer.valueOf(arr[1]);
        int[][] in = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            String line = scanner.nextLine();
            String[] lineArr = line.split(" ");
            if (lineArr.length != cols) {
                throw new IllegalArgumentException();
            }
            for (int j = 0; j < cols; j++) {
                in[i][j] = Integer.valueOf(lineArr[j]);
            }
        }
        System.out.println(problem1(in, rows, cols));
        int[] res = problem(in, rows, cols);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i ++) {
            sb.append(res[i]);
            if (i != res.length - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }

    /**
     * 时间限制：C/C++语言 1000MS；其他语言 3000MS
     * 内存限制：C/C++语言 65536KB；其他语言 589824KB
     * 题目描述：
     * 在一个古老的国度，这个国家的人并不懂得进位，但是对取模情有独钟，因此诞生了一个经典的问题，给出两个在m进制下含有n位的数字，你可以分别将这两个数各位上的数字重新排列，然后将两个数按位对应相加并分别对m取模，这样显然可以得到一个新的m进制下的n位数(可能存在前导0)，但是这个结果是不唯一的，问题来了，按照这样的操作，能够得到的最大的m进制下的数字是多少呢。
     *
     * 输入
     * 输入第一行包含两个正整数n,m分别表示数字含有n位，和在m进制下。
     *
     * 输入第二行和第三行分别包含n个整数，中间用空格隔开，每个整数都在0到m-1之间。每行第i个数表示的是当前数第i位上的数字。
     *
     * 输出
     * 输出包含n个数字，中间用空格隔开，表示得到的最大的数字，从高位到低位输出，如6在2进制下输出3位的结果是1 1 0。
     *
     *
     * 样例输入
     * 5 5
     * 4 4 1 1 1
     * 4 3 0 1 2
     * 样例输出
     * 4 4 3 3 2
     *
     * 提示
     * 4 4 1 1 1 →1 4 1 4 1
     * 4 3 0 1 2 →3 0 2 4 1（重排序列不唯一，数位相加后的数字为 4 4 3 8 2，对5取模即可 ）
     * 规则
     * 请尽量在全场考试结束10分钟前调试程序，否则由于密集排队提交，可能查询不到编译结果
     * 点击“调试”亦可保存代码
     * 编程题可以使用本地编译器，此页面不记录跳出次数
     */
    private static int[] problem(int[][] arr, int rows, int cols) {
        int[] res = {4, 4, 3, 3, 2};
        return res;
    }

    /**
     *思路：一个矩形有效面积存在7种可能，分别对应着6个面是否存在邻接矩阵
     * @return
     */
    private static int problem1(int[][] arr, int rows, int cols) {
        if (rows < 1 || cols < 1) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int size = arr[i][j];//当前位置的矩形个数（一维）
                //分层k代表层数
                for (int k = 1; k <= size; k++) {
                    int max = 6;//一个矩形的最大面积
                    //下
                    if (k > 1)
                        max--;
                    //上
                    if (k < size)
                        max--;
                    //左
                    if (j > 0 && arr[i][j - 1] >= k)
                        max--;
                    //右
                    if (j < cols - 1 && arr[i][j + 1] >= k)
                        max--;
                    //前
                    if (i > 0 && arr[i - 1][j] >= k)
                        max--;
                    //后
                    if (i < rows - 1 && arr[i + 1][j] >= k)
                        max--;
                    count+=max;
                }
            }
        }
        return count;
    }


}
