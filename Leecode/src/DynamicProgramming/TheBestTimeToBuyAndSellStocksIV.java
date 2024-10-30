package DynamicProgramming;

public class TheBestTimeToBuyAndSellStocksIV {
    /***
     * 最佳卖股票时机IV
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        int[] dp = new int[2*k+1];

        for (int i = 1; i < dp.length; i++) {
            if (i%2 == 1) dp[i] = -prices[0];
            else dp[i] = 0;
        }
        //1买 , 2卖
        for (int j = 1; j < prices.length; j++) {
            for (int i = dp.length-1; i >0 ; i--) {
                if (i%2 == 0) dp[i] = Math.max(dp[i],dp[i-1]+prices[j]);
                else dp[i] = Math.max(dp[i],dp[i-1]-prices[j]);
            }
        }
        return dp[2*k];
    }
}
