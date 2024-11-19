package DynamicProgramming;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class NextBiggerElementI {
    /***
     * 下一个更大元素1
     * @param nums1
     * @param nums2
     * @return
     */
    //法一，用2作为hashmap，两层简化的for循环
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] results = new int[nums1.length];
        Arrays.fill(results,-1);
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            integerIntegerHashMap.put(nums2[i],i);
        }
        for (int i = 0; i < nums1.length; i++) {
            Integer index = integerIntegerHashMap.get(nums1[i]);
            for (int j = index+1; j < nums2.length; j++) {
                if (nums2[j]>nums1[i]) {
                    results[i] = nums2[j];
                    break;
                }
            }
        }
        return results;
    }

    //法二，用1作为hashmap，用单调栈
    public int[] nextGreaterElementI(int[] nums1, int[] nums2) {
        int[] results = new int[nums1.length];
        Arrays.fill(results,-1);
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            integerIntegerHashMap.put(nums1[i],i);
        }
        Deque<Integer> stack = new LinkedList<>() ;
        stack.push(nums2[0]);
        for (int i = 1; i < nums2.length; i++) {
            while(stack.size()!=0) {
                Integer peekVaule = stack.peek();
                if (peekVaule >= nums2[i]) break;
                else {
                    if (integerIntegerHashMap.containsKey(peekVaule)){
                        results[integerIntegerHashMap.get(peekVaule)] = nums2[i];
                    }
                    stack.pop();
                }
            }
            stack.push(nums2[i]);
        }
        return results;
    }
}
