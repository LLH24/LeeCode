package DynamicProgramming;

public class TheBestTimeToBuyAndSellStocksIII {
    /***
     * 最佳卖股票时机III
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int[] dp = new int[4];
        //dp[0],1,2,3
        //分别表示，同一天持有，不持有，第二次持有，第二次不持有
        dp[0] = -prices[0];
        dp[1] = 0;
        dp[2] = -prices[0];
        dp[3] = 0;
        for (int i = 1; i < prices.length; i++) {
            //好像反了
            dp[3] = Math.max(dp[3],dp[2]+prices[i]);
            dp[2] = Math.max(dp[2],dp[1]-prices[i]);
            dp[1] = Math.max(dp[1],dp[0]+prices[i]);
            dp[0] = Math.max(dp[0],-prices[i]);
        }

        return Math.max(dp[1],dp[3]);
    }
}
