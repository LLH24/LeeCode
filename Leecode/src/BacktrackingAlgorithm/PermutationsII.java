package BacktrackingAlgorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PermutationsII {
    List<Integer> sonCombination = new ArrayList<>();
    List<List<Integer>> results = new ArrayList<>();
    /***
     * 全排列2
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        findResults(nums,new int[nums.length]);
        return results;
    }

    public void findResults(int[] nums,int[] used){
        if (sonCombination.size() == nums.length) {
            results.add(new ArrayList<>(sonCombination));
            return;
        }
        HashSet<Integer> localHash = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) continue;
            if (localHash.contains(nums[i])) continue;
            else {
                localHash.add(nums[i]);
                sonCombination.add(nums[i]);
                used[i] = 1;
                findResults(nums,used);
                sonCombination.removeLast();
                used[i] = 0;
            }
        }
    }
}
