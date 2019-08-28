package leetcode;

/**
 * @Author: zl
 * @Date: 2019/8/28 9:35
 */
public class Pro4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        //中位数的位置
        if (((len1 + len2) & 1) == 0) {
            int m = ((len1 + len2) >> 1);
            int n1 = 0, n2 = 0;
            int l = 0, r = 0;
            while (n1 < len1 || n2 < len2) {
                int c1 = n1 < len1 ? nums1[n1] : Integer.MAX_VALUE;
                int c2 = n2 < len2 ? nums2[n2] : Integer.MAX_VALUE;
                if (c1 <= c2) {
                    n1++;
                    m--;
                    if (m == 0) {
                        l = c1;
                    } else if (m == -1) {
                        r = c1;
                        break;
                    }
                } else {
                    n2++;
                    m--;
                    if (m == 0) {
                        l = c2;
                    } else if (m == -1) {
                        r = c2;
                        break;
                    }
                }
            }
            return (float)(l + r) / 2;
        } else {
            //奇数
            int m = ((len1 + len2) >> 1) + 1;
            int n1 = 0, n2 = 0;
            while (n1 < len1 || n2 < len2) {
                int c1 = n1 < len1 ? nums1[n1] : Integer.MAX_VALUE;
                int c2 = n2 < len2 ? nums2[n2] : Integer.MAX_VALUE;
                if (c1 <= c2) {
                    n1++;
                    m--;
                    if (m == 0) {
                        return c1;
                    }
                } else {
                    n2++;
                    m--;
                    if (m == 0) {
                        return c2;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Pro4 p = new Pro4();
        int[] a1 =  {};
        int[] a2 = {2,3};
        System.out.println(p.findMedianSortedArrays(a1, a2));
    }
}
