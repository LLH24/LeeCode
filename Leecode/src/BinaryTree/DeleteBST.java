package BinaryTree;

public class DeleteBST {
    /***
     * 在搜索二叉树中删除某节点
     * @param root
     * @param key
     * @return
     */
    public boolean isOver = false;
    public TreeNode deleteNode(TreeNode root, int key) {
        if (isOver) return root;
        if (root == null) {//没找到
            isOver = true;
            return root;
        }
        if (root.val == key){//某一个位子找到了
            if (root.right == null && root.left == null) {//左右节点都为空
                isOver = true;
                return null;
            }
            if (root.right == null && root.left != null){//左节点不为空，右节点为空
                isOver = true;
                return root.left;
            }
            if (root.right != null && root.left == null){//同上
                isOver = true;
                return root.right;
            }else {
              /*
              左右节点都不为空，有两种思路：
              1.将左节点的根放入右叶子中最小的叶子左边
              2.将右节点的根放入左叶子的最大的叶子的右边
              以1为例
               */
            findLeft(root.right).left =root.left;
            return root.right;
            }
        }
        if (key > root.val) root.right = deleteNode(root.right,key);//本次没找到，往下继续找
        if (key < root.val) root.left =deleteNode(root.left,key);


        return root;
    }


    public TreeNode findLeft(TreeNode root){//这个方法不是很好
        if (root == null) return null;
        if (findLeft(root.left) == null) return root;
        return findLeft(root.left);
    }
    /*
    递归不要用上瘾啊
    答案：
    else {
        TreeNode cur = root.right;
        while (cur.left != null) {
          cur = cur.left;
        }
        cur.left = root.left;
        root = root.right;
        return root;
      }
     */
}
