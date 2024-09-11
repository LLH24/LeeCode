package BinaryTree;

public class BSTtoGST {
    /***
     * 搜索二叉树变为累加树
     * 反中序遍历
     * 感觉不能直接返回TreeNode，顺序不太对
     * @param root
     * @return
     */
    public int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        sumTree(root);
        return root;
    }
    public void sumTree(TreeNode root){
        if (root == null) return;
        sumTree(root.right);
        sum += root.val;
        root.val = sum;
        sumTree(root.left);
    }
}
