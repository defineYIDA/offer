package interview.腾讯;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: zl
 * @Date: 2019/9/20 20:44
 */
public class Main {
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = Integer.valueOf(sc.nextLine());
        for (int i = 0; i <  len; i++) {
            String length = sc.nextLine();
            String phoneNum = sc.nextLine();
            pro1(Integer.valueOf(length), phoneNum);
        }
    }
    private static void pro1(int len, String s) {
        if (s == null || "".equals(s) || len < 11) {
            System.out.println("NO");
            return;
        }
        int index = 0;
        while (index < len && s.charAt(index) != '8') {
            index++;
        }
        int l = len - index;
        if (l < 11) {
            System.out.println("NO");
            return;
        } else if (l == 11) {
            System.out.println("YES");
            return;
        }
        //第一个8到末尾，长度大于11
        System.out.println("YES");
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String[] arr = line1.split(" ");
        String line2 = sc.nextLine();
        String[] arr2 = line2.split(" ");
        long[] nums = new long[Integer.valueOf(arr[0])];
        for (int i = 0; i < Integer.valueOf(arr[0]); i++) {
            nums[i] = Integer.valueOf(arr2[i]);
        }
        pro1(nums, Integer.valueOf(arr[1]));
    }
    private static void pro1(long[] nums, int cycle) {
        if (nums.length == 0) {
            return;
        }
        int cur = 0;
        while (cycle > 0) {
            Arrays.sort(nums);
            while (cur < nums.length && nums[cur] == 0) {
                cur++;
            }
            if (cur == nums.length) {
                System.out.println(0);
                cycle--;
                continue;
            }
            long temp = nums[cur];
            System.out.println(temp);
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[i] = nums[i] - temp;
                }
            }
            cycle--;
            cur++;
        }
    }

    private static long findMin(long[] nums) {
        long min = Integer.MAX_VALUE;
        int count = 0;
        for (long n : nums) {
            if (n != 0)
                min = Math.min(min, n);
            else
                count++;
        }
        if (count == nums.length) {
            return 0;
        }
        return min;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        int len = Integer.valueOf(line1);
        int[][] nums = new int[len][];
        for (int i = 0; i < len; i++) {
            String line2 = sc.nextLine();
            String[] arr2 = line2.split(" ");
            int[] n = new int[Integer.valueOf(line2)];
            for (int j = 0; j < Integer.valueOf(line2); j++) {
                n[i] = Integer.valueOf(arr2[i]);
            }
            pro3(n);
        }
    }
    private static void pro3(int[] nums) {
        if (nums.length == 0) {
            System.out.println(" ");
            return;
        }
        int len = nums.length;
        Arrays.sort(nums);
        int arr1 = 0, arr2 = 0;
        int a = 0;
        for(int n : nums) {
            a += n;
        }
        System.out.println(a / 2 + " " + (a - a / 2));
    }
}
