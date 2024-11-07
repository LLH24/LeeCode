package DynamicProgramming;

public class DetermineSubsequence {
    /***
     * 判断子序列
     * @param s
     * @param t
     * @return
     */

    //动态规划的时间是i*j，而双指针只需要i+j；
    public boolean isSubsequence(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        char[] charArray1 = s.toCharArray();
        char[] charArray2 = t.toCharArray();
        for (int i = 1; i < s.length()+1; i++) {
            for (int j = 1; j < t.length()+1; j++) {
                if (charArray1[i-1] ==  charArray2[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = dp[i][j-1];
            }
        }
        return dp[s.length()][t.length()] == s.length()?true:false;
    }
}
