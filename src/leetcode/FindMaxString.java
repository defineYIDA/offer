package leetcode;

/**
 * @Author: zl
 * @Date: 2019/7/25 9:54
 */
public class FindMaxString {

    public static void main(String[] args) {
        FindMaxString findMaxString = new FindMaxString();
        findMaxString.maxNumStr("abcd123450000000001ed125ss123456789aa123456");
    }

    /**
     * 题目来源：https://www.nowcoder.com/discuss/205655?type=0&order=0&pos=47&page=2
     * 描述：寻找字符串中最长的数字串
     * abcd12345ed125ss123456789aa123456 输出：123456789
     */
    public void maxNumStr(String str) {
        if (str == null) {
            return;
        }
        char[] strArr = str.toCharArray();
        int len = strArr.length;
        //用来可能的结果
        int sIndex = 0, eIndex = 0, length = 0;
        //当前遍历的数字串
        int sCur = 0, eCur = 0;
        for (int i = 0; i < len; i++) {
            //is number
            if (strArr[i] >= '0' && strArr[i] <= '9') {
                if (sCur == 0) {
                    sCur = i;
                    eCur = i;
                }
                eCur++;
            } else {
                int l = eCur - sCur + 1;
                if (l > length) {
                    sIndex = sCur;
                    eIndex = eCur;
                    length = l;
                }
                sCur = 0;
                eCur = 0;
            }
        }
        for (int j = sIndex; j < eIndex; j++) {
            System.out.print(strArr[j]);
        }
    }
}
