package DynamicProgramming;

public class IntegerPartition {
    /***
     * 整数拆分
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        int[] bp = new int[n+1];
        bp[0] = 0;
        bp[1] = 0;
        bp[2] = 1;
        for (int i = 3; i < n+1; i++) {
            for (int j = 1; j < i; j++) {
                bp[i] = Math.max(bp[i], Math.max(j*(i-j),j*bp[i-j]));
            }
            //举个例子，比如4，可以拆分为1，3  2，2 3,1 其中3也可以是别的合成的最大值，2，1同理
        }
        return bp[n];
    }
}
