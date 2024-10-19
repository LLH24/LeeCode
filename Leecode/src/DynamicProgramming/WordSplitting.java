package DynamicProgramming;

import java.util.HashSet;
import java.util.List;

public class WordSplitting {
    /***
     * 单词拆分
     * 先遍历背包容量，再遍历物品
     * 但是这个背包的遍历是双指针的
     * 遍历物品是用contains
     * s.substring()左闭右开
     * 画图解决，想象力会很累
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        String sforReturn = new String(s + '1');
        HashSet<String> strings = new HashSet<>();
        for (String string : wordDict) {
            strings.add(string);
        }
        boolean[] dp = new boolean[s.length()+1];//dp【】代表的是容量，就是几个字母
        dp[0] = true;
        for (int j = 0; j < s.length(); j++) {
            if (!dp[j]) continue;
            for (int i = j; i < s.length(); i++) {
                String substring = sforReturn.substring(j, i + 1);
                if (strings.contains(substring) == true) dp[i+1] = true;
            }
        }
        return dp[s.length()];
    }
}
