package BinaryTree;

public class InsertBST {
    /***
     * 插入某节点，在搜索二叉树中
     */
    boolean isOver = false;
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (isOver == true) return root;
        if (root == null){
            TreeNode treeNode = new TreeNode(val);
            isOver = true;
            return treeNode;
        }
        if (val > root.val) root.right = insertIntoBST(root.right ,val);
        if (val < root.val) root.left = insertIntoBST(root.left ,val);

        return root;
    }
}
