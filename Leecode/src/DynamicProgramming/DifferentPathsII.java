package DynamicProgramming;

public class DifferentPathsII {
    /***
     * 机器人不同路径二
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] bp = new int[obstacleGrid.length][obstacleGrid[0].length];
        int breakeRow = 0;
        int breakeLine = 0;
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 1) breakeRow++;//有障碍物
            if (breakeRow == 0) bp[0][i] = 1;
            else bp[0][i] = 0;
        }

        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1) breakeLine++;
            if (breakeLine == 0) bp[i][0] = 1;
            else bp[i][0] = 0;
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1)bp[i][j] = 0;
               else bp[i][j] = bp[i-1][j] + bp[i][j-1];
            }
        }
        return bp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
