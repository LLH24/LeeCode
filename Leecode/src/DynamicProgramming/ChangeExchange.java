package DynamicProgramming;

public class ChangeExchange {
    /***
     * 零钱兑换
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] bp = new int[amount+1];//bp是最少个数
        bp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j < amount+1; j++) {//除了bp【0】=0是合法的，其他都不合法
                if (j == coins[i])bp[j] = 1;
                else if (j > coins[i]) {
                    if (bp[j - coins[i]] == 0 && bp[j] == 0) bp[j] = 0;
                    else if (bp[j] == 0 && bp[j - coins[i]] != 0) bp[j] = bp[j - coins[i]]+1;
                    else if (bp[j] != 0 && bp[j - coins[i]] != 0) bp[j] = Math.min(bp[j],bp[j - coins[i]]+1);
                }
            }
        }
        if (amount != 0 && bp[amount] == 0)return -1;
        return bp[amount];
    }
}
