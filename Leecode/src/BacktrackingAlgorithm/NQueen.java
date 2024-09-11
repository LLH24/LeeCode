package BacktrackingAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class NQueen {
    /***
     * N皇后问题,我很吊
     * @param n
     * @return
     */
    List<List<String>> results = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] checkerboard = new char[n][n];
        for (char[] c : checkerboard) {
            Arrays.fill(c, '.');
        }
        findResults(checkerboard, 0, new int[n]);
        return results;
    }

    public void findResults(char[][] checkerboard, int nowLevel, int[] used) {
        if (nowLevel == checkerboard.length) {//到了最后一层后再次递归后，开始返回结果
            ArrayList<String> oneResult = new ArrayList<>();
            for (char[] chars : checkerboard) {
                oneResult.add(String.copyValueOf(chars));
            }
            results.add(oneResult);
            return;
        }
        //每一行
        for (int j = 0; j < checkerboard.length; j++) {//每一列
            if (used[j] == 1) continue;
            if (isValid(checkerboard, nowLevel, j)) {
                checkerboard[nowLevel][j] = 'Q';
                used[j] = 1;
                findResults(checkerboard, nowLevel + 1, used);
                used[j] = 0;
                checkerboard[nowLevel][j] = '.';
            } else continue;
        }

    }

    public boolean isValid(char[][] checkerboard, int row, int col) {//检查斜对角线是否合法
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (checkerboard[i][j] == 'Q') return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j <= checkerboard.length - 1; i--, j++) {
            if (checkerboard[i][j] == 'Q') return false;
        }
        return true;
    }
}
