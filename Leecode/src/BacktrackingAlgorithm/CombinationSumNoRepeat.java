package BacktrackingAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumNoRepeat {
    /***
     * 组合求和，组合中有重复数字，但是每个数字不可重复使用
     * @param candidates
     * @param target
     * @return
     */
    ArrayList<Integer> singleResult = new ArrayList<>();
    List<List<Integer>> results = new ArrayList<>();
    int sum = 0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null) return results;
        Arrays.sort(candidates);
        findCombination(candidates,target,0);
        return results;
    }
    public void findCombination(int[] array,int target,int index){
        //终止条件
        if (sum == target){
            results.add(new ArrayList<>(singleResult));
        }
        if (array.length == index) return;

        //循环和递归
        for (int i = index; i < array.length; i++) {
            if(i > 0 && array[i] == array[i-1] && i != index) continue;//
            /*
            如果i ！= index 说明他们不是刚好的下一层，而是下一层的同层，就是在往左遍历，往左遍历就不可以，往下走就是可以的
             */
            sum += array[i];
            if (sum > target){
                sum -= array[i];
                break;
            }
            singleResult.add(array[i]);
            findCombination(array,target,i+1);
            singleResult.removeLast();
            sum -= array[i];
        }
    }
}
