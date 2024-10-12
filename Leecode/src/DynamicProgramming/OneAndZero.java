package DynamicProgramming;

public class OneAndZero {
    /**
     * 1和0
     * 选一个最大的子集，同时满足1和0的要求
     * 我觉着这可以说是10背包的3维版本
     * 本来是一维物品，一维容量
     * 现在变味了二维容量，一维物品，相当于变成了三维
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] bp = new int[m+1][n+1];
        for (String str : strs) {
            int oneNumber = 0;
            int zeroNumber = 0;
            char[] charArray = str.toCharArray();
            for (char c : charArray) {
                if (c == '0') zeroNumber++;
                else oneNumber++;
            }
            for (int i = m; i >= zeroNumber ; i--) {
                for (int j = n; j >= oneNumber ; j--) {
                    bp[i][j] = Math.max(bp[i][j],bp[i-zeroNumber][j-oneNumber]+1);
                }
            }

        }
        return bp[m][n];
    }
}
