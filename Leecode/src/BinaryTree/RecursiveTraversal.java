package BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class RecursiveTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
//        proTraversal(root, result);
        midTraversal(root, result);
//        behandTraversal(root, result);
        return result;
    }

    /***
     * 前序遍历,递归法
     * @param root
     * @param result
     */
//    public void proTraversal(TreeNode root,List<Integer> result){
//        if (root == null){
//            return;
//        }
//        result.add(root.val);
//        proTraversal(root.left,result);
//        proTraversal(root.right,result);
//    }

    /***
     * 前序迭代法,null可以作为一个对象加入任何的队列
     * @param root
     * @param result
     */
//    public void proTraversal(TreeNode root, List<Integer> result) {
//        if (root == null) return;
//        Stack<TreeNode> treeNodes = new Stack<>();
//        treeNodes.push(root);
//        while (!treeNodes.isEmpty()) {
//            TreeNode pop = treeNodes.pop();
//            result.add(pop.val);
//            if (pop.right != null) {
//                treeNodes.push(pop.right);
//            }
//            if (pop.left != null) {
//                treeNodes.push(pop.left);
//            }
//        }
//    }


    /***
     * 中序遍历，递归
     * @param root
     * @param result
     */
//    public void midTraversal(TreeNode root,List<Integer> result){
//        if (root == null){
//            return;
//        }
//        midTraversal(root.left,result);
//        result.add(root.val);
//        midTraversal(root.right,result);
//    }

    /***
     * 中序迭代法
     * @param root
     * @param result
     */
//    public void midTraversal(TreeNode root, List<Integer> result) {
//        if (root == null) {
//            return;
//        }
//        Stack<TreeNode> treeNodes = new Stack<>();
//        TreeNode cur = root;
//        while (cur != null || !treeNodes.isEmpty()) {
//            if (cur != null){
//                treeNodes.push(cur);
//                cur = cur.left;
//            }
//            else {
//                cur = treeNodes.pop();
//                result.add(cur.val);
//                cur = cur.right;
//            }
//        }
//    }

    /***
     * 中序迭代法的统一写法
     * @param root
     * @param result
     */
    public void midTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> treeNodes = new Stack<>();
        treeNodes.push(root);
        while (!treeNodes.isEmpty()) {
            TreeNode pop = treeNodes.pop();
            if (pop != null) {
                if (pop.right != null) treeNodes.push(pop.right);
                treeNodes.push(pop);
                treeNodes.push(null);
                if (pop.left != null) treeNodes.push(pop.left);
            } else {
                 pop = treeNodes.pop();
                 result.add(pop.val);
            }
        }
    }

/***
 * 后序遍历，递归
 * @param root
 * @param result
 */
//    public void behandTraversal(TreeNode root,List<Integer> result){
//        if (root == null){
//            return;
//        }
//        behandTraversal(root.left,result);
//        behandTraversal(root.right,result);
//        result.add(root.val);
//    }

/***
 * 后序迭代法
 * 基于前序的修改
 * @param root
 * @param result
 */
//    public void behandTraversal(TreeNode root, List<Integer> result) {
//        if (root == null) return;
//        Stack<TreeNode> treeNodes = new Stack<>();
//        treeNodes.push(root);
//        while (!treeNodes.isEmpty()) {
//            TreeNode pop = treeNodes.pop();
//            result.add(pop.val);
//            if (pop.left != null) {
//                treeNodes.push(pop.left);
//            }
//            if (pop.right != null) {
//                treeNodes.push(pop.right);
//            }
//        }
//        Collections.reverse(result);
//    }
}
