package DynamicProgramming;

public class TheBestTimeToBuyAndSellStocksII {
    /***
     * 最佳卖股票时机II
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int[] dp = new int[2];
        dp[0] = -prices[0];//持有股票
        dp[1] = 0;//不持有股票
        for (int i = 1; i < prices.length; i++) {
            dp[0] = Math.max(dp[0],dp[1]-prices[i]);//后面一天持有股票
            dp[1] = Math.max(dp[1],dp[0]+prices[i]);

        }
        return dp[1];
    }
}
