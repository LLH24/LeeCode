package GreedyAlgorithm;

public class TheBestTimetoBuyandSellStocksII {
    /***
     * 买卖股票的最佳时机II
     * 真挺有意思哈
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int count = 0;
        for (int i = 0; i < prices.length-1; i++) {
            int nowCount = prices[i+1] - prices[i];
            if (nowCount > 0) count += nowCount;
        }
        return count;
    }
}
