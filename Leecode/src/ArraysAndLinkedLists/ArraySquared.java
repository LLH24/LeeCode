package ArraysAndLinkedLists;

public class ArraySquared {
    /**
     * 给一个升序（有负数）数组平方排序
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int i = nums.length-1;
        int[] result = new int[nums.length];
        while (left <= right){
            if(nums[left]*nums[left] <= nums[right]*nums[right]){
                result[i] = nums[right]*nums[right];
                right--;
            }else {
                result[i] = nums[left]*nums[left];
                left++;
            }
            i--;
        }
        return result;
    }
}
