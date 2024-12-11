package Hot100;

import java.util.*;

public class Heap {
    /***
     * 数组中的第K个元素
     * @param nums
     * @param k
     * @return
     */
    //桶排序法
    public int findKthLargest(int[] nums, int k) {
        int[] buckets = new int[20001];
        for (int i = 0; i < nums.length; i++) {
            buckets[nums[i] + 10000]++;
        }
        for (int i = 20000; i >= 0; i--) {
            k = k - buckets[i];
            if (k <= 0) {
                return i - 10000;
            }
        }
        return 0;
    }


    /***
     * 前K个高频元素
     * @param nums
     * @param k
     * @return
     * 堆排序
     */
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> integers = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        Set<Integer> key_set = map.keySet();
        for (Integer i : key_set) {
            if (integers.size() < k) {
                integers.add(i);
            } else if (map.get(i) > map.get(integers.peek())) {
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


    /***
     * 桶排序
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequentI(int[] nums, int k) {
        int[] results = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[][] buckets = new int[100001][100];
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            int i = 0;
            while (buckets[entry.getValue()][i] != 0) {
                i++;
            }
            buckets[entry.getValue()][i] = entry.getKey();
        }
        int start = 100000;
        int i = 0;
        while (i < k) {
            int j = 0;
            while (start > 0 && buckets[start][j] == 0) {
                start--;
            }
            results[i] = buckets[start][j];
            if (i == k-1) return results;
            j++;
            i++;
            while(j < k && buckets[start][j] != 0){
                results[i] = buckets[start][j];
                j++;
                i++;
            }
            start--;
        }

        return results;
    }
}
