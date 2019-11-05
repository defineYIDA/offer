package interview;

import java.math.BigDecimal;
import java.util.HashSet;

/**
 * @Author: zl
 * @Date: 2019/8/11 9:50
 */
public class Main {
    public static void main(String[] args) {
        double i = 1.9;
        double j = 0.9;
        BigDecimal d1 = new BigDecimal(Double.toString(1.9));
        BigDecimal d2 = new BigDecimal(Double.toString(0.9));
        System.out.println(i - j);
        System.out.println(d1.subtract(d2).doubleValue());
        //System.out.println(pro("huoprtewjgdaiuaidhaiu", "rtyhyrdokdhaidwhudah"));

        int[] arr = {1, 2, 4, 9, 10, 11, 25, 30};
        System.out.println(search(arr, 13));
    }
    private static String pro(String s1, String s2) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
            set.add(s1.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s2.length(); i++) {
            if (set.contains(s2.charAt(i))) {
                sb.append(s2.charAt(i));
            }
        }
        return sb.toString();
    }
    private static int search(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0, right = arr.length;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (mid == left || mid == right) {
                return arr[left] == target ? left : (arr[right] == target ? right : -1);
            } else if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return -1;
    }
}
