package Hot100;

import StacksAndQueues.MyDqueue;

import java.util.*;

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

    /***
     *最小覆盖子串
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        char[] charArrayOriginal = s.toCharArray();
        char[] charArrayTarget = t.toCharArray();
        HashMap<Character, Integer> targetHashMap = new HashMap<>();
        HashMap<Character, Integer> windowHashMap = new HashMap<>();
        int length = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int lengthStart = 0;
        int lengthEnd = -1;
        for (char c : charArrayTarget) {
            targetHashMap.put(c, targetHashMap.getOrDefault(c,0)+1);
        }

        for (int i = 0; i < charArrayOriginal.length; i++) {
            if (!targetHashMap.containsKey(charArrayOriginal[i])) continue;
            for (int j = i; j < charArrayOriginal.length; j++) {
                if (!targetHashMap.containsKey(charArrayOriginal[j])) continue;
                windowHashMap.put(charArrayOriginal[j],
                        windowHashMap.getOrDefault(charArrayOriginal[j],0)+1);
                if (contain(targetHashMap,windowHashMap)){
                    if (j-i+1 < length){//就是这个结果了,第一次找到窗口
                        start = i;
                        end = j;
                        length = j-i+1;
                        lengthStart = start;
                        lengthEnd = end;
                    }
                    break;
                }
            }
            break;
        }
        if (lengthStart == 0 && lengthEnd == -1){
            return s.substring(lengthStart,lengthEnd+1);
        }
        //开始窗口的移动
        outloop:
        while(start <= end && end < s.length()){
            if (!targetHashMap.containsKey(charArrayOriginal[start])){
                start++;
                continue;
            }else {//第一个值为我们需要的字符
                if (contain(targetHashMap,windowHashMap)){//判断现在是否成立
                    //成立，保存
                    if (end-start+1 < length){//保存结果
                        length = end-start+1;
                        lengthStart = start;
                        lengthEnd = end;
                    }
                    //左减
                }
                windowHashMap.put(charArrayOriginal[start], windowHashMap.get(charArrayOriginal[start])-1);
                start++;//象征着窗口左边已经右移
                if(!contain(targetHashMap,windowHashMap)){//右加
                    while(!contain(targetHashMap,windowHashMap) && end<s.length()-1){
                        end++;
                        if (targetHashMap.containsKey(charArrayOriginal[end])) {
                            windowHashMap.put(charArrayOriginal[end], windowHashMap.get(charArrayOriginal[end])+1);
                        }
                    }
                    if (contain(targetHashMap,windowHashMap) && end-start+1 < length){//就是这个结果了
                        length = end-start+1;
                        lengthStart = start;
                        lengthEnd = end;
                    }
                }
            }
        }
        return s.substring(lengthStart,lengthEnd+1);
    }

    public boolean contain(HashMap<Character, Integer> target,HashMap<Character, Integer> window){
        if (window.size() != target.size()) return false;
        Set<Map.Entry<Character, Integer>> entries = window.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (value < target.get(key)) return false;
        }
        return true;
    }
}