package DynamicProgramming;

public class ClimbingStairsMinimalCost {
    /***
     * 爬楼梯最小花费
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int[] bp = new int[cost.length+1];
        bp[0] = 0;
        bp[1] = 0;
        for (int i = 2; i < bp.length; i++) {
            bp[i] = Math.min(bp[i-2] + cost[i-2],bp[i-1]+cost[i-1]);
        }
        return bp[cost.length];
    }
}
