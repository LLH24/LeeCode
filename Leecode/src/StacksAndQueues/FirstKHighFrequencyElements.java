package StacksAndQueues;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;
//周一任务:两道算法题，
// boot使用完成，必须跟做
//飞书两个
//晚上数学
/***
 * PriorityQueue顶堆
 */
public class FirstKHighFrequencyElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> integers = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        Set<Integer> key_set = map.keySet();
        for (Integer i : key_set) {
            if (integers.size() < k){
                integers.add(i);
            }else if (map.get(i) > map.get(integers.peek())){
                integers.poll();
                integers.add(i);
            }
        }
        int[] reInt = new int[k];
        for (int i = 0; i < reInt.length; i++) {
            reInt[i] = integers.poll();
        }
        return reInt;
    }
}
