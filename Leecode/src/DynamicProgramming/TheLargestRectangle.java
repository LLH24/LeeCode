package DynamicProgramming;

import java.util.Arrays;
import java.util.LinkedList;

public class TheLargestRectangle {
    /***
     * 柱状图中的最大矩形
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int[] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[heights.length+1] = 0;
        System.arraycopy(heights, 0, newHeights, 1, heights.length);
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(0);
        int results = 0;
        for (int i = 1; i < newHeights.length; i++) {
            while(stack.size() != 0 && newHeights[stack.peek()] > newHeights[i] ){
                int mid = stack.pop();
                int midValue = newHeights[mid];
                Integer left = stack.peek();
                results = Math.max((i-left-1)*midValue,results);
                //这个i-left-1很精髓
                //其实是找到最大值的意思，意思是我这条是最大值了
            }
            stack.push(i);
        }
        return results;
    }
}
