package interview.baidu;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author: zl
 * @Date: 2019/9/10 18:56
 */
public class Main {
    public static void main(String[] args) {
/*        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String[] lineArr = line1.split(" ");
        int count = Integer.valueOf(lineArr[0]);
        int[][] money = new int[count][2];
        for (int i = 0; i < count; i++) {
            String line = sc.nextLine();
            String[] arr = line.split(" ");
            money[i][0] = Integer.valueOf(arr[0]);
            money[i][1] = Integer.valueOf(arr[1]);
        }
        pro1(money, Integer.valueOf(lineArr[1]));*/
        //=================================
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        int[][] in = new int[n - 1][2];
        for (int i = 0; i < n - 1; i++) {
            String s = sc.nextLine();
            String[] arr = s.split(" ");
            in[i][0] = Integer.valueOf(arr[0]);
            in[i][1] = Integer.valueOf(arr[1]);
        }
        pro2(in, n);
    }

    private static void pro1(int[][] m, int tar) {
        int count = 0, type = m.length;
        int temp = 0;
        for (int i = 0; i < type; i++) {
            if (m[i][0] > tar) {
                //不找零
                count += (m[i][0] / tar) * m[i][1];
            } else {
                temp += (m[i][0]) * m[i][1];
            }
        }
        count += temp / tar;
        System.out.println(count);
    }


    private static void pro2(int[][] in, int n) {
        //统计节点的边数
        int[] count = new int[n + 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n + 1 && i < in.length; i++) {
            count[in[i][0]]++;
            //用来反向查找
            map.put(in[i][1], in[i][0]);
        }
        int del = 0;
        int min = 0;
        while (del < n) {
            //删除的叶子节点对应位置用-1表示
            for (int i = 1; i < n + 1; i++) {
                //无边，叶子节点
                if (count[i] == 0) {
                    //找到和该边相连的节点
                    count[map.getOrDefault(i, 0)]--;
                    count[i]--;
                    del++;
                } else if (count[i] < 0) {
                    count[i]--;
                    min = Math.min(min, count[i]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            sb.append(count[i] - min + 1);
        }
        System.out.println(sb.toString());
    }
    /**
     * 5
     * 1 2
     * 1 3
     * 2 4
     * 2 5
     */
}
