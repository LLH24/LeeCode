package GreedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

public class SumOfInterversionK {
    public int largestSumAfterKNegations(int[] nums, int k) {
        nums = Arrays.stream(Arrays.stream(nums).boxed().toArray(Integer[]::new)).sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o2) - Math.abs(o1);
            }
        }).mapToInt(Integer::intValue).toArray();
        //Integer::intValue是方法引用，就是让函数式接口中的方法，用这个方法。
        //.boxed()包装为包装类的流；.mapToInt变为拆包后的流
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k != 0) {
                k--;
                nums[i] = -nums[i];
            }
            result += nums[i];
        }
        if (k%2 == 1){
            result = result - 2*nums[nums.length-1];
        }
        return result;
    }
}
