package StacksAndQueues;

import java.util.Stack;

/***
 * 用栈来处理对称问题
 */

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(')');
            else if (s.charAt(i) == '[') stack.push(']');
            else if (s.charAt(i) == '{') stack.push('}');
            else if (s.charAt(i) == ' ');
            //这里开始变为右边的东西了
            else {
                if(stack.isEmpty()) return false;
                if (s.charAt(i) != stack.pop()) return false;
            }
        }
        if (stack.isEmpty()) return true;
        else return false;
    }
}
