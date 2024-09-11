package BinaryTree;

import java.util.LinkedList;
import java.util.List;

public class AllPathsOfBinaryTree {
    /****
     * 二叉树所有路径
     * 前序遍历递归法
     * @param root
     * @return
     */

    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        LinkedList<String> strings = new LinkedList<>();
        path(root,stringBuilder,strings);
        return strings;
    }

    /***
     * 有点意思，从上到下，一定是前序遍历
     * 每一层维护一个新的StingBuild，
     * 因为后面的修改，会影响到原来的值，这是引用传递
     * 用string不用考虑，他可以当参数处理，底层会新建
     * @param root
     * @param pathWay
     * @param result
     */

    public void path(TreeNode root,StringBuilder pathWay,LinkedList<String> result){
        StringBuilder nowString = new StringBuilder(pathWay.toString());
        if (root.left == null && root.right == null) result.add(nowString.append(root.val).toString());
        nowString.append(root.val);
        nowString.append("->");
        if (root.left != null)
        path(root.left,nowString,result);
        if (root.right != null)
        path(root.right,nowString,result);
    }
}
