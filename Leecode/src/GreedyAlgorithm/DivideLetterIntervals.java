package GreedyAlgorithm;

import java.util.LinkedList;
import java.util.List;

public class DivideLetterIntervals {
    /***
     * 划分字母区间
     * 有点意思
     * 记录每一个字母的最大下标
     * 在当前下标和当前之前字母的最大下标相同时，截断
     * @param s
     * @return
     */
    public List<Integer> partitionLabels(String s) {
        char[] charArray = s.toCharArray();
        LinkedList<Integer> results = new LinkedList<>();
        int[] letter = new int[26];
        for (int i = 0; i < charArray.length; i++) {
            letter[charArray[i] - 'a'] = i;//出现的每个字母的最后位置
        }
        int maxIndex = -1;
        int cutIndex = 0;
        for (int i = 0; i < charArray.length; i++) {//记录下在下标前的字母最大下标
            maxIndex = Math.max(letter[charArray[i] - 'a'],maxIndex);
            if (i == maxIndex){
                results.add(i-cutIndex+1);
                cutIndex = i+1;
            }
        }
        return results;
    }
}
