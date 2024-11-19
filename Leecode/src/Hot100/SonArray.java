package Hot100;

import StacksAndQueues.MyDqueue;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class SonArray {
    /***
     * 和为K的子数组
     * 牛逼
     * 比如k=7，pre-k=13
     * 我不管你是第一个的位置等于13，还是10，100的位置的，前项和为13
     * 只要你为13，就证明，从13开始，到现在的位置，中间的值一定为7
     * 理解为，当前值和前面的值，可以组成K的个数，确实能遍历到每一个，想和后面的组合，那是后面那个值的事情
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0,1);
        int pre = 0;
        int count = 0;
        for (int i = 0; i < nums.length;i++) {
            pre += nums[i];
            int startValue = pre-k;
            int number = hashMap.getOrDefault(startValue,0);
            count += number;
            hashMap.put(pre,hashMap.getOrDefault(pre,0)+1);//得放后面，如果K=0的话，放前面，相当于，多产生了一个值
        }
        return count;
    }

    /***
     * 滑动窗口最大值
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] maxNumber = new int[nums.length - k+1];
        MyDqueue myDqueue = new MyDqueue();
        for (int i = 0; i < k; i++) {
            myDqueue.add(nums[i]);
        }
        maxNumber[0] = myDqueue.getMax();
        for (int i = k; i < nums.length; i++) {
            myDqueue.poll(nums[i-k]);
            myDqueue.add(nums[i]);
            maxNumber[i-k+1] = myDqueue.getMax();
        }
        return maxNumber;
    }
}