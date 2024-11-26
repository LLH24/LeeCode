package Hot100;

import java.util.LinkedList;
import java.util.List;

public class JuZheng {
    /***
     * 矩阵置零
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int[] row = new int[matrix.length];
        int[] column = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    column[j] = 1;
                }
            }
        }
        for (int i = 0; i < row.length; i++) {
            if (row[i] == 1) {
                for (int j = 0; j < column.length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 0; j < column.length; j++) {
            if (column[j] == 1) {
                for (int i = 0; i < row.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /***
     * 螺旋矩阵
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        LinkedList<Integer> integers = new LinkedList<>();
        int number = matrix[0].length * matrix.length;
        int i = 0;
        int j = 0;
        number--;
        integers.add(matrix[i][j]);
        matrix[i][j] = 101;
        while (true) {
            while (number > 0 && j < matrix[0].length - 1 && matrix[i][j + 1] != 101) {
                j++;
                number--;
                integers.add(matrix[i][j]);
                matrix[i][j] = 101;
            }

            while (number > 0 && i < matrix.length - 1 && matrix[i + 1][j] != 101) {
                i++;
                number--;
                integers.add(matrix[i][j]);
                matrix[i][j] = 101;
            }

            while (number > 0 && j > 0 && matrix[i][j - 1] != 101) {
                j--;
                number--;
                integers.add(matrix[i][j]);
                matrix[i][j] = 101;
            }

            while (number > 0 && i > 0 && matrix[i - 1][j] != 101) {
                i--;
                number--;
                integers.add(matrix[i][j]);
                matrix[i][j] = 101;
            }
            if (number <= 0) break;
        }
        return integers;
    }

    /***
     * 旋转图形
     * @param matrix
     */

    public void rotate(int[][] matrix) {
        //翻转后的矩阵公式
        //原来为（i,j）
        //现在
        // j = n-1-i;i = j;
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {//-1很重要
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }
    }

    //搜索二维数组
    //真天才，解法
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;
        while (i != matrix.length - 1 && j != 0) {
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }

        if (i == matrix.length - 1) {
            while (true) {
                if (matrix[i][j] == target) return true;
                if ( j == 0)return false;
                j--;
            }
        } else if (j == 0) {
            while (true) {
                if (matrix[i][j] == target) return true;
                if (i == matrix.length-1) return false;
                i++;
            }
        }
        return false;
    }
}