package subject;

/**
 * @Author: zl
 * @Date: 2019/5/30 9:39
 */
public class Pro58 {

    public static void main(String[] var) {
        System.out.println(ReverseSentence("I am a student."));
    }
    /**
     *题：翻转字符串
     *     思路：
     *         先反转所有的字符串，然后在反转单词
     *
     */
    public static String ReverseSentence(String str) {
        if (str == null) {
            return str;
        }
        char[] strArr = str.toCharArray();
        int s = 0;
        int e = strArr.length - 1;
        //翻转所有的字符串
        reverse(strArr, s, e);
        reverseWord(strArr);
        return String.valueOf(strArr);
    }

    private static void reverseWord(char[] str) {
        if (str == null) {
            return;
        }
        //再翻转每个单词
        int s = 0;
        int e = 0;
        //注意这里e==length要进行判断
        //例如只有一个单词的情况，当 == length额，要进行翻转
        while (s < str.length && e <= str.length) {
            if (e != str.length && str[s] == ' ') {
                s++;
                e++;
            } else if (e == str.length || str[e] == ' ') {
                //这里对e--，因为e指向的是一个单词后的空格，或者e == length
                e--;
                reverse(str, s, e);
                e++;
                s = e;
            } else {
                e++;
            }
        }
    }
    private static void reverse(char[] str, int s, int e) {
        if (s == e) {
            return;
        }
        while (s < e) {
            char temp = str[s];
            str[s] = str[e];
            str[e] = temp;
            s++;
            e--;
        }
    }
}
