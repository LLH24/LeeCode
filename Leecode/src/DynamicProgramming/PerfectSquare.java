package DynamicProgramming;

public class PerfectSquare {
    /***
     * 完全平方数
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int number = 0;
        int[] dp = new int[n+1];
        dp[0] = 0;
        for (int i = 1; i < n+1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }//这里可以优化到循环里面
        for (int i = 1; i <= n+1; i++) {
            if (Math.pow(i,2) > n) {
                number = i;
                break;
            } 
        }
        for (int i = 1; i < number; i++) {
            for (int j = (int) Math.pow(i,2); j < n+1; j++) {
//                    if ( dp[(int) (j-Math.pow(i,2))] != Integer.MAX_VALUE)
                        dp[j] = Math.min(dp[j],dp[(int) (j-Math.pow(i,2))]+1);
            }
        }
        return dp[n];
    }
}
