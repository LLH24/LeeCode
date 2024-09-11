package Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfFourNumbers {
    public  static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length < 4) return lists;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>target&&nums[i]>=0) return lists;
            if(i>0 && nums[i] == nums[i-1]) continue;
            for (int j = i+1; j < nums.length ; j++) {
                if(j>i+1 && nums[j] == nums[j-1]) continue;
                int left = j+1;
                int right = nums.length-1;
                while(left < right){
                    int res = nums[i]+nums[j]+nums[left]+nums[right];
                    if (res < target){
                        left++;
                    }else if (res > target){
                        right--;
                    }else {
                        lists.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while(right > left && nums[right] == nums[right-1]) right--;//去重right
                        while(right > left && nums[left] == nums[left+1]) left++;//去重left
                        left++;
                        right--;
                    }
                }
            }
        }
        return lists;
    }
}
