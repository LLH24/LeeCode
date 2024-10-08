package DynamicProgramming;

public class SegmentationAndSubsets {
    /***
     * 分割等和子集
     * 用0-1背包的方式实现
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        if (nums.length == 0) return false;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) return false;
        int target =  sum/2;
        int[] bp = new int[target+1];
        for (int i = 0; i < target+1; i++) {
            bp[i] = 0;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= 0; j--) {
                if (j >= nums[i]) bp[j]  = Math.max( bp[j],bp[j - nums[i]] + nums[i]);
                if (j == target && bp[j] == target) return true;
            }
        }
        return false;
    }
}
