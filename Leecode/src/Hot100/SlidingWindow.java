package Hot100;

import java.util.HashSet;

public class SlidingWindow {
    /***
     * 无重复字符的最长子串
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> integers = new HashSet<>();
        char[] charArray = s.toCharArray();
        if (charArray.length == 0) return 0;
        if (charArray.length == 1) return 1;
        int res = 0;
        int left = 0;
        for (int right = 0; right < charArray.length; right++) {
            while (integers.contains(charArray[right])) {
                integers.remove(charArray[left]);
                left++;
            }
            integers.add(charArray[right]);
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
