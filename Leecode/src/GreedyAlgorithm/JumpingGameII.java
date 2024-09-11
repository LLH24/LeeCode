package GreedyAlgorithm;

public class JumpingGameII {
    /***
     * 跳跃游戏II
     * 只需要记录步数，也不需要知道是哪儿到哪儿
     * 只需要记录每一步能到达的最大值，超过则加步数。
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int rang = 0;
        int maxrang = 0;
        int step = 0;
        if(nums.length == 1 ) return 0;
        for (int i = 0; i <= rang; i++) {
            if (i > maxrang){
                step++;
                maxrang = rang;
            }
            rang = nums[i] + i > rang ? nums[i] + i : rang;
            if (rang >= nums.length-1) return step+1;
        }
        return step;
    }
}
