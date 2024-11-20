package Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OrdinaryArray {
    /***
     * 最大子数组和
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum < 0) sum = nums[i];
            else {
                sum += nums[i];
            }
            res = Math.max(res, sum);
        }
        return res;
    }


    /***
     * 合并区间
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        ArrayList<int[]> integers = new ArrayList<>();

        //进行左排序，能合并区间的，一定是连续的
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 0; i < intervals.length; i++) {
            //相交
            if (intervals[i][0] <= right ) {
                right = Math.max(right,intervals[i][1]);
                left = Math.min(left,intervals[i][0]);
            }
            //不相交
            else {
                integers.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
            if (i == intervals.length - 1) {
                integers.add(new int[]{left, right});
            }
        }
        //T[]为返回的类型这里的T为new int[size]，必须确定size
        int[][] res = integers.toArray(new int[integers.size()][]);
        return res;
    }

    /***
     * 轮转数组
     * @param nums
     * @param k
     */
    //另外一个数组法
    public void rotate(int[] nums, int k) {
        int[] results = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            results[(i+k)%nums.length] = nums[i];
        }
        System.arraycopy(results,0,nums,0,nums.length);
    }
    //翻转法，牛逼
//    public void rotate(int[] nums, int k) {
//        k %= nums.length;
//        reverse(nums, 0, nums.length - 1);
//        reverse(nums, 0, k - 1);
//        reverse(nums, k, nums.length - 1);
//    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }

    /***
     * 除自身以外数组的乘积
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        //创建两个数组，一个表示左边的所有数字的乘积值，一个表示右边的乘积和
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] results = new int[nums.length];
        left[0] = 1;//0位置的数字，左边和为1；
        right[nums.length-1] = 1;//最后一个数字的右边和为1
        //以下三步可以合并，这里为了清晰，分成3步
        for (int i = 1; i < nums.length; i++) {//求左边所有数字的乘积值
            left[i] = left[i-1] * nums[i-1];
        }

        for (int i = nums.length-2; i >= 0 ; i--) {
            right[i] = right[i+1] * nums[i+1];
        }

        for (int i = 0; i < nums.length; i++) {//左右相乘，就是不包括自己的所有乘积和
            results[i] = left[i] * right[i];
        }
        return results;

    }

}
