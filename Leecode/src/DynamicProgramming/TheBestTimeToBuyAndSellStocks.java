package DynamicProgramming;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class TheBestTimeToBuyAndSellStocks {
    /***
     * 买卖股票的最佳时机
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int[] dp = new int[2];
        dp[0] = -prices[0];
        dp[1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[1] = Math.max(dp[1],dp[0]+prices[i]);
            dp[0] = Math.max(dp[0],-prices[i]);
        }
        return dp[1];
    }
}
