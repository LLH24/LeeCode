package BinaryTree;

public class FindAncestorsSearchTree {
    /***
     * 搜索二叉树有大小的性质，高度最大祖先一定在两个值中间
     * 而且是自上而下第一次出现的地方
     */
    TreeNode ancesor = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (ancesor != null) return ancesor;
        if ((root.val <= p.val && root.val >= q.val) || (root.val >= p.val && root.val <= q.val)){
            ancesor = root;
            return ancesor;
        }
        lowestCommonAncestor(root.left,p,q);
        lowestCommonAncestor(root.right,p,q);
        return ancesor;
    }
}
