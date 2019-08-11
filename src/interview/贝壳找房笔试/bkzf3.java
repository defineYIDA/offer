package interview.贝壳找房笔试;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Author: zl
 * @Date: 2019/8/11 10:23
 */
public class bkzf3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.valueOf(br.readLine().trim());
        int[] w = new int[count];
        for (int i = 0; i < count; i++) {
            w[i] = Integer.valueOf(br.readLine().trim());
        }
        System.out.println(count(w, count));
    }
    private static int count(int[] arr, int len) {
        if (len < 2) {
            return 0;
        }
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (arr[j] <= (arr[i] * 10 / 9)) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }
}
