package DynamicProgramming;

public class RobberyII {
    /***
     * 打家劫舍2
     */
//    public int rob(int[] nums) {//该方法被错误了，因为比如1,2,3这样
//        //我这算法是从左到右考量，但是其实，他可以只拿3，就是从右往左进行考量。
//        int[] dp = new int[nums.length+1];
//        dp[0] = 0;
//        dp[1] = nums[0];
//        int[] useOne = new int[nums.length+1];//是否使用了第一个，用了为1，不用为0
//        useOne[1] = 1;
//        for (int i = 1; i < nums.length; i++) {
//            if(i == nums.length-1){
//                if (useOne[nums.length-2] == 1) dp[nums.length] = dp[nums.length-1];
//                else  dp[nums.length] = Math.max(dp[nums.length-1],dp[nums.length-2]+nums[i]);
//                return dp[nums.length];
//            }
//            if (dp[i-1]+ nums[i] >= dp[i]){
//                dp[i+1] = dp[i-1]+ nums[i];
//                if (useOne[i-1] == 1) useOne[i+1] = 1;
//            }else {
//                dp[i+1] = dp[i];
//                if (useOne[i] == 1) useOne[i+1] = 1;
//            }
//        }
//        return dp[nums.length];
//    }

    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        //取前，不取后
        int[] dpOne = new int[nums.length + 1];//dp表示第几个屋子操作后的最大值
        dpOne[0] = 0;
        dpOne[1] = nums[0];
        for (int i = 1; i < nums.length-1; i++) {//i表示的是nums的下标
            dpOne[i+1] = Math.max(dpOne[i-1]+nums[i],dpOne[i]);
        }
        dpOne[nums.length] = dpOne[nums.length-1];
        //取后不取前
        int[] dpTwo = new int[nums.length + 1];//dp表示第几个屋子操作后的最大值
        dpTwo[0] = 0;
        dpTwo[1] = 0;
        for (int i = 1; i < nums.length; i++) {//i表示的是nums的下标
            dpTwo[i+1] = Math.max(dpTwo[i-1]+nums[i],dpTwo[i]);
        }
        return Math.max(dpOne[nums.length],dpTwo[nums.length]);
    }
}
