package Hash;

public class RansomLetter {
    /***
     * ransomNote的值必须在magazine范围内
     * 注意：能用数组用数组，不能用数组采用hash方法
     * 数组的本质就是，数组位置为hash计算值
     * 数组值为value
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] magazineChar = magazine.toCharArray();
        char[] ransomNoteChar = ransomNote.toCharArray();
        int[] times = new int[26];
        for (char c : magazineChar) {
            times[c - 'a']+=1;
        }
        for (char c : ransomNoteChar) {
            times[c - 'a'] -=1;
            if (times[c - 'a'] == -1) return  false;
        }
        return true;
    }
}
