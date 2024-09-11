package BinaryTree;

public class SearchInBinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        //先确定参数，返回值
        //再确定终止条件
        //最后确定单层逻辑
        if (root == null || root.val == val) return root;
        if (root.val > val)return searchBST(root.left,val);
        if (root.val <= val)
        return searchBST(root.right,val);
        return null;
    }
}
