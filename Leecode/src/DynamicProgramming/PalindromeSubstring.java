package DynamicProgramming;

public class PalindromeSubstring {
    /***
     *回文子串
     * 暴力解法是两个for
     * 其实用dp[][]也是两个for的量，i表示起始位置，j表示终止位置
     * 注意遍历的顺序
     */
    public int countSubstrings(String s) {
        char[] charArray = s.toCharArray();
        int[][] dp = new int[charArray.length][charArray.length];
        int count = charArray.length;

        for (int i = 0; i < charArray.length; i++) {
            dp[i][i] = 1;
        }

        for (int j = 1; j < charArray.length; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) dp[i][j] = 0;
                if (charArray[i] == charArray[j]){
                    if (j - i == 1) {
                        dp[i][j] = 1;
                        count++;
                    }else {
                        if(dp[i+1][j-1] == 1) {
                            dp[i][j] = 1;
                            count++;
                        }else dp[i][j] = 0;
                    }
                }
            }
        }
        return count;
    }
}
