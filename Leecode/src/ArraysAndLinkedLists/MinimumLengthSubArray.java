package ArraysAndLinkedLists;

public class MinimumLengthSubArray {
    /***
     * 找达到条件的最小连续数组
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int resultSum = 0;
        int resultLength = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            while(right-left+1 > resultLength){
                resultSum -= nums[left++];
            }//这里是固定长度的，意思是每次确定了窗口长度，你就只能更小，不能更大
            resultSum+=nums[right];
            while (resultSum >= target){
                //这里记录长度，且不断增加left值，减小窗口
                resultLength = Math.min(right - left +1,resultLength);
                resultSum -= nums[left++];
            }
        }
        return resultLength == Integer.MAX_VALUE?0:resultLength;
    }
}
