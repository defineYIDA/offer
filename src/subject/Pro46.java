package subject;

/**
 * @Author: zl
 * @Date: 2019/7/22 9:09
 */
public class Pro46 {
    public static void main(String[] args) {
        int test = 122589;//result = 5
        Pro46 p = new Pro46();
        System.out.println(p.getTranslationCount(12258));
    }

    public int getTranslationCount(int num) {
        String numStr = String.valueOf(num);
        char[] numCharArr = numStr.toCharArray();
        int[] counts = new int[numCharArr.length + 1];
        counts[numCharArr.length] = 1;
        counts[numCharArr.length - 1] = 1;//从最后一位开始的翻译方式为1种
        getTranslationCore(numCharArr, numCharArr.length - 2, counts);
        return counts[0];
    }

    public void getTranslationCore(char[] arr, int i, int[] counts) {
        if (i < 0) {
            return;
        }
        //判断i和i+1组成的值是否属于[10, 25]
        if (canTrans(arr, i)) {
            counts[i] = counts[i + 1] + counts[i + 2];
        } else {
            counts[i] = counts[i + 1];
        }
        i--;
        getTranslationCore(arr, i, counts);
    }

    private boolean canTrans(char[] arr, int i) {
        if (i > arr.length - 2) {
            return false;
        }
        if (arr[i] == '1') {
            return true;
        }
        return arr[i] == '2' && arr[i + 1] <= '5';
    }
}
