package BinaryTree;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class CutBST {
    /***
     * 裁剪搜索二叉树
     * 1.先对左右进行划分，low比你val小，就往左边搜索，high比val大，就往右边搜索
     * 2.找到临界的点，比如，val<low，这样的val需要删除，返回他的右边的节点
     * 但是，右边的节点未必修正完全，他左边的点可能还有问题，就用递归，进行修剪
     * @param root
     * @param low
     * @param high
     * @return
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) return null;
        if (root.val < low){
            return trimBST(root.right,low,high);
        }
        if (root.val >high){
            return trimBST(root.left,low,high);
        }
        if (low <= root.val) root.left = trimBST(root.left,low,high);
        if (high >= root.val) root.right =  trimBST(root.right,low,high);
        return root;
        
    }
}
