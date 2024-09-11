package Hash;

import java.util.HashMap;

/***
 * 两数之和
 * 使用哈希表，可以将寻找 target - x 的时间复杂度降低到从 O(N) 降低到 O(1)。
 * 这样我们创建一个哈希表，对于每一个 x，我们首先查询哈希表中是否存在 target - x，然后将 x 插入到哈希表中，即可保证不会让 x 和自己匹配。
 */

public class SumOfNumber {
    public int[] twoSum(int[] nums, int target) {
        int[] ints = new int[2];
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        if(nums == null) return null;
        for (int i = 0; i < nums.length; i++) {

            if(integerIntegerHashMap.containsKey(target - nums[i])){
                ints[0] = i;
                ints[1] = integerIntegerHashMap.get(target - nums[i]);
                return  ints;
            }else integerIntegerHashMap.put(nums[i],i);
        }
        return null;
    }
}
