package ArraysAndLinkedLists;

public class SwapNodesInALinkedListPairwise {
    /***
     * 两两交换链表节点，非递归解
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null)return null;
        ListNode virtulHead = new ListNode(0,head);
        ListNode pre ;
        ListNode cur ;
        ListNode temp = virtulHead;
        while(temp.next != null && temp.next.next != null){//判断后两个节点是否存在
            pre = temp.next;//如果存在，对这两个节点，进行重新标记和排序
            cur = pre.next;
            pre.next = cur.next;
            cur.next = pre;
            temp.next = cur;
            temp = pre;
        }
        return virtulHead.next;
    }
}
