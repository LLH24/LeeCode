package BacktrackingAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
/*
组合求和,可重复
在求和问题中，排序之后加剪枝是常见的套路！
 */
    ArrayList<Integer> singleResult = new ArrayList<>();
    List<List<Integer>> results = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        findCombination(candidates,target,0,0);
        return results;
    }

    public void findCombination(int[] array,int target,int index,int sum){
        //终止条件
        if (sum > target) return;
        if (sum == target){
            results.add(new ArrayList<>(singleResult));
            return;
        }
        //横向遍历
        for (int i = index; i < array.length; i++) {
            int nextSum = sum + array[i];
            //剪枝
            if (nextSum > target) break;
            singleResult.add(array[i]);
            //递归遍历
            findCombination(array,target,i,nextSum);
            //回溯
            singleResult.removeLast();
        }
    }
}
