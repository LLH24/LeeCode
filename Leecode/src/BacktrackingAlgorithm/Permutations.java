package BacktrackingAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    List<Integer> sonCombination = new ArrayList<>();
    List<List<Integer>> results = new ArrayList<>();
    /***
     *全排列
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        findCombination(nums,new int[nums.length]);
        return results;
    }

    public void findCombination(int[] nums,int[] used){
        if (sonCombination.size() == nums.length) {
            results.add(new ArrayList<>(sonCombination));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1 ) continue;
            sonCombination.add(nums[i]);
            used[i] = 1;
            findCombination(nums,used);
            //回溯要取消掉所有的操作
            used[i] = 0;
            sonCombination.removeLast();
        }
    }
}
