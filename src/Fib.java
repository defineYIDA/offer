/**
 * @Author: zl
 * @Date: 2019/5/6 17:30
 */
public class Fib {



    public static void main(String[] var) {

        System.out.println(JumpFloor(3));
    }
    public static int JumpFloor(int target) {
        //jump(0,target);
        //return ways;
        int[] res = {0,1,2};
        if (target <= 2) {
            return res[target];
        }
        return JumpFloor(target - 1) + JumpFloor(target - 2);

    }
    static int ways = 0;

    public static void jump(int fCount, int target) {
        if (fCount >= target) {
            if (fCount == target) {
                ways++;
            }
            return ;
        }
        for (int i = 0; i <= 1; i++) {
            //应该将运算写在传参的位置，不然fcount递归调用会相互影响
            jump(fCount + i + 1, target);
        }
    }

    /**
     * 最优解
     * 关于递归和迭代的效率比较：
     * 一般迭代的效率高于递归，
     * 而递归的思路比较清晰
     * @param target
     * @return
     */
    public int JumpFloor1(int target) {
        //jump(0,target);
        //return ways;
        //return JumpFloor(target - 1) + JumpFloor(target - 2);
        int[] res = {0,1,2};
        if (target <= 2) {
            return res[target];
        }
        int fib2 = 1;
        int fib1 = 2;
        int ways = 0;
        //注意从3开始
        for (int i=3; i <= target; i++) {
            ways = fib1 + fib2;
            fib2 = fib1;
            fib1 = ways;
        }
        return ways;
    }

}
