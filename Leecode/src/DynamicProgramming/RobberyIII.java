package DynamicProgramming;

import BinaryTree.TreeNode;

public class RobberyIII {
    /***
     * 打家劫舍3
     * 因为你这个树，如果只讨论最大值，可能左孩子取了最大，右孩子不取最大
     * 你不能只看最大，需要综合考虑
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        int[] returnInts = treeRob(root);
        return Math.max(returnInts[0],returnInts[1]);
    }

    public int[] treeRob(TreeNode root){
        if (root == null) return new int[2];
        int[] nowValue = new int[2];
        int[] leftValue = treeRob(root.left);
        int[] rightValue = treeRob(root.right);
        nowValue[0] = Math.max(leftValue[0],leftValue[1])+Math.max(rightValue[0],rightValue[1]);
        nowValue[1] = root.val+leftValue[0]+rightValue[0];
        return nowValue;
    }
}
