package Hot100;

import java.util.*;

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
        if (start > middle - 1) {
            left = null;
        }
        if (middle + 1 > end) {
            right = null;
        }
        root.left = left;
        root.right = right;
        toBeTree(array, start, middle - 1, left);
        toBeTree(array, middle + 1, end, right);
    }

    /***
     * 验证二叉搜索树 重点！！！
     * @param root
     * @return
     */
    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) return false;
        if (root.val <= pre) return false;
        pre = root.val;
        return isValidBST(root.right);
    }

    /***
     * 二叉搜索树中第K小的数
     * @param root
     * @param k
     * @return
     */
    boolean findTheNumber = false;
    int resultNumber;
    int number;

    public int kthSmallest(TreeNode root, int k) {
        number = k;
        findKNumber(root);
        return resultNumber;
    }

    public void findKNumber(TreeNode root) {
        if (root == null) return;
        if (findTheNumber) return;
        findKNumber(root.left);
        number--;
        if (number == 0) {
            resultNumber = root.val;
            findTheNumber = true;
        }
        findKNumber(root.right);
    }

    /***
     * 二叉树的右视图
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {

        LinkedList<Integer> result = new LinkedList<>();
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        if (root == null) return result;
        treeNodes.add(root);
        while (!treeNodes.isEmpty()) {
            int size = treeNodes.size();
            while (size > 0) {
                if (size == 1) result.add(treeNodes.peek().val);
                TreeNode pop = treeNodes.pop();
                if (pop.left != null) treeNodes.add(pop.left);
                if (pop.right != null) treeNodes.add(pop.right);
                size--;
            }
        }
        return result;
    }


    /***
     * 二叉树展开为列表
     * @param root
     */

    TreeNode preNode = new TreeNode();

    public void flatten(TreeNode root) {
        toBList(root);
        toRevers(root);
    }

    public void toBList(TreeNode root) {
        if (root == null) return;
        preNode.left = root;
        preNode = root;
        toBList(root.left);
        toBList(root.right);
    }

    public void toRevers(TreeNode root) {
        if (root == null) return;
        root.right = root.left;
        root.left = null;
        toRevers(root.right);
    }

    /***
     * 从前序与中序遍历，构造二叉树
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        if (preorder.length == 1) {
            root.left = null;
            root.right = null;
            return root;
        }
        int middle = 0;
        for (int i = 0; i < inorder.length - 1; i++) {
            if (inorder[i] == root.val) {
                middle = i;
                break;
            }
        }
        int[] newPreorderLeft = new int[middle];
        int[] newInorderLeft = new int[middle];
        for (int i = 0; i < middle; i++) {
            newPreorderLeft[i] = preorder[i + 1];
            newInorderLeft[i] = inorder[i];
        }

        int[] newPreorderRight = new int[inorder.length - 1 - middle];
        int[] newInorderRight = new int[inorder.length - 1 - middle];
        for (int i = 0; i < newInorderRight.length; i++) {
            newInorderRight[i] = inorder[i + middle + 1];
            newPreorderRight[i] = preorder[i + middle + 1];
        }
        root.left = buildTree(newPreorderLeft, newInorderLeft);
        root.right = buildTree(newPreorderRight, newInorderRight);
        return root;
    }

    /***
     * 路径总和
     * @param root
     * @param targetSum
     * @return
     */
    //好像达不到要求啊
    public int pathSum(TreeNode root, int targetSum) {//换起始点
        if (root == null) return 0;
        int res = 0;
        res += findThePointWay(root, targetSum);//从该节点开始找
        res += pathSum(root.left, targetSum);
        res += pathSum(root.right, targetSum);
        return res;
    }

    public int findThePointWay(TreeNode root, long targetSum) {//往下走
        if (root == null) return 0;
        int sum = 0;
        if (root.val == targetSum) sum++;//可能+1-1+1—1，这样也是可以的
        long nextTarget = targetSum - root.val;
        return findThePointWay(root.left, nextTarget) + findThePointWay(root.right, nextTarget) + sum;
    }

    //前缀和  和 回溯的结合，非常好！！！
    int res = 0;

    public int pathSumI(TreeNode root, int targetSum) {
        HashMap<Long, Integer> longIntegerHashMap = new HashMap<>();
        longIntegerHashMap.put((long) 0, 1);
        int pre = 0;
        preSum(root, longIntegerHashMap, pre, targetSum);
        return res;
    }

    public void preSum(TreeNode root, HashMap<Long, Integer> hashmap, long pre, int targetSum) {
        if (root == null) return;
        pre += root.val;
        long preNeedNumber = pre - targetSum;
        Integer preHaveNumber = hashmap.getOrDefault(preNeedNumber, 0);
        res += preHaveNumber;
        hashmap.put(pre, hashmap.getOrDefault(pre, 0) + 1);
        preSum(root.left, hashmap, pre, targetSum);
        preSum(root.right, hashmap, pre, targetSum);
        hashmap.put(pre, hashmap.get(pre) - 1);
    }

    /***
     * 二叉树的公共祖先
     */

    boolean find = false;
    TreeNode resultNode;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findMonster(root, p, q);
        return resultNode;
    }

    public boolean findMonster(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        if (find == true) return true;
        boolean left = findMonster(root.left, p, q);
        if (find == true) return true;
        boolean right = findMonster(root.right, p, q);
        if (find == true) return true;
        if (left && right) {
            resultNode = root;
            find = true;
            return true;
        }
        if (root == p || root == q || left || right) {
            if((root == p || root == q) && (left || right)){
                resultNode = root;
                find = true;
            }
            return true;
        }
        return false;
    }

}
