package subject;

/**
 * @Author: zl
 * @Date: 2019/5/26 22:37
 */
public class Pro50 {

    private int[] str = new int[256];
    int count = 1;
    //如果只使用一个数组来记录出现的次数则字符流没有记录顺序
    //所以并不能找到第一个出现的
    //如果考虑使用char[]，那么长度不好定义
    //可以使用数组的具体值来存储是否是唯一
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if (str[ch] == 0) {//第一次出现
            str[ch] = count;
            count++;
        } else if (str[ch] > 0) {//不是第一次出现
            str[ch] = -1;
        }

    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        //找到最小的count值
        int res = count - 1;
        char ch = '#';
        for (int i = 0; i < 256; i++) {
            if (res >= str[i] && str[i] > 0) {
                res = str[i];
                ch = (char)i;
            }
        }
        return ch;
    }
}
