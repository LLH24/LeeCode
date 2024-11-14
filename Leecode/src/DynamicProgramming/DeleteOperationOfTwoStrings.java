package DynamicProgramming;

public class DeleteOperationOfTwoStrings {
    /***
     * 两个字符串的删除工作
     * 用最长公共子序列去减
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        char[] charArray1 = word1.toCharArray();
        char[] charArray2 = word2.toCharArray();
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (charArray1[i-1] == charArray2[j-1]) dp[i][j] = dp[i-1][j-1]+1;
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return word1.length()+word2.length()-2*dp[word1.length()][word2.length()];
    }
}
