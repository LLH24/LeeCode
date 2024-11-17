package DynamicProgramming;

public class LongestPalindromeSubsequence {
    /***
     *最大回文子序列
     * 注意顺序，必须得是左，左下，下，最先，然后才是自己
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        char[] charArray = s.toCharArray();
        int[][] dp = new int[charArray.length][charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            dp[i][i] = 1;
        }


        for (int k = 1; k <charArray.length; k++) {
            for (int j = k; j < charArray.length; j++) {
                int i = j - k;
                if (charArray[i] != charArray[j])
                    dp[i][j] = Math.max(dp[i][j - 1], Math.max(dp[i + 1][j - 1], dp[i + 1][j]));
                else {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }
            }
        }
        return dp[0][charArray.length - 1];
    }
}
