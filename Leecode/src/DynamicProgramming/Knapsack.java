package DynamicProgramming;

import java.util.Scanner;

public class Knapsack {
    /***
     * 背包问题1
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int bagweight = scanner.nextInt();

        int[] weight = new int[n];
        int[] value = new int[n];
        for (int i = 0; i < n; ++i) {
            weight[i] = scanner.nextInt();
        }
        for (int j = 0; j < n; ++j) {
            value[j] = scanner.nextInt();
        }
        int[][] bp = new int[n][bagweight+1];
        for (int i = 0; i < n; i++) {
            bp[i][0] = 0;
        }
        for (int i = 0; i < bagweight+1; i++) {
            if (i >= weight[0]) bp[0][i] = value[0];
            else bp[0][i] = 0;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < bagweight+1; j++) {
                int count = 0;
                if (j >= weight[i]) {//要带该i的
                    count = value[i] + bp[i-1][j-weight[i]];
                }//不带i和带i的比较
                bp[i][j] = Math.max(count,bp[i-1][j]);
            }
        }
        System.out.println(bp[n-1][bagweight]);
    }
}
