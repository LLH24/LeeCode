package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;

public class ModeOfSearchTree {
    int maxFrequency = 1;
    int curFrequency = 0;
    ArrayList<Integer> modeList = new ArrayList<>();
    int pre = Integer.MAX_VALUE;

    public int[] findMode(TreeNode root) {
        findMaxMode(root);
        int[] result = new int[modeList.size()];
        for (int i = 0; i < modeList.size(); i++) {
            result[i] = modeList.get(i);
        }
        return result;
    }

    public void findMaxMode(TreeNode root){
        if (root == null) return;
        findMaxMode(root.left);
        if (root.val == pre){
            curFrequency++;
            if (curFrequency == maxFrequency){
                modeList.add(root.val);
            } else if (curFrequency > maxFrequency) {
                modeList.clear();
                modeList.add(root.val);
                maxFrequency = curFrequency;
            }
        }else {
            curFrequency = 1;
            if (curFrequency == maxFrequency) modeList.add(root.val);
        }
        pre = root.val;
        findMaxMode(root.right);
    }
}
