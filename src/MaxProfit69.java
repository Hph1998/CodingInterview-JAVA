/**
 * 股票的最大利润
 * @author Lucas
 * @date 2021/03/23 17:39
 */
public class MaxProfit69 {

    /*public int maxProfit(int[] prices) {
        // 买不了就0
        int res = 0;
        for (int i = 0; i < prices.length; i++){
            for (int j = i + 1; j < prices.length; j++){
                // 遍历找到最大利润
                res = Math.max(res, prices[j] - prices[i]);
            }
        }
        return res;
    }*/

    public int maxProfit(int[] prices) {
        // 动态规划法
        int cost = Integer.MAX_VALUE;
        int profit = 0;
        for(int price : prices) {
            // 记录前i日最低值
            cost = Math.min(cost, price);
            // 前 i 日最大利润 dp[i] 等于前 i - 1 日最大利润 dp[i-1] 和第 i 日卖出的最大利润中的最大值。
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }

    public static void main(String[] args) {
        MaxProfit69 obj = new MaxProfit69();
        System.out.println(obj.maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
