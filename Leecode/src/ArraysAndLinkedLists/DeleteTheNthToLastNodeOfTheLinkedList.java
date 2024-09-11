package ArraysAndLinkedLists;

public class DeleteTheNthToLastNodeOfTheLinkedList {
    /***
     * 双指针法
     * 删除倒数第几个节点
     * 其实就是两个指针固定差值同步移动
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode virtulNode = new ListNode(0, head);
        ListNode slow = virtulNode;
        ListNode fast = virtulNode;
        while (n!= 0){
            fast = fast.next;
            n--;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        if(slow.next != null)
        slow.next = slow.next.next;
        return virtulNode.next;
    }
}
