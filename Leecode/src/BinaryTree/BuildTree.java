package BinaryTree;

public class BuildTree {
    /***
     * 我这个方法会比较慢，之所以慢，是因为不断在赋值
     * 下面的方法可以不用赋值而快速
     * private TreeNode buildHelper(int[] inorder, int inorderStart, int inorderEnd, int[] postorder, int postorderStart, int postorderEnd){
     * @param inorder
     * @param postorder
     * @return
     */
//    public TreeNode buildTree(int[] inorder, int[] postorder) {
//        int length = inorder.length;
//        if (length == 0) return null;
//        TreeNode root = new TreeNode();
//        root.val = postorder[length-1];//给节点赋值
//        if (length == 1){
//            root.left = null;
//            root.right = null;
//            return root;
//        }
//        int minIndex = 0;
//        for (int i = 0; i < inorder.length; i++) {
//            if (inorder[i] == postorder[length-1]) {
//                minIndex = i;
//                break;
//            }
//        }
//        int[] nextInorderLeft = new int[minIndex];
//        int[] nextInorderRight = new int[length - 1 -minIndex];
//
//        for (int i = 0; i < nextInorderLeft.length; i++) {//中序，以分割点为界，划分左右分支
//            nextInorderLeft[i] = inorder[i];
//        }
//
//        for (int i = 0; i < nextInorderRight.length; i++) {
//            nextInorderRight[i] = inorder[i+minIndex+1];
//        }
//
//        int[] nextPostorderLeft = new int[nextInorderLeft.length];
//        int[] nextPostorderRight = new int[nextInorderRight.length];
//
//        for (int i = 0; i < nextPostorderLeft.length; i++) {//后序，根据长度划分左右分支
//            nextPostorderLeft[i] = postorder[i];
//        }
//        for (int i = 0; i < nextPostorderRight.length; i++) {
//            nextPostorderRight[i] = postorder[i+nextPostorderLeft.length];
//        }
//        root.left = buildTree(nextInorderLeft,nextPostorderLeft);
//        root.right = buildTree(nextInorderRight,nextPostorderRight);
//        return root;
//
//    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) return null;
        return buildHelper(inorder,0,inorder.length,postorder,0,postorder.length);
    }

    private TreeNode buildHelper(int[] inorder, int inorderStart, int inorderEnd, int[] postorder, int postorderStart, int postorderEnd){
        TreeNode root = new TreeNode();
        if (postorderEnd-postorderStart == 0) return null;
        root.val = postorder[postorderEnd-1];
        if (inorderEnd-inorderStart == 1) {
            root.left = null;
            root.right = null;
            return root;
        }
        int minIndex = 0;
        for (int i = inorderStart; i < inorderEnd; i++) {
            if (inorder[i] == root.val){
                minIndex = i;
                break;
            }
        }
        int nextInorderLeftStart = inorderStart;
        int nextInorderLeftEnd = minIndex;
        int nextInorderRightStart = minIndex+1;
        int nextInorderRightEnd = inorderEnd;

        int nextPostorderLeftStart = postorderStart;
        int nextPostorderLeftEnd = postorderStart+(nextInorderLeftEnd - nextInorderLeftStart);
        int nextPostorderRightStart = nextPostorderLeftEnd;
        int nextPostorderRightEnd = postorderEnd-1;


        root.left = buildHelper(inorder,nextInorderLeftStart,nextInorderLeftEnd,postorder,nextPostorderLeftStart,nextPostorderLeftEnd);
        root.right = buildHelper(inorder,nextInorderRightStart,nextInorderRightEnd,postorder,nextPostorderRightStart,nextPostorderRightEnd);
        return root;
    }

}
