package BacktrackingAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class TelephoneNumberAndLetter {
    String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    ArrayList<String> results = new ArrayList<>();
    StringBuilder result = new StringBuilder();

    /***
     * 手机号码输入数字的字母组合
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return results;
        char[] charArray = digits.toCharArray();
        combineLetter(charArray,0);
        return results;
    }

    public void combineLetter(char[] imput,int imputIndex){
        //终止条件
        if (result.length() == imput.length) {
            results.add(new String(result));
            return;
        }

        //中间处理
        int numberIndex = imput[imputIndex] - '0';
        /*这里很好，ascall码中是相邻的，所以可以这样求对应的值
        如果是string就用int i = Integer.valueOf("123");
        如果是Char,用上述方法就是返回的ascall值，所以，最好的方法就是 -'0',因为是单个值，所以可以一直用
        */
        String stringCanChoose = numString[numberIndex];
        char[] charArray = stringCanChoose.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            result.append(c);
            combineLetter(imput,imputIndex+=1);
            result.deleteCharAt(result.length()-1);//回溯
            imputIndex -= 1;
        }
    }
}
