import DynamicProgramming.*;
import GreedyAlgorithm.DistributeCandies;
import GreedyAlgorithm.DivideLetterIntervals;
import GreedyAlgorithm.IgniteBalloonMinimumArrows;
import GreedyAlgorithm.ReconstructQueueBasedOnHeight;
import Hot100.*;

import java.util.LinkedList;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(1);
        myLinkedList.isPalindrome(listNode);
    }
}