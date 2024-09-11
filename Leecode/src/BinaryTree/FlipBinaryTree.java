package BinaryTree;

public class FlipBinaryTree {
    /***
     * 翻转二叉树
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        treeInvert(root);
        return root;
    }

    public void treeInvert(TreeNode root){
        if (root == null ||(root.left == null && root.right == null)) return;
        TreeNode temp = new TreeNode();
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        treeInvert(root.left);
        treeInvert(root.right);
    }
}
