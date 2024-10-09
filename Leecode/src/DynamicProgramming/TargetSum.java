package DynamicProgramming;

public class TargetSum {
    /***
     * 目标和的方法总数
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (Math.abs(target) > sum) return 0;
        if ((target+sum)%2 !=0) return 0;
        int leftTarget = (target+sum)/2;

        int bp[][] = new int[nums.length][leftTarget+1];
        for (int i = 0; i < leftTarget+1; i++) {//横向
            bp[0][i] = 0;
        }
        if (nums[0] <= leftTarget)bp[0][nums[0]] = 1;
        for (int i = 0; i < nums.length; i++) {
            int zeroNumber = 0;
            for (int j = 0; j < i+1; j++) {
                if (nums[j] == 0) zeroNumber++;
            }
//            bp[i][0] = 2^zeroNumber;//这是位运算符
            bp[i][0] = (int) Math.pow(2,zeroNumber);
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < leftTarget+1; j++) {
                if (j >= nums[i]) bp[i][j] = bp[i-1][j] + bp[i-1][j-nums[i]];
                else bp[i][j] = bp[i-1][j];
            }
        }
        return bp[nums.length-1][leftTarget];
    }
}
