package DynamicProgramming;

import java.util.Arrays;

public class LongestRepeatedSubarray {
    /***
     * 最长重复子数组
     * @param nums1
     * @param nums2
     * @return
     */
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        int res = 0;
        for (int i = 1; i < nums1.length+1; i++) {
            for (int j = 1; j < nums2.length+1; j++) {
                if (nums1[i-1] == nums2[j-1]) {
                    if (i>1 && j >1 &&nums1[i - 2] == nums2[j - 2]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                    res = Math.max(res,dp[i][j]);
                }
            }
        }
        return res;
    }
}
