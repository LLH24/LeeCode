package DynamicProgramming;

public class LongestCommonSubsequence {
    /***
     * 最长公共子序列
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        char[] charArray1 = text1.toCharArray();
        char[] charArray2 = text2.toCharArray();
        int[][] dp = new int[charArray1.length+1][charArray2.length+1];
        for (int i = 1; i < text1.length()+1; i++) {
            for (int j = 1; j < text2.length()+1; j++) {
                if(charArray1[i-1] == charArray2[j-1]) dp[i][j] = dp[i-1][j-1]+1;
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[charArray1.length][charArray2.length];
    }
}
