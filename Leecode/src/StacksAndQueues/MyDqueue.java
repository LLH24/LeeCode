package StacksAndQueues;

import java.util.Deque;
import java.util.LinkedList;

public class MyDqueue {
    Deque<Integer> deque = new LinkedList<Integer>();

    public void add(int val){
        while(!deque.isEmpty() && val > deque.getLast()){
            deque.pollLast();
        }
        deque.addLast(val);
    }

    public int getMax(){
        return deque.getFirst();
    }

    public void poll(int value){
        if (value == deque.getFirst()){
            deque.pollFirst();
        }
    }
}
