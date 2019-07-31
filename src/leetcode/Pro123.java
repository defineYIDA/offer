package leetcode;

import java.util.Arrays;

/**
 * @Author: zl
 * @Date: 2019/7/31 10:38
 */
public class Pro123 {
    public int maxProfit(int[] prices) {
        /**
         对于任意一天考虑四个变量:
         fstBuy: 在该天第一次买入股票可获得的最大收益
         fstSell: 在该天第一次卖出股票可获得的最大收益
         secBuy: 在该天第二次买入股票可获得的最大收益
         secSell: 在该天第二次卖出股票可获得的最大收益
         分别对四个变量进行相应的更新, 最后secSell就是最大
         收益值(secSell >= fstSell)
         **/
        int fstBuy = Integer.MIN_VALUE, fstSell = 0;
        int secBuy = Integer.MIN_VALUE, secSell = 0;
        for(int p : prices) {
            fstBuy = Math.max(fstBuy, -p);//股票价格的最小值
            fstSell = Math.max(fstSell, fstBuy + p);//股票卖出一次的最大利润
            secBuy = Math.max(secBuy, fstSell - p);//在当前第一次卖出为最大利润的前提下，寻找第二次卖出的最大值【股票价格最小值到当前值的利润】
            secSell = Math.max(secSell, secBuy + p);//计算最大利润
        }
        //再理思路：由于计算递增区间内的最大值不能正确的解决该问题
        //原因在于：【1，2，4，2，5，7，2，4，9，0】类似区间，最大值不是3，5，7中选两最大值，而是6，7
        //所以需要即即计算区间的最大值，还得考虑后序情况
        //所以每一次记录遍历到的最小值，fstBuy
        //到当前点时的最大利润，例如当前遍历到【1，2，4，2】那么 fstBuy=1，fstSell=3（期间区间的最大值）
        //secBuy也就意味着：【1，2，4】的利润==3==fstSell，那么secBuy为第二个区间的最小值
        //secSell，最大利润
        return secSell;
    }





    //错误。。。。。。。。。。。。
    public int maxProfit1(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        //思路，按照前面不限买卖次数的做法，计算每个递增区间的利润
        //任何比较出最大的两个利润相加【错误】
        //因为只能买卖两次就不一定是在递增区间
        int low = prices[0];
        int high = prices[0];
        int[] profits = new int[len];
        int cur = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] >= high) {
                high = prices[i];
            } else {
                profits[cur++] = high - low;
                low = prices[i];
                high = prices[i];
            }
        }
        profits[cur] = high - low;

        //找到最大的两值
        Arrays.sort(profits);
        return profits[len - 1] + profits[len - 2];
    }
}
