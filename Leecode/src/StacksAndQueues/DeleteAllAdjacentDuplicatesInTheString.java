package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Stack;

public class DeleteAllAdjacentDuplicatesInTheString {
    /***
     * 删除字符串中的所有相邻重复项
     * 使用栈的思想，不一定要使用栈
     * class Solution {
     *     public String removeDuplicates(String s) {
     *         StringBuffer stack = new StringBuffer();
     *         int top = -1;
     *         for (int i = 0; i < s.length(); ++i) {
     *             char ch = s.charAt(i);
     *             if (top >= 0 && stack.charAt(top) == ch) {
     *                 stack.deleteCharAt(top);
     *                 --top;
     *             } else {
     *                 stack.append(ch);
     *                 ++top;
     *             }
     *         }
     *         return stack.toString();
     *     }
     * }
     *
     * 作者：力扣官方题解
     *
     *
     * 在字符拼接上，StringBuilder会快很多
     */
    public String removeDuplicates(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
             if (!stack.isEmpty() && stack.peek() == s.charAt(i)){
                stack.pop();
            }else {
                 stack.push(s.charAt(i));
             }
        }
        //在字符拼接上，StringBuilder会快很多
        StringBuilder returnString = new StringBuilder();
        while(!stack.isEmpty()){
            returnString= returnString.insert(0,stack.pop());
        }
        return  new String(returnString);
    }
}
