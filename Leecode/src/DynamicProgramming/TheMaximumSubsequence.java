package DynamicProgramming;

public class TheMaximumSubsequence {
    /***
     * 最大子序和
     * @param nums
     * @return
     */
//    public int maxSubArray(int[] nums) {
//        int countSum = 0;
//        int result = Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            countSum += nums[i];
//            if (countSum > result) result = countSum;
//            if (countSum < 0) countSum = 0;
//        }
//        return result;
//    }

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            res = Math.max(res,dp[i]);
        }
        return res;
    }

}
