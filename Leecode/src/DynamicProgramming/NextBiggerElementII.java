package DynamicProgramming;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class NextBiggerElementII {
    /***
     * 下一个更大元素2
     * @param nums
     * @return
     */
    //和两个数组直接合并，没啥大的区别
    public int[] nextGreaterElements(int[] nums) {
        int[] results = new int[nums.length];
        Arrays.fill(results,-1);
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (int i = 1; i < 2*nums.length; i++) {
            while (stack.size() != 0 && nums[stack.peek()%nums.length] < nums[i%nums.length]) {
                Integer pop = stack.pop();
                results[pop%nums.length] = nums[i%nums.length];
            }
            stack.push(i);
        }
        return results;
    }
}
