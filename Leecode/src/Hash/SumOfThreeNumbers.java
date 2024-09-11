package Hash;

import java.util.*;

/***
 * 三数之和，有点意思，需要注意的细节很多，比如去重
 * 法一：双指针，或者说三指针
 * 法二:hash法
 */
public class SumOfThreeNumbers {
    //法一
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) return res;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) return res;
            if (i > 0 && nums[i] == nums[i - 1]) {  // 去重a,必须为nums[i] == nums[i - 1]，如果是+1，会直接跳过去一些数，只有先参与，后重复再删除
                continue;
            }
            int left = i+1;
            int right = nums.length -1;
            while (right >left){
                int sum = nums[i] +nums[left] +nums[right];
                if(sum > 0) right--;
                else if (sum < 0) left++;
                else {
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(right > left && nums[right] == nums[right+1]) right--;//去重right
                    while(right > left && nums[left] == nums[left-1]) left++;//去重left
                    right--;
                    left++;
                }
            }
        }
        return res;
    }

//     public   static  List<List<Integer>> threeSum(int[] nums) {
//         HashMap<Integer, Integer> hMap = new HashMap<>();
//         List<List<Integer>> res = new ArrayList<>();
//         HashSet<List> lists = new HashSet<>();
//         if (nums.length < 3) return res;
//         Arrays.sort(nums);
//         for (int num : nums) {
//             hMap.put(num, hMap.getOrDefault(num,0)+1);
//         }
//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] > 0)return res;
//             if (i > 0 &&nums[i] == nums[i-1]) continue;
//             for (int j = i+1; j < nums.length; j++) {
//                 if (j > 0 &&nums[j] == nums[j-1]) continue;
//                 int c  = 0-nums[i]-nums[j];
//                 int times = hMap.getOrDefault(c,0);
//                 if (nums[i] == c) times--;
//                 if (nums[j] == c) times--;
//                 if (times > 0){
//                     lists.add(Arrays.asList(nums[i],nums[j],c));
//                 }
//             }
//         }
//         for (List list : lists) {
//             res.add(list);
//         }
//         return res;
//     }
}
