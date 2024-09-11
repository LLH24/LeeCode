package GreedyAlgorithm;

public class MaximumSubarray {
    /***
     * 最大子数组和
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int countSum = 0;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            countSum += nums[i];
            if (countSum > result) result = countSum;
            if (countSum < 0) countSum = 0;
        }
        return result;
    }
}
