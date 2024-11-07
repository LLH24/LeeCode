package DynamicProgramming;

public class DifferentSubsequences {
    /***
     * 不同的子序列
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();
        int[][] dp = new int[charArrayS.length+1][charArrayT.length+1];
        for (int i = 0; i < charArrayS.length+1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < charArrayS.length+1; i++) {
            for (int j = 1; j < charArrayT.length+1; j++) {
                if (charArrayS[i-1] == charArrayT[j-1])  dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                else {
                    //最后一个值不相等，那就只用去匹配前面的，相当于删除了
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[charArrayS.length][charArrayT.length];
    }
}
