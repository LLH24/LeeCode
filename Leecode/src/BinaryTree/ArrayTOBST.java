package BinaryTree;

import java.util.Arrays;

public class ArrayTOBST {
    /***
     * 创建多个数组的方式
     * 时间和空间的消耗都很大，不合适
     * @param nums
     * @return
     */
//    public TreeNode sortedArrayToBST(int[] nums) {
//        if (nums.length == 0) return null;
//        if (nums.length == 1) return new TreeNode(nums[0]);
//        int leftLength = nums.length/2;
//        TreeNode root  = new TreeNode(nums[leftLength]);
//        root.left = sortedArrayToBST(Arrays.stream(nums).limit(leftLength).toArray());
//        root.right = sortedArrayToBST(Arrays.stream(nums).skip(leftLength+1).toArray());
//        return root;
//    }

    /***
     * 指针法，更好，更快
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return arrayToBst(nums,0,nums.length-1);
    }

    public TreeNode arrayToBst(int[] nums ,int start,int end){
        if (end < start) return null;
        if (end == start) return new TreeNode(nums[start]);//我这是左闭右闭的，所以，相等就是最后一个
        int rootIndex = (end - start+1)/2 + start;
        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left = arrayToBst(nums,start,rootIndex-1);
        root.right = arrayToBst(nums,rootIndex+1,end);
        return root;
    }
}
