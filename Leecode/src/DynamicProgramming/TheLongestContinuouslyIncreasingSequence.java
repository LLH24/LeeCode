package DynamicProgramming;

import java.util.Arrays;

public class TheLongestContinuouslyIncreasingSequence {
    /***
     * 最长连续递增序列
     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int res = 1;
        for (int i = 1; i <nums.length ; i++) {
            if (nums[i] > nums[i-1]) dp[i] = dp[i-1]+1;
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
