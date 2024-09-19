package GreedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

public class NoOverlappingInterval {
    /***
     * 无重叠区间
     * 按最先结束排序，如果开始时间在前一个结束前有重复就不用
     * 没重复就用
     * 第一个结束的就是我们一定要的，局部最优就是是全局最优
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 0 ;
        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);
        int right = Integer.MIN_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] >= right){
                count++;
                right = intervals[i][1];
            }
        }
        return intervals.length - count;
    }
}
