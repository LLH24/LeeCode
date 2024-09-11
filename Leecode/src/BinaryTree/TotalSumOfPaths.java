package BinaryTree;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;

public class TotalSumOfPaths {
    /***
     * 路径求和满足目标值
     * 使用前序遍历（深度优先，且中间优先）
     * 把每一个中间节点都先加起来
     * 每次都把上一层的值拿下来，累加
     * 直到叶子节点，判断是否满足
     */
    boolean right = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int number = 0;
        sum(root,targetSum,number);
        return right;
    }

    public void sum(TreeNode root,int sumTarget,int sumNow){
        if (root == null) return;
        if (root.left == null && root.right == null)
            if(root.val + sumNow == sumTarget) right = true;
        sum(root.left,sumTarget,sumNow+root.val);
        sum(root.right,sumTarget,sumNow+root.val);
    }
}
