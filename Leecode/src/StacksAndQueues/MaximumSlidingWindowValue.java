package StacksAndQueues;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/***
 * 滑动区间最大值
 * 1.首先有一个滑动区间
 * 2.我们自己设计一个单调的队列，取最大值，就从头取
 * 3.唯一的麻烦就是如何把这个值删除，就是当取的窗口头的值和这个最大值相同时，让这个值删除
 */
public class MaximumSlidingWindowValue {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) return nums;
        MyDqueue myDqueue = new MyDqueue();
        int[] returnNumber = new int[nums.length-k+1];
        for (int i = 0; i < k; i++) {
            myDqueue.add(nums[i]);
        }
        returnNumber[0] = myDqueue.getMax();
        for (int i = 0; i+k< nums.length ; i++) {
            myDqueue.poll(nums[i]);
            myDqueue.add(nums[i+k]);
            returnNumber[i+1] = myDqueue.getMax();
        }
        return returnNumber;
    }
}

class MyDqueue{

    Deque<Integer> deque = new LinkedList<Integer>();

    public void add(int val){
        while(!deque.isEmpty() && val > deque.getLast()){
            deque.pollLast();
        }
        deque.addLast(val);
    }

    public int getMax(){
        return deque.getFirst();
    }

    public void poll(int value){
        if (value == deque.getFirst()){
            deque.pollFirst();
        }
    }
}
