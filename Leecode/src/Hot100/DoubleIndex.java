package Hot100;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DoubleIndex {
    /***
     * 移动零
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if(nums.length == 1) return;
        //只需要收集非0数据即可
        int left = 0;
        int right = 0;
        while(right<nums.length){
            if (nums[right] == 0){
                right++;
            }else {
                nums[left] = nums[right];
                right++;
                left++;
            }
        }
        while (left<nums.length){
            nums[left] = 0;
            left++;
        }
    }

    /***
     * 乘最多水的容器
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left= 0;
        int right = height.length-1;
        int max = 0;
        while(left != right){
            max = Math.max(max,(right-left)*Math.min(height[left],height[right]));
            if (height[left] < height[right]) left++;
            else right--;
        }
        return max;
    }

    /***
     * 三数之和
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        LinkedList<List<Integer>> results = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i>0 && nums[i] == nums[i-1]) continue;
            if (nums[i]>0) return results;
            else {
                int j = i+1;
                int k = nums.length-1;
                while(j<k){
                    if(j>i+1 && nums[j] == nums[j-1]) {
                        j++;
                        continue;
                    };
                    if (k<nums.length-1 && nums[k] == nums[k+1]) {
                        k--;
                        continue;
                    };
                    int current = nums[i]+nums[j]+nums[k];
                    if (current <0) j++;
                    else if (current >0) k--;
                    else {
                        LinkedList<Integer> integers = new LinkedList<>();
                        integers.add(nums[i]);
                        integers.add(nums[j]);
                        integers.add(nums[k]);
                        results.add(integers);
                        j++;
                        k--;
                    }
                }
            }
        }
        return results;
    }
}
