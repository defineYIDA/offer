package subject;

/**
 * @Author: zl
 * @Date: 2019/5/31 19:26
 */
public class Pro60 {

    public static void main(String[] var) {
        printProbability(6);
    }

    static int max = 6;

    public static void printProbability(int num) {
        if (num < 1)
            return;
        int length = max * num + 1;
        int[][] probabilities  = new int[2][length];
        for (int i = 0; i < length; i++) {
            probabilities[0][i] = 0;
            probabilities[1][i] = 0;
        }
        //标识当前使用的是那个数组
        int flag = 0;
        //抛出一个骰子时的各种情况
        for (int i = 1; i <= max; i++) {
            probabilities[flag][i] = 1;
        }
        //抛出k个骰子，所有和的可能
        for (int k = 2; k <= num; k++) {
            //如果抛出k个骰子，那么和为[0,k-1]的出现次数为0
            for (int i = 0; i < k; i++) {
                probabilities[1 - flag][i] = 0;
            }

            //probabilities-n[n] = probabilities-n-1[n-1] + .....+probabilities-n-1[n-6]

            //抛出k个骰子，所有和的可能
            for (int i = k; i < length; i++) {
                probabilities[1 - flag][i] = 0;

                //每个骰子的出现的所有可能的点数
                for (int j = 1; j <= i && j <= max; j++) {
                    //统计出和为i的点数出现的次数
                    probabilities[1 - flag][i] += probabilities[flag][i - j];
                }
            }
            flag = 1 - flag;
        }
        //计算概率
        double total = 1;
        for (int i = 0; i < num; i++) {
            total *= max;
        }

        for (int i = num; i < length; i++) {
            double ratio = probabilities[flag][i] / total;
            System.out.printf("%-8.4f", ratio);
        }
        System.out.println();

    }
}
