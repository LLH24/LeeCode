package ArraysAndLinkedLists;

class RemoveElement {
    /***
     * 单向快慢指针
     * @param nums
     * @param val
     * @return
     */
//    public int removeElement(int[] nums, int val) {
//        int slowIndex = 0 ;
//        for (int fastIndex = 0 ;fastIndex<nums.length;fastIndex++){
//            if(nums[fastIndex] != val){
//                nums[slowIndex] = nums[fastIndex];
//                slowIndex++;
//            }
//        }
//        return slowIndex;
//    }

    /***
     * 双向指针
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length-1 ;
//        while(nums[right] >= 0 && nums[right] == val)right--;
        while(right >= 0 && nums[right] == val)right--;//这里很重要，这意味着[]的情况不会存在，right--变为-1时，可以被阻止
        while(left<=right){
            if (nums[left] == val){
                nums[left] = nums[right];
                right--;
            }
            left++;
            while(nums[right] >= 0 && nums[right] == val){right--;}
        }
        return left;
    }
}
