package BinaryTree;

public class SumOfLeftLeaves {
    /***
     * 左叶子，需要利用父节点
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 0; //终止条件
        if (root.left != null && root.left.left == null && root.left.right == null)//符合条件的子节点值加入
            return root.left.val + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        else return  sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);//不符合条件的子节点，不加入，直接下一步递归
    }
}
