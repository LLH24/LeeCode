package BacktrackingAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class SplitPalindromeString {
    /***
     * 分割回文串
     * @param s
     * @return
     */
    ArrayList<String> combines = new ArrayList<>();
    ArrayList<List<String>> results = new ArrayList<>();

    public List<List<String>> partition(String s) {
        char[] charArray = s.toCharArray();
        findCombination(charArray,0);
        return results;
    }

    public void findCombination(char[] array,int start){
        if (start == array.length) {
            results.add(new ArrayList<>(combines));
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();//每一层维护一个自己的stringbulider
        for (int i = start; i < array.length; i++) {
            stringBuilder.append(array[i]);
            if (ispalindromeString(stringBuilder)) {
                combines.add(stringBuilder.toString());
                findCombination(array,i+1);
                combines.removeLast();
            }
        }
    }

    public boolean ispalindromeString(StringBuilder s){
        /*
        我这是双指针法
        后面会学习动态规划法，判断，这个判断会牛很多
         */
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length()-1-i)) return false;
        }
        return true;
    }
}