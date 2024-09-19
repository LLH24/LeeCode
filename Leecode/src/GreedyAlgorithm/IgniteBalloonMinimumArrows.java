package GreedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

public class IgniteBalloonMinimumArrows {
    /***
     * 用最少的箭射气球
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]){
                    if (o1[0] < o2[0])return  -1;
                    else return 1;

                }else {
                    if (o1[1] < o2[1])return  -1;
                    else return 1;
                }
            }
        });

        int results = 0;
        int right = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] <= right){
                right = Math.min(right,points[i][1]);
            }else {
                results++;
                right = points[i][1];
            }
        }
        return results+1;
    }
}
