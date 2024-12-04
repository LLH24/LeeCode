package Hot100;

import java.util.LinkedList;
import java.util.List;

public class BinaryTree {
    /***
     * 中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> integers = new LinkedList<>();
        middleTraversal(root, integers);
        return integers;
    }

    public void middleTraversal(TreeNode root, List list) {
        if (root == null) return;
        middleTraversal(root.left, list);
        list.add(root.val);
        middleTraversal(root.right, list);
    }


    /***
     * 二叉树的最大深度
     * @param root
     * @return
     */
    int result = 0;

    public int maxDepth(TreeNode root) {
        int depth = 0;
        findMaxDepth(root, depth);
        return result;
    }

    public void findMaxDepth(TreeNode root, int depth) {
        if (root == null) return;
        depth++;
        result = Math.max(depth, result);
        findMaxDepth(root.left, depth);
        findMaxDepth(root.right, depth);
    }

    /***
     * 反转二叉树
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        toInvert(root);
        return root;
    }

    public void toInvert(TreeNode root) {
        if (root == null) return;
        TreeNode temp = new TreeNode();
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        toInvert(root.left);
        toInvert(root.right);
    }

    /***
     * 对称二叉树
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return isRight(root.left, root.right);
    }

    public boolean isRight(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null && right != null || left != null && right == null) return false;
        if (left.val != right.val) return false;
        return isRight(left.left, right.right) && isRight(left.right, right.left);
    }

    /***
     * 二叉树的直径
     * 左边深度加上右边深度？
     * @param root
     * @return
     */
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        toFindDiameter(root);
        return diameter;
    }


    public int toFindDiameter(TreeNode root) {
        if (root == null) return 0;
        int left = toFindDiameter(root.left);
        int right = toFindDiameter(root.right);


        int maxLength = Math.max(left, right);//不包含自己，只有左右


        diameter = Math.max(diameter, left + right);
        return maxLength + 1;
    }

    /***
     *二叉树的层序遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        LinkedList<List<Integer>> linkedLists = new LinkedList<>();
        if (root == null) return linkedLists;
        treeNodes.add(root);
        while (!treeNodes.isEmpty()) {
            int size = treeNodes.size();
            LinkedList<Integer> results = new LinkedList<>();
            while (size > 0) {
                size--;
                TreeNode pop = treeNodes.pop();
                results.add(pop.val);
                if (pop.left != null) treeNodes.add(pop.left);
                if (pop.right != null) treeNodes.add(pop.right);
            }
            linkedLists.add(results);
        }
        return linkedLists;
    }

    /***
     * 将有序数组转换为二叉搜索树
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode treeNode = new TreeNode();
        toBeTree(nums, 0, nums.length - 1, treeNode);
        return treeNode;
    }

    public void toBeTree(int[] array, int start, int end, TreeNode root) {
        if (start > end) return;
        if (start == end) {
            root.val = array[end];
            return;
        }
        TreeNode left = new TreeNode();
        TreeNode right = new TreeNode();
        int middle = start + (end - start) / 2;
        root.val = array[middle];
        if (start > middle-1){
            left = null;
        }
        if (middle+1 > end){
            right = null;
        }
        root.left = left;
        root.right = right;
        toBeTree(array, start, middle - 1, left);
        toBeTree(array, middle + 1, end, right);
    }




}
