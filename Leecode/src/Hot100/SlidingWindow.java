package Hot100;

import java.util.*;

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

    /***
     * 找到字符串中所有字母异位词
     */

    /***
     * 可以，但是超时
     * @param s
     * @param p
     * @return
     */
//    public List<Integer> findAnagrams(String s, String p) {
//        char[] charArray = p.toCharArray();
//        char[] charArrayS = s.toCharArray();
//        HashMap<Character, Integer> characterIntegerHashMap = new HashMap<>();
//
//        for (char c : charArray) {
//            characterIntegerHashMap.put(c,characterIntegerHashMap.getOrDefault(c,0)+1);
//        }
//        LinkedList<Integer> integers = new LinkedList<>();
//        for (int i = 0; i < charArrayS.length && i< charArrayS.length-charArray.length+1; i++) {
//            HashMap<Character, Integer> clone = (HashMap<Character, Integer>)characterIntegerHashMap.clone();
//            for (int j = i;j< i+charArray.length ;j++){
//                if (clone.containsKey(charArrayS[j]) && clone.get(charArrayS[j]) != 0) {
//                   clone.put(charArrayS[j],clone.get(charArrayS[j])-1);
//                    if (j == i+charArray.length-1) integers.add(i);
//                }
//                else break;
//            }
//        }
//        return integers;
//    }

        public List<Integer> findAnagrams(String s, String p) {
            char[] charArrayS = s.toCharArray();
            char[] charArrayP = p.toCharArray();
            int[] pInt = new int[26];
            for (char c : charArrayP) {
                pInt[c - 'a']++;
            }

               MyLinkedList<Integer> integers = new MyLinkedList<>();
            for (int i = 0; i < charArrayS.length && i < charArrayS.length - charArrayP.length + 1; i++) {
                int[] clone = pInt.clone();
                for (int j = i; j < i + charArrayP.length; j++) {
                    clone[charArrayS[j] - 'a']--;
                    if (clone[charArrayS[j]-'a'] < 0) break;
                    if (j == i+charArrayP.length-1) integers.add(i);
                }

            }
            return integers;
        }

}
