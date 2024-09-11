package BinaryTree.LevelTraversal;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LevelTraversal {
    List<List<Integer>> lists = new ArrayList<List<Integer>>();

    /***
     * 正规层序遍历，用队列，一层一层处理
     * @param root
     * @return
     */
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        if (root == null) return lists;
//        Deque<TreeNode> deque = new LinkedList<>();
//        deque.offer(root);
//        while (!deque.isEmpty()) {
//            List<Integer> results = new ArrayList<>();
//            int len = deque.size();
//            while (len > 0) {
//                TreeNode treeNode = deque.pollFirst();
//                results.add(treeNode.val);
//                if (treeNode.left != null) deque.offer(treeNode.left);
//                if (treeNode.right != null) deque.offer(treeNode.right);
//                len--;
//            }
//            lists.add(results);
//        }
//        return lists;
//    }

    /***
     * 递归，不是一层一层，还是一下到底，但是会把每一个数据存在相应的层
     * @param root
     * @return
     */
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        if (root == null) return lists;
//
//        recursiveTraversal(root,0);
//        return lists;
//    }
//    public void recursiveTraversal(TreeNode root,int storey){
//        if (root == null)return;
//        storey++;
//        if (lists.size() < storey){//如果是新的就加一层，仅此而已
//            lists.add(new ArrayList<>());
//        }
//        lists.get(storey-1).add(root.val);
//        recursiveTraversal(root.left,storey);
//        recursiveTraversal(root.right,storey);
//    }


    /***
     * 右视图
     * @param root
     * @return
     */
//    public List<Integer> rightSideView(TreeNode root) {
//        levelOrder(root);//或者用递归的方法，反正都一样
//        LinkedList<Integer> integers = new LinkedList<>();
//        if (lists.isEmpty()) return integers;
//        for (List<Integer> list : lists) {
//            integers.add(list.getLast());
//        }
//        return integers;
//    }

    /***
     * 层平均值
     * @param root
     * @return
     */
//    public List<Double> averageOfLevels(TreeNode root) {
//        levelOrder(root);
//        LinkedList<Double> integers = new LinkedList<>();
//        if (lists.isEmpty()) return integers;
//        for (List<Integer> list : lists) {
//            Double summeray = 0.0;
//            for (Integer i : list) {
//                summeray += i;
//            }
//            Double average = summeray/(double)list.size();
//            integers.add(average);
//        }
//        return integers;
//    }

    /***
     * N叉树的层序遍历
     * @param root
     * @return
     */
//    public List<List<Integer>> levelOrder(Node root) {
//        if (root == null) return lists;
//        Deque<Node> deque = new LinkedList<>();
//        deque.offer(root);
//        while(!deque.isEmpty()){
//            List<Integer> results = new ArrayList<>();
//            int len = deque.size();
//            while(len > 0 ){
//                Node node = deque.pollFirst();
//                results.add(node.val);
//                if (!node.children.isEmpty()){
//                    for (Node child : node.children) {
//                        deque.offer(child);
//                    }
//                }
//                len--;
//            }
//            lists.add(results);
//        }
//        return lists;
//    }

    /***
     * 单行最大
     * @param root
     * @return
     */
//    public List<Integer> largestValues(TreeNode root) {
//        LinkedList<Integer> integers = new LinkedList<>();
//        if (root == null) return integers;
//        Deque<TreeNode> deque = new LinkedList<>();
//        deque.offer(root);
//        while(!deque.isEmpty()){
//            List<Integer> results = new ArrayList<>();
//            int max = Integer.MIN_VALUE;
//            int len = deque.size();
//            while(len > 0 ){
//                TreeNode treeNode = deque.pollFirst();
//                results.add(treeNode.val);
//                if (treeNode.val>max) max = treeNode.val;
//                if (treeNode.left != null)deque.offer(treeNode.left);
//                if (treeNode.right != null)deque.offer(treeNode.right);
//                len--;
//            }
//            integers.add(max);
//        }
//        return integers;
//    }

    /***
     * 添加next节点（右侧节点）
     * @param root
     * @return
     */
//    public Node connect(Node root) {
//        if (root == null) return root;
//        Deque<Node> deque = new LinkedList<>();
//        deque.offer(root);
//        while(!deque.isEmpty()){
//            int len = deque.size();
//            while(len > 0 ){
//                Node node = deque.pollFirst();
//                if (len == 1) {
//                    node.next = null;
//                }else {
//                    node.next = deque.getFirst();
//                }
//                if (node.left != null)deque.offer(node.left);
//                if (node.right != null)deque.offer(node.right);
//                len--;
//            }
//        }
//        return root;
//    }

    /***
     * 最大层数
     * @param root
     * @return
     */
//    public int maxDepth(TreeNode root) {
//        if (root == null) return 0;
//        Deque<TreeNode> deque = new LinkedList<>();
//        deque.offer(root);
//        int lenth = 0;
//        while (!deque.isEmpty()) {
//            lenth++;
//            List<Integer> results = new ArrayList<>();
//            int len = deque.size();
//            while (len > 0) {
//                TreeNode treeNode = deque.pollFirst();
//                results.add(treeNode.val);
//                if (treeNode.left != null) deque.offer(treeNode.left);
//                if (treeNode.right != null) deque.offer(treeNode.right);
//                len--;
//            }
//            lists.add(results);
//        }
//        return lenth;
//    }

    /***
     * 没有子节点的最小层数
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int lenth = 0;
        while (!deque.isEmpty()) {
            List<Integer> results = new ArrayList<>();
            int len = deque.size();
            lenth++;
            while (len > 0) {
                TreeNode treeNode = deque.pollFirst();
                results.add(treeNode.val);
                if (treeNode.left != null) deque.offer(treeNode.left);
                if (treeNode.right != null) deque.offer(treeNode.right);
                if (treeNode.left == null && treeNode.right == null ) return lenth;
                len--;
            }
        }
        return lenth;
    }
}
