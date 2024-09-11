package BacktrackingAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    /***
     * 子集
     * @param nums
     * @return
     */
    List<Integer> sonCombination = new ArrayList<>();
    List<List<Integer>> results = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        results.add(new ArrayList<>());
        findCombination(nums,0);
        return results;
    }


    public void findCombination(int[] nums,int start){
        if (start == nums.length){//可以不加。能少一点判断
            return;
        }

        for (int i = start; i < nums.length; i++) {
            sonCombination.add(nums[i]);
            results.add(new ArrayList<>(sonCombination));
            findCombination(nums,i+1);
            sonCombination.removeLast();
        }
    }
}
