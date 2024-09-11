package StacksAndQueues;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MyStack {
    LinkedList<Integer> list = new LinkedList<>();
    public MyStack() {

    }

    public void push(int x) {
        list.offer(x);
    }

    public int pop() {
        turnaroundList(list);
        return list.pop();
    }

    public int top() {
        turnaroundList(list);
        Integer lastNumber = list.pop();
        list.offer(lastNumber);
        return lastNumber;
    }

    public boolean empty() {
        if (list.isEmpty()) return true;
        else return false;
    }

    public void turnaroundList(LinkedList list){
        if (!empty()){
            for (int i = 0; i < list.size()-1; i++) {
                list.offer(list.pop());
            }
        }
    }
}
