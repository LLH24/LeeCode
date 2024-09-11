package StacksAndQueues;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/***
 * Linkelist比stack快
 * stacks vector的子类，是线程安全的，运行速度会慢
 */
public class SuffixExpressionOperation {
    public  static  int evalRPN(String[] tokens) {
        Deque<Integer> ints = new LinkedList();//比stack快
        for (int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals("+")){
                ints.push(ints.pop()+ints.pop());
            }else if (tokens[i].equals("-")){
                int intAfter = ints.pop();
                int intBefore = ints.pop();
                ints.push(intBefore-intAfter);
            }else if (tokens[i].equals("*")){
                ints.push(ints.pop()*ints.pop());
            }else if (tokens[i].equals("/")){
                int intAfter = ints.pop();
                int intBefore = ints.pop();
                ints.push(intBefore/intAfter);
            }else {
                Integer popInt = Integer.valueOf(tokens[i]);
                ints.push(popInt);
            }
        }
        return ints.pop();
    }
}
