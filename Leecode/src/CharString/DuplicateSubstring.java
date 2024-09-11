package CharString;

public class DuplicateSubstring {
    /***
     * 重复子字符串
     * 还是KMP算法的衍生
     * 只要涉及大字符串里找小字符串
     * 基本都用KMP算法
     * 之前的算法，是将小的匹配串找前缀表
     * 现在的算法是找大的前缀表，因为只有大的
     * 双指针法是字符串处理的常客。
     *
     * KMP算法是字符串查找最重要的算法，但彻底理解KMP并不容易，我们已经写了五篇KMP的文章，不断总结和完善，最终才把KMP讲清楚。
     */
    public boolean repeatedSubstringPattern(String s) {
        int[] next = new int[s.length()];
        getNext(next,s);
        if (next[s.length()-1] == 0) return false;
        int dupStrLenth = s.length() - next[s.length()-1];
        if (s.length()%dupStrLenth == 0){
            return true;
        }else return false;
    }

    public void getNext(int[] next, String s) {
        int i = 0;
        int j = 1;
        next[0] = 0;
        while (j < s.length()) {
            while (i > 0 && s.charAt(j) != s.charAt(i)) {
                i = next[i - 1];
            }
            if (s.charAt(j) == s.charAt(i)) {
                i++;
                next[j] = i;
            }
            j++;
        }
    }
}
