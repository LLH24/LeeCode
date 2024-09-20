package GreedyAlgorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
    /***
     * 合并区间
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> (a[0] - b[0]));
        List<int[]> results = new LinkedList<>();
        int[] result = new int[]{-1,-1};
        int rightIndex = Integer.MIN_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] > rightIndex){//不相接
                if (result[1] != -1)results.add(result.clone());
                result[0]=intervals[i][0];
                rightIndex = Math.max(rightIndex,intervals[i][1]);
                result[1]=rightIndex;
            }else {//相接
                rightIndex = Math.max(rightIndex,intervals[i][1]);
                result[1]=rightIndex;
            }
            if (intervals.length -1 == i){
               results.add(result.clone());
            }
        }
        return results.toArray(new int[results.size()][]);
    }
}
