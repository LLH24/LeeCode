package BinaryTree;

import java.util.LinkedList;
import java.util.List;

public class TheNumberOfNodesInCompleteBinaryTree {
    /****\
     * 完全二叉树的节点个数
     * 迭代法,这个方法时间长一些，需要先记录再技术
     * @param root
     * @return
     */
//    public int countNodes(TreeNode root) {
//        LinkedList<Integer> integers = new LinkedList<>();
//        proTraversal(root,integers);
//        return integers.size();
//    }
//
//        public void proTraversal(TreeNode root, List<Integer> result){
//        if (root == null){
//            return;
//        }
//        result.add(root.val);
//        proTraversal(root.left,result);
//        proTraversal(root.right,result);
//    }

    /***
     * 这个方法快，不需要记录，只保存数值
     * 有值就加一
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }


}
