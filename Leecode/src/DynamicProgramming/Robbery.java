package DynamicProgramming;

public class Robbery {
    /***
     * 打家劫舍1
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];//dp表示第几个屋子操作后的最大值
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {//i表示的是nums的下标
            dp[i+1] = Math.max(dp[i-1]+nums[i],dp[i]);
        }
        return dp[nums.length];
    }
}
