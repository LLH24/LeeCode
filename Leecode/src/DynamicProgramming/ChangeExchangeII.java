package DynamicProgramming;

public class ChangeExchangeII {
    /***
     * 零钱兑换
     * 是一个完全背包问题
     * 完全背包就是不限制数量
     * 0-1背包，是从后往前遍历，防止多次同一物品添加
     * 完全背包，从前往后，可以多次同一物品添加
     */
    /***
     * 这是一维法，可以有二维法
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        int[] bp = new int[amount+1];
        bp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j < amount+1; j++) {
                if (j >= coins[i]) bp[j] = bp[j] + bp[j-coins[i]];
            }
        }
        return bp[amount];
    }

}
