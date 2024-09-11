package BacktrackingAlgorithm;

import java.util.HashMap;
import java.util.List;

public class Sudoku {
    /***
     * 数独
     * @param board
     */
    int[][] row = new int[10][10];
    int[][] col = new int[10][10];

    public void solveSudoku(char[][] board) {
        //必须要先对棋盘进行读取，才能进行有效剪枝
        readBoard(board);
        findResult(board);
    }

    public void readBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                char now = board[i][j];
                if (now != '.') {
                    row[i][now - '0'] = 1;
                    col[j][now - '0'] = 1;
                }
            }
        }
    }

    public Boolean isVaild(char[][] board,int i,int j,int k) {
        int starti = 3*(i/3);
        int startj = 3*(j/3);
        for (int l = starti; l < starti+3; l++) {
            for (int m = startj; m < startj+3; m++) {
                if (board[l][m] == (k+'0')){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean findResult(char[][] board) {
        //不需要终止条件，对每一行后的每一列进行遍历，直到结束
        for (int i = 0; i < board.length; i++) {//每一行
            for (int j = 0; j < board.length; j++) {//每一列，只是用来确定位置
                if (board[i][j] == '.'){
                    for (int k = 1; k < 10; k++) {//每个数进行讨论
                        if (row[i][k] == 0 && col[j][k] == 0 && isVaild(board,i,j,k)) {//讨论是否合法
                            row[i][k] = 1;
                            col[j][k] = 1;
                            board[i][j] = (char) ('0' + k);
                            if (findResult(board)){
                                return true;
                            }
                            row[i][k] = 0;
                            col[j][k] = 0;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                    //这里返回的意思是说，当前位置9个数都试过了，不行
                    //这一次递归就不行
                    //每一次递归，都是往下走一格
                    //说明这里放任何数都是错误的，那之前填的数就是错误的，就只能返回上一次递归
                }
            }
        }
        return true;//全部遍历完，就是说，全都有数了，那就是true了，算终止条件
    }
}








