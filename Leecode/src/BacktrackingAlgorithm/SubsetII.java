package BacktrackingAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetII {
    /***
     * 子集二，就是在nums中，存在重复的数字
     * @param nums
     * @return
     */
    List<Integer> sonCombination = new ArrayList<>();
    List<List<Integer>> results = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        results.add(new ArrayList<>());
        findCombination(nums,0);
        return results;
    }

    public void findCombination(int[] nums,int start){
        for (int i = start; i < nums.length; i++) {
            if ( i > 0 && nums[i] == nums[i-1] && i != start )continue;
            sonCombination.add(nums[i]);
            results.add(new ArrayList<>(sonCombination));
            findCombination(nums,i+1);
            sonCombination.removeLast();
        }
    }
}
