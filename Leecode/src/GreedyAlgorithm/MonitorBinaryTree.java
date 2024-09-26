package GreedyAlgorithm;

import BinaryTree.TreeNode;

public class MonitorBinaryTree {
    /***
     * 监控二叉树
     * 0为无覆盖
     * 1为有摄像头
     * 2为有覆盖
     * 从叶子开始，也就是从下开始，好判断，叶子节点的父节点一定需要摄像头
     * @param root
     * @return
     */
    int count = 0;
    public int minCameraCover(TreeNode root) {
        //给父节点添加一个父节点，用来判断原本的父节点是否需要加摄像头
        TreeNode treeNode = new TreeNode();
        treeNode.left = root;
        minCameraCoverToFind(treeNode);
        return count;
    }
    public int minCameraCoverToFind(TreeNode root) {
        if (root == null) return 2;
        //左右中
        int left = minCameraCoverToFind(root.left);
        int right = minCameraCoverToFind(root.right);
        int result = 0;
        if (left == 1 || right == 1) {
            result = 2;
        }
        if (left == 0 || right ==0){
            result = 1;
            count++;
        }
        return result;
    }
}
