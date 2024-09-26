package DynamicProgramming;

public class FibonacciNumber {
    /***
     * 斐波那契数
     * @param n
     * @return
     */
    public int fib(int n) {
        int[] bp = new int[n + 1];
        bp[0] = 0;
        if (n >= 1)bp[1] = 1;
        for (int i = 2; i < bp.length; i++) {
            bp[i] = bp[i-1] + bp[i - 2];
        }
        return bp[n];
    }
}
