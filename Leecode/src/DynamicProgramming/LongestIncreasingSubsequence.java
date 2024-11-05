package DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    /***
     * 最长递增子序列
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int res= 1;//记录最大值
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res,dp[i]);
        }
//        最大值不一定在最后
//        return dp[nums.length-1];
        return res;
    }
}
