package DynamicProgramming;

public class DifferentBinarySearchTrees {
    /***
     * 不同的二叉搜索树
     * 将二叉树分为左右二叉树，bp【】为每个二叉树能分出来的种类
     * n = 3 可以分为左0，右2，左1，右1，左2，右0；
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] bp = new int[n + 1];
        bp[0] = 1;
        bp[1] = 1;
        for (int i = 2; i < n+1; i++) {
            int count = 0;
            for (int j = 1; j < i+1; j++) {
                count += bp[j-1]*bp[i-j];
            }
            bp[i] = count;
        }
        return bp[n];
    }
}
