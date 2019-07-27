package leetcode;

/**
 * @Author: zl
 * @Date: 2019/7/26 9:44
 */
public class Pro468 {
    public String validIPAddress(String IP) {
        if (IP == null) {
            return "Neither";
        }
        String[] strArr = IP.split("\\.");
        int len = strArr.length;
        //ipv4：32位 分为255:255:255:255
        //ipv6：128位 8个
        String res = "Neither";
        if (len == 4) {
            res = isIPV4(strArr);
        } else if (len == 8) {
            res = isIPV6(strArr);
        } else {
            return "Neither";
        }
        return res;
    }
    private String isIPV4(String[] ipArr) {
        for (int i = 0; i < ipArr.length; i++) {
            char[] arr = ipArr[i].toCharArray();
            int len = arr.length;
            if (len == 0 || len > 3)
                return "Neither";
            if (arr[0] == '0' && len != 1)
                return "Neither";
            for (int j = 0; i < len; i++) {
                if (arr[j] < '0' || arr[j] > '9')
                    return "Neither";
            }
            //<=255
            if (Integer.valueOf(ipArr[i]) > 255) {
                return "Neither";
            }
        }
        return "IPv4";
    }
    private String isIPV6(String[] ipArr) {
        return "IPv6";
    }
    public static void main(String[] args){
        Pro468 p = new Pro468();
        p.validIPAddress("172.16.254.1");
    }
}
