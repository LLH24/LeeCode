package BinaryTree;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (getHeight(root) == -1) return  false;
        return true;
    }

    /***
     * 平衡二叉树
     * 用的后序递归遍历的方式
     * @param root
     * @return
     */
    public int getHeight(TreeNode root){
        if (root == null) return 0;
        int leftHeight = getHeight(root.left)+1;
        int rightHeight = getHeight(root.right)+1;
        if ((leftHeight == 0) || (rightHeight == 0)) return -1;
        if (Math.abs(leftHeight - rightHeight) >1) return -1;
        return Math.max(leftHeight,rightHeight);
    }
}
