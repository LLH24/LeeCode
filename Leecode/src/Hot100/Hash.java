package Hot100;

import java.util.*;

public class Hash {
    /***
     * 两数之和
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) return null;
        int[] results = new int[2];
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (integerIntegerHashMap.containsKey(target-nums[i])){
                results[0] = i;
                results[1] = integerIntegerHashMap.get(target-nums[i]);
            }else {
                integerIntegerHashMap.put(nums[i],i);
            }
        }
        return null;
    }

    /***
     * 字母异位词分组
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> stringListHashMap = new HashMap<>();
        if (strs.length == 0) return null;
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String s = String.valueOf(charArray);
            if (stringListHashMap.containsKey(s)){
                List<String> stringsAfter = stringListHashMap.get(s);
                stringsAfter.add(str);
            }else {
                LinkedList<String> strings = new LinkedList<>();
                strings.add(str);
                stringListHashMap.put(s,strings);
            }
        }
        Set<Map.Entry<String, List<String>>> entries = stringListHashMap.entrySet();
        LinkedList<List<String>> lists = new LinkedList<>();
        for (Map.Entry<String, List<String>> entry : entries) {
            List<String> value = entry.getValue();
            lists.add(value);
        }
        return lists;
    }

    /***
     * 最长连续序列
     * @param nums
     * @return
     */
    int max = 1;
    int current = 1 ;
    HashSet<Integer> integers = new HashSet<>();
    public int longestConsecutive(int[] nums) {
        if ( nums.length == 0) return 0;


        for (int i = 0; i < nums.length; i++) {
           integers.add(nums[i]);
        }
        for (Integer integer : integers) {
            if (integers.contains(integer-1)){
                continue;
            }else {
                diedai(integer+1);
            }
        }
        return max;
    }

    public void diedai(int number){
        if (integers.contains(number)){
            current++;
            diedai(number+1);
        }else {
            max = Math.max(max,current);
            current = 1;
            return;
        }
    }
}
