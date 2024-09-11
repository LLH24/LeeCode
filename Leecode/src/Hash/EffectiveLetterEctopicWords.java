package Hash;

public class EffectiveLetterEctopicWords {
    /***
     * 有效的字母异位词，用hash法实现
     */
    public boolean isAnagram(String s, String t) {
        int[] ints = new int[26];
        if (s.length() != t.length())return  false;
        for (int i = 0; i < s.length(); i++) {
            ints[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            ints[t.charAt(i)-'a']--;
        }
        for (int anInt : ints) {
            if (anInt != 0 ){
                return false;
            }
        }
        return true;
    }
}
