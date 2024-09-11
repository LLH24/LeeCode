package GreedyAlgorithm;

public class JumpingGame {
    /***
     * 跳跃游戏
     * @param nums
     * @return
     * 只需要记录范围，不需要记录哪儿到哪儿
     */
    public boolean canJump(int[] nums) {
        int range = 0;
        for (int i = 0; i <= range; i++) {
            range = nums[i]+i > range ? nums[i]+i : range ;
            if (range >= nums.length-1) return true;
        }
        return false;
    }
}
