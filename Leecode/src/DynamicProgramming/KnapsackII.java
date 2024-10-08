package DynamicProgramming;

import java.util.Scanner;

public class KnapsackII {
    /***
     * 背包问题第二种解法
     * 只用一种方式
     * 覆盖实现
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

        int[] bp = new int[bagweight+1];//bp代表存在当前物品当前容量下的最大值

        for (int i = 0; i < bagweight+1; i++) {
            bp[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = bagweight; j >= 0; j--) {
                if (j >= weight[i]) bp[j] = Math.max(bp[j],bp[j- weight[i]]+ value[i]);
            }
        }
        System.out.println(bp[bagweight]);
    }
}
