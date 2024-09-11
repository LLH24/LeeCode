package BinaryTree;

public class MaxTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
             if (nums.length == 0) return null;
             return maxTreeHelper(nums,0,nums.length);
    }
    private TreeNode maxTreeHelper(int[] nums,int start, int end){
        if (end == start) return null;
        TreeNode root = new TreeNode();
        if (end - start == 1) {
            root.val = nums[start];
            root.left = null;
            root.right = null;
            return root;
        }
        //先假设最左边为最大值
        int maxIndex = start;
        int maxValue = nums[maxIndex];
        for (int i = start; i < end ; i++) {
            if (nums[i] > maxValue) {
                maxIndex = i;
                maxValue = nums[maxIndex];
            }
        }

        root.val = nums[maxIndex];
        root.left = maxTreeHelper(nums,start,maxIndex);
        root.right = maxTreeHelper(nums,maxIndex+1,end);
        return root;
    }
}
