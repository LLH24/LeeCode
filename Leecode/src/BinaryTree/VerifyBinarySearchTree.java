package BinaryTree;

public class VerifyBinarySearchTree {

//    public boolean isValidBST(TreeNode root) {
//        return judgeBST(root.left,root.val,true) && judgeBST(root.right,root.val,false);
//    }
//
//    public boolean judgeBST(TreeNode root,Integer previous,boolean isLeft){
//        if (root == null) return true;
//        if (isLeft){//左边
//            if (root.val >= previous || (root.right != null && root.right.val >= previous)) return false;
//        }else {//右边
//            if (root.val <= previous ||(root.left != null && root.left.val <=previous)) return false;
//        }
//
//        return judgeBST(root.left,root.val,true) && judgeBST(root.right,root.val,false);
//    }

    long pre  = Long.MIN_VALUE;

    /***
     * 使用中序遍历，右边的值，永远比左边的值大
     * 搜索二叉树就是这样，在中序遍历上，下一个值比上一个值大
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
    if (root == null) return true;
    if (!isValidBST(root.left)) return false;//左边

    if (root.val <= pre) return false;//中间
    else pre = root.val;

    return isValidBST(root.right);
    }
}
