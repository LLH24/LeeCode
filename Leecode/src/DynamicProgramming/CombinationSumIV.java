package DynamicProgramming;

public class CombinationSumIV {
    /***
     * 物品为外循环，物品只能是从小到大排列，所以是组合
     * 物品内循环，每次都会尝试不同的物品，是排列
     * 组合综合
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        int dp[] = new int[target+1];//dp【i】，当前i容量下的，排列数量
        dp[0] = 1;
        for (int i = 1; i < target+1; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]){
                    dp[i] += dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }
}
