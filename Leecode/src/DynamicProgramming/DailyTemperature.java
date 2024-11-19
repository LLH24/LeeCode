package DynamicProgramming;

import java.util.*;

public class DailyTemperature {
    /***
     * 每日温度
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] results = new int[temperatures.length];
        Deque<Integer> stack = new LinkedList<>() ;
        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            while(stack.size() != 0){
                Integer topValue = temperatures[stack.peek()];
                if (temperatures[i] <= topValue){
                    break;
                }else {
                    Integer pop = stack.pop();
                    results[pop] = i-pop;
                }
            }
            stack.push(i);
        }
        return results;
    }
}
