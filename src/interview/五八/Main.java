package interview.五八;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Author: zl
 * @Date: 2019/10/13 19:58
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] strArr = line.split(" ");
        int[] arr = new int[Integer.valueOf(strArr[0])];
        int m = Integer.valueOf(strArr[1]);
        for (int i = 0; i < Integer.valueOf(strArr[0]); i++) {
            arr[i] = Integer.valueOf(strArr[i + 2]);
        }
        pro1(arr, m);
    }
    private static void pro1(int[] arr, int m) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);
        }
        for (int i = 1; i <= m; i++) {
            int f = minHeap.poll();
            int s = minHeap.poll();
            //找到f值最小的两条鱼（不能相等）
            int count = 0;
            while (f == s && !minHeap.isEmpty()) {
                count++;
                s = minHeap.poll();
            }

            minHeap.add(s + f);
            while (count != 0) {
                minHeap.add(f);
                count--;
            }
        }
        System.out.println(minHeap.peek());
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        pro3(Integer.valueOf(sc.nextLine()));
    }
    private static void pro3(int d) {
        if (d < 0) {
            return;
        }
        int[] dp = new int[d + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= d; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[d]);
    }
}
