package DynamicProgramming;

import java.util.Deque;
import java.util.LinkedList;

public class Rain {
    /***
     * 接雨水
     * @param height
     * @return
     */
    public int trap(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        int results = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[stack.peek()] == height[i])stack.pop();
            while(stack.size() != 0 && height[stack.peek()] < height[i]){
                Integer midIndex = stack.pop();
                Integer midValue = height[midIndex];
                if (stack.size() == 0) break;
                Integer leftIndex = stack.peek();
                Integer leftValue = height[leftIndex];
                Integer rightValue = height[i];
                results += (i- leftIndex-1)*(Math.min(rightValue,leftValue)-midValue);
            }
            stack.push(i);
        }
        return results;
    }
}
