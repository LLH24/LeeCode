package ArraysAndLinkedLists;

public class RemoveLinkedListElements {
    /***
     * 虚拟头节点的方式
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return head;
        }//这里已经是有值了
        ListNode pre = new ListNode(-1, head);
        ListNode virtualHead = pre;//用于记录头虚拟头节点
        while(pre.next!=null){//后面有值的情况
            if(pre.next.val == val){
                pre.next = pre.next.next;
            }else {
                pre = pre.next;
            }
        }
        return virtualHead.next;
    }


    /***
     * 未用虚拟头节点
     * @param head
     * @param val
     * @return
     */
//    public ArraysAndLinkedLists.ListNode removeElements(ArraysAndLinkedLists.ListNode head, int val) {
//        if(head == null)return head;
//        else {
//            while(head!= null&&head.val == val){
//                head = head.next;
//            }
//        }
//        if(head == null)return head;
//        ArraysAndLinkedLists.ListNode pre = head;
//        ArraysAndLinkedLists.ListNode returnHead = pre;
//        while(pre.next != null){
//            if (pre.next.val == val)pre.next = pre.next.next;
//            else pre = pre.next;
//        }
//        return returnHead;
//    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}