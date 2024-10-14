package DynamicProgramming;

import java.util.Scanner;

public class ClimbingStairsII {
    /***
     * 爬楼梯（进阶版）
     */
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int m, n;
        while (sc.hasNextInt()) {
            // 从键盘输入参数，中间用空格隔开
            n = sc.nextInt();//n为总高度
            m = sc.nextInt();//m为每次最高度

            // 求排列问题，先遍历背包再遍历物品
            int[] bp = new int[n+1];
            bp[0] = 1;
            for (int i = 1; i < n+1; i++) {
                for (int j = 1; j <= m; j++) {
                    if (i >= j) bp[i] += bp[i-j];
                }
            }
            System.out.println(bp[n]);
        }
    }
}
