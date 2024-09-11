package BinaryTree;

public class MinimumDifferenceOfSearchTree {
    int pre = Integer.MAX_VALUE;
    int differenceMin = Integer.MAX_VALUE;

    /***
     * 在搜索二叉树中，找两个节点间的最小值
     * 因为，搜索二叉树在中序遍历中，存在顺序，所以只需要判断相邻节点就行
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return pre;
        getMinimumDifference(root.left);
        int difference = Math.abs(root.val - pre);
        if ( difference < differenceMin){
            differenceMin = difference;
        }
        pre = root.val;
        getMinimumDifference(root.right);
        return differenceMin;
    }

}
