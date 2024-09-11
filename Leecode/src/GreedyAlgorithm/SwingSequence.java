package GreedyAlgorithm;

public class SwingSequence {
    public int wiggleMaxLength(int[] nums) {
        int count = 2;
        boolean rightBigger = true;
        //2个数
        if(nums.length == 1) return 1;
        if (nums.length == 2) {
            if (nums[0] == nums[1])return 1;
            return 2;
        }
        int pre = 0;
        int cur = 0;
        int haveDiffer = 0;
        for (int i = 1; i < nums.length-1; i++) {
            if (nums[i] != nums[i+1]) haveDiffer++;
            if (nums[i+1] == nums[i] && nums[i] != nums[i-1]){
                pre = nums[i] - nums[i-1];
                continue;
            }

            if (nums[i-1] == nums[i] && nums[i] != nums[i+1]){
                cur = nums[i+1] - nums[i];
                if (pre == 0)continue;
                if ((pre > 0) != (cur > 0)) count++;
                continue;
            }

            //没有相等的数时
            if ((nums[i] > nums[i-1] && nums[i] > nums[i+1]) ||(nums[i] < nums[i-1] && nums[i] < nums[i+1])){
                count++;
            }
            if (i == nums.length-2 && haveDiffer == 0) count--;
        }
        return count;
    }
}
