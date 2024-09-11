package ArraysAndLinkedLists;

public class ReverseLinkedList {
    /***
     * 链表反转(双指针法，一个在前，一个在后，利用temp保存信息)
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head == null)return null;
        ListNode pre = head;
        ListNode cur = head.next;
        pre.next = null;
        while(cur != null){
            ListNode temp = pre;
            pre = cur;
            cur = cur.next;
            pre.next = temp;
        }
        return pre;
    }
}
