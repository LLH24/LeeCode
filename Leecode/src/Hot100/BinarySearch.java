package Hot100;

public class BinarySearch {
    /***
     * 搜索插入位置
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        if (target > nums[nums.length - 1]) return nums.length;
        if (target < nums[0]) return 0;
        while (end >= start) {
            int middle = (end - start) / 2 + start;
            if (target == nums[middle]) return middle;
            else if (target > nums[middle]) {
                if (target < nums[middle + 1]) return middle + 1;
                else {
                    start = middle + 1;
                }
            } else if (target < nums[middle]) {
                if (target > nums[middle - 1]) {
                    return middle - 1;
                } else {
                    end = middle;
                }
            }
        }
        return 0;
    }

    /***
     * 搜索二维矩阵
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length - 1;
        int i = 0;
        if (target > matrix[matrix.length-1][0]) {
            i = matrix.length-1;
        }else if (target < matrix[0][0]){
            return false;
        }
        else {
            while (end >= start) {
                int middle = (end - start) / 2 + start;
                if (target == matrix[middle][0]) {
                    return true;
                } else if (target > matrix[middle][0]) {
                    if (target < matrix[middle + 1][0]) {
                        i = middle;
                        break;
                    } else {
                        start = middle + 1;
                    }
                } else if (target < matrix[middle][0]) {
                    if (target > matrix[middle - 1][0]) {
                        i = middle - 1;
                        break;
                    } else {
                        end = middle - 1;
                    }
                }
            }
        }
        start = 0;
        end = matrix[i].length - 1;
        while (end >= start) {
            int middle = (end - start) / 2 + start;
            if (target == matrix[i][middle]) {
                return true;
            } else if (target > matrix[i][middle]) {
                start = middle + 1;
            } else if (target < matrix[i][middle]) {
                end = middle - 1;
            }
        }
        return false;
    }

    /***
     * 在排序数组中查找元素的第一个和最后一个位置
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1,-1};
        if (target > nums[nums.length-1]) return new int[]{-1,-1};
        if (target < nums[0]) return new int[]{-1,-1};
        int start = 0;
        int end = nums.length-1;
        while (end >= start){
            int middle = (end - start) / 2 + start;
            if (nums[middle] == target){
                start = middle-1;
                end = middle+1;
                while (start >= 0 && nums[start] == target){
                    start--;
                }
                start++;
                while ( end <= nums.length-1 && nums[end] == target){
                    end++;
                }
                end--;
                return new int[]{start,end};
            }else if (nums[middle] > target){
                end = middle-1;
            }else if (nums[middle] < target){
                start = middle+1;
            }

        }
        return new int[]{-1,-1};
    }

    /***
     * 搜索螺旋排序数组
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while(end >= start){
            int middle = (end - start) / 2 + start;
            if (target == nums[middle]) return middle;
            if (end == start) return -1;
            if (middle == start) start = middle+1;
            if (nums[middle] > nums[start]){//前面有序
                if (  nums[start] <= target && target < nums[middle]){
                    while (end >= start) {
                        middle = (end - start) / 2 + start;
                        if (target == nums[middle]) return middle;
                        else if (target > nums[middle]) {
                                start = middle + 1;
                        } else if (target < nums[middle]) {
                                end = middle-1;
                        }
                    }
                    return -1;
                }else {
                    start = middle+1;
                }
            }else if (nums[middle] < nums[end]){//后面有序
                if (nums[middle] < target && target <= nums[end]){
                    while (end >= start) {
                        middle = (end - start) / 2 + start;
                        if (target == nums[middle]) return middle;
                        else if (target > nums[middle]) {
                            start = middle + 1;
                        } else if (target < nums[middle]) {
                            end = middle-1;
                        }
                    }
                    return -1;
                }else {
                    end = middle-1;
                }
            }
        }
        return -1;
    }

}
