package DynamicProgramming;

public class ClimbStairs {
    /***
     * 爬楼梯
     * 递归真的很有意思啊
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int[] bp = new int[n+1];
        bp[1] = 1;
        if (n>1)  bp[2] = 2;

        for (int i = 3; i < n+1; i++) {
            bp[i] = bp[i-1] + bp[i-2];
        }
        return bp[n];
    }
}
