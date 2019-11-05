package interview.五八;

import java.util.Scanner;

/**
 * @Author: zl
 * @Date: 2019/9/21 21:08
 */
public class wuba {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        pro1(Integer.valueOf(sc.nextLine()));
    }
    public static void pro1(int num) {
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int temp = num % 27;
            if (temp < 10) {
                sb.append(temp);
            } else {
                sb.append(getChar(temp - 10));
            }
            num = num / 27;
        }
        System.out.println(sb.reverse().toString());
    }

    private static char getChar(int n) {
        if (n == 0)
            return '`';
        if (n == 1)
            return '!';
        if (n == 2)
            return '@';
        if (n == 3)
            return '#';
        if (n == 4)
            return '$';
        if (n == 5)
            return '%';
        if (n == 6)
            return '^';
        if (n == 7)
            return '&';
        if (n == 8)
            return '*';
        if (n == 9)
            return '(';
        if (n == 10)
            return ')';
        if (n == 11)
            return '{';
        if (n == 12)
            return '}';
        if (n == 13)
            return '\\';
        if (n == 14)
            return '<';
        if (n == 15)
            return '>';
        if (n == 16)
            return '?';
        return '-';
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] arr = s.split(" ");
        int[] nums = new int[200];
        for (int i = 0; i < 200; i++) {
            nums[i] = Integer.valueOf(arr[i]);
        }
        pro2(nums);
    }
    public static void pro2(int[] nums) {
        int[] hash = new int[101];
        for (int i = 0; i < nums.length; i++) {
            hash[nums[i]]++;
        }
        //即198耗时小于TP99
        int count = 0;
        int i = 0;
        while (count < 198) {
            count += hash[i];
            i++;
        }
        System.out.println(i -1);
    }

    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        pro3(sc.nextLine());
    }
    public static void pro3(String email) {
        if (email == null || "".equals(email)) {
            return;
        }
        String[] arr = email.split("@");
        StringBuilder sb = new StringBuilder();
        String name = arr[0];
        for (int i = 0; i < name.length(); i++) {
            sb.append(name.charAt(i));
            if (i == name.length() - 1)
                break;
            if ((i % 4) == 0)
                sb.append("M");
            else if ((i % 4) == 1)
                sb.append("A");
            else if ((i % 4) == 2)
                sb.append("S");
            else
                sb.append("K");
        }
        sb.append("@").append(arr[1]);
        System.out.println(sb.toString());
    }
}
