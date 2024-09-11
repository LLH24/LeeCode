package BinaryTree;

import java.util.Deque;
import java.util.LinkedList;

/***
 * 对称二叉树的递归方法
 */
public class SymmetricBinaryTree {
//    public boolean isSymmetric(TreeNode root) {
//        return  isRight(root.left,root.right);
//    }
//
//    public boolean isRight(TreeNode left,TreeNode right){
//        if (left == null && right == null) return true;
//        if((left == null && right != null)||(left != null && right == null) || (left.val != right.val)) return  false;
//        if (isRight(left.left,right.right) == false || isRight(left.right,right.left) == false) return false;
//        return true;
//    }

    /***
     * 迭代法
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        Deque<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(root.left);
        treeNodes.offer(root.right);
        while(!treeNodes.isEmpty()){
            TreeNode left = treeNodes.poll();
            TreeNode right = treeNodes.poll();
            if (left == null && right == null) continue;
            if((left == null && right != null)||(left != null && right == null) || (left.val != right.val)) return  false;
            treeNodes.offer(left.left);
            treeNodes.offer(right.right);
            treeNodes.offer(left.right);
            treeNodes.offer(right.left);
        }
        return  true;
    }
}
