package DynamicProgramming;

import java.math.BigInteger;

public class DifferentPaths {
    /***
     * 不同路径
     * @param m
     * @param n
     * @return
     */
    //最简单的是用数学方法
//    public int uniquePaths(int m, int n) {
//        BigInteger countUp = BigInteger.valueOf(1);
//        BigInteger countDown = BigInteger.valueOf(1);
//        for (int i = m+n-2; i > n-1; i--) {
//            countUp = countUp.multiply(BigInteger.valueOf(i));
//        }
//        for (int i = 1; i <= m-1; i++) {
//            countDown = countDown.multiply(BigInteger.valueOf(i));
//        }
//        return countUp.divide(countDown).intValue();
//    }
    //动态规划
    public int uniquePaths(int m, int n) {
        int[][] bp = new int[m][n];
        for (int i = 0; i < m; i++) {
            bp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            bp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                bp[i][j] = bp[i][j-1] + bp[i-1][j];
            }
        }
        return bp[m-1][n-1];
    }

}
