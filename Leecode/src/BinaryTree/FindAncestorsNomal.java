package BinaryTree;

public class FindAncestorsNomal {
    TreeNode ancestor = null;
    int isOver = 0;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findCommonAncestor(root,p,q);
        return ancestor;
    }

    public boolean findCommonAncestor(TreeNode root,TreeNode p, TreeNode q){
        if (root == null) return false;
        if (isOver == 1) return false;//结束标志位，一定要修改为false，如果是true，会把ancestor的值进行修改
        boolean leftHave = findCommonAncestor(root.left,p,q);
        boolean rightHave = findCommonAncestor(root.right,p,q);
        if (root.val == p.val || root.val == q.val){
            if (leftHave || rightHave){
                ancestor = root;
                isOver = 1;
                return  true;
            }

            return true;
        }

        if (leftHave == true && rightHave == true){
            ancestor = root;
            isOver = 1;
            return  true;
        }

        return leftHave || rightHave;
    }
}
