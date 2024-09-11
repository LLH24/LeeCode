package BinaryTree;

public class FindTheValueInTheBottomLeftTree {
    /***
     * 最深最左
     * 需要用左为开头的遍历方式
     * 都可以
     */

    int result = 0;
    int maxlength = 0;
    public int findBottomLeftValue(TreeNode root) {
        int length = 0;
        lastVaule(root,length);
        return result;
    }

    public void lastVaule(TreeNode root,int length){
        if (root == null) return;
        length++;
        if (length > maxlength) {//记录最左边就可以所以用的>
            maxlength = length;
            result = root.val;
        }
        lastVaule(root.left,length);
        lastVaule(root.right,length);
    }
}
