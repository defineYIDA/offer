package algorithm;

/**
 * @Author: zl
 * @Date: 2019/7/27 10:05
 */
public class zeroOnePackage {


    public static void main(String[] args) {
        /*int capacity = 10;//背包容量
        int[] values = {2, 3, 1, 4, 6, 5}; //物品价值
        int[] volume = {5, 6, 5, 1, 19, 7};//物品体积*/
        //--
        int capacity = 6;//背包容量
        int[] values = {1, 1, 1}; //物品价值
        int[] volume = {2, 4, 2};//物品体积
        //--
/*        int capacity = 4;//背包容量
        int[] values = {1500, 3000, 2000,2000}; //物品价值
        int[] volume = {1, 4, 3,1};//物品体积*/
        //--
        zeroOnePackage zo = new zeroOnePackage();
        int res = zo.o1package3(values, volume, capacity);
        System.out.println(res);
    }


    public int o1package(int[] values, int[] volume, int capacity) {
        int size = values.length;
        int[][] F = new int[size + 1][capacity + 1];//状态方程
        //initArr(F);//初始化边界值，f[i][0] = 0，f[0][j] = 0

        for (int i = 1; i <= size; i++) {//当前商品为i - 1
            for (int v = 0; v <= capacity; v++) {//当前容量
                int prev = F[i - 1][v];//商品的上一个单元格的价值（最大价值）

                //当前可用容量大于该物品容量，则比较如下二者的最大值：
                //1）和上一个单元格的最大价值temp
                //2）当前单元格的价值+剩余空间的最大价值
                if (v >= volume[i - 1]) {
                    int now = values[i - 1] + F[i - 1][v - volume[i - 1]];//2)
                    F[i][v] = prev < now ? now : prev;
                } else
                    F[i][v] = prev;
            }
        }
        printfArr(F);
        return F[size][capacity];
    }

    private void initArr(int[][] f) {
        for (int i = 0; i < f.length; i++) {
            f[i][0] = 0;
        }
        for (int j = 1; j < f[0].length; j++) {
            f[0][j] = Integer.MIN_VALUE;
        }
    }
    private void printfArr(int[][] f) {
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f[0].length; j++) {
                System.out.print(f[i][j] + "-");
            }
            System.out.println();
        }
    }
    //优化空间复杂度为O(cap + 1)
    public int o1package1(int[] values, int[] volume, int capacity) {
        int size = values.length;
        int[] F = new int[capacity + 1];//状态方程
        F[0] = 0;//初始化边界值，f[i][0] = 0，f[0][j] = 0

        for (int i = 1; i <= size; i++) {//当前商品为i - 1
            for (int v = capacity; v >= volume[i - 1]; v--) {
                F[v] = Math.max(F[v], values[i - 1] + F[v - volume[i - 1]]);
            }
            /*for (int v = capacity; v >= 0; v--) {//当前容量
                int prev = F[v];//商品的上一个单元格的价值（最大价值）

                //当前可用容量大于该物品容量，则比较如下二者的最大值：
                //1）和上一个单元格的最大价值temp
                //2）当前单元格的价值+剩余空间的最大价值
                if (v >= volume[i - 1]) {
                    int now = values[i - 1] + F[v - volume[i - 1]];//2)
                    F[v] = prev < now ? now : prev;
                }
            }*/
        }

        return F[capacity];
    }
    //完全背包
    public int o1package3(int[] values, int[] volume, int capacity) {
        int size = values.length;
        int[] F = new int[capacity + 1];//状态方程
        F[0] = 0;//初始化边界值，f[i][0] = 0，f[0][j] = 0
        for (int i = 1; i <= size; i++) {//当前商品为i - 1
            for (int v = volume[i - 1]; v <= capacity; v++) {
                F[v] = Math.max(F[v], values[i - 1] + F[v - volume[i - 1]]);
            }
        }
        return F[capacity];
    }
    //必须装满
    public int o1package2(int[] values, int[] volume, int capacity) {
        int size = values.length;
        int[][] F = new int[size + 1][capacity + 1];//状态方程
        initArr(F);//初始化边界值，f[i][0] = 0，f[0][j] = Integer.MIN_VALUE;

        for (int i = 1; i <= size; i++) {//当前商品为i - 1
            for (int v = 0; v <= capacity; v++) {//当前容量
                int prev = F[i - 1][v];//商品的上一个单元格的价值（最大价值）

                //当前可用容量大于该物品容量，则比较如下二者的最大值：
                //1）和上一个单元格的最大价值temp
                //2）当前单元格的价值+剩余空间的最大价值
                if (v >= volume[i - 1]) {
                    int now = values[i - 1] + F[i - 1][v - volume[i - 1]];//2)
                    F[i][v] = prev < now ? now : prev;
                } else
                    F[i][v] = prev;
            }
        }
        printfArr(F);
        return F[size][capacity];
    }
}
