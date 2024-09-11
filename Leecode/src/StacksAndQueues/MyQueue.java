package StacksAndQueues;

import java.util.Queue;
import java.util.Stack;

public class MyQueue {
    Stack<Integer> stackIn = new Stack<>();
    Stack<Integer> stackOut = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        ImplementOut(stackIn,stackOut);
        return (Integer) stackOut.pop();
    }

    public int peek() {
        ImplementOut(stackIn,stackOut);
        return (Integer)stackOut.peek();
    }

    public boolean empty() {
        if (stackIn.isEmpty() && stackOut.isEmpty()){
            return true;
        }else  return false;
    }

    public void ImplementOut(Stack stackIn,Stack stackOut){
        if (!empty()){
            if (stackOut.isEmpty()){
                int staticNumber = stackIn.size();
                for (int i = 0; i < staticNumber; i++) {
                    Integer number = (Integer) stackIn.pop();
                    stackOut.push(number);
                }
            }
        }
    }
}
