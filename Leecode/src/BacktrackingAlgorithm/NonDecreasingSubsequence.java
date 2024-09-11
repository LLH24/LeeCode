package BacktrackingAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class NonDecreasingSubsequence {
    List<Integer> sonCombination = new ArrayList<>();
    List<List<Integer>> results = new ArrayList<>();

    /***
     * 非递减子数列,对当前的nums，找到非递减的，不是对这个里面的数字去找，简单说，就是不能排序
     * @param nums
     * @return
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        findCombination(nums,0);
        return results;
    }

    public void findCombination(int[] nums,int start){
        //维护一个本层的hash
        HashSet<Integer> localHash = new HashSet<>();
        //本层的hashset，不被循环重置，只被递归重置
        for (int i = start; i < nums.length; i++) {
            if (localHash.contains(nums[i]))continue;
            else localHash.add(nums[i]);
            if (!sonCombination.isEmpty() && sonCombination.getLast() > nums[i]) continue;
            sonCombination.add(nums[i]);
            if(start != 0 ){
                results.add(new ArrayList<>(sonCombination));
            }
            findCombination(nums,i+1);
            sonCombination.removeLast();
        }
    }
}
