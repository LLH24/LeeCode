package ArraysAndLinkedLists;

public class MyLinkedList {
    public int  size = 0;
    public ListNode virtulHead = new ListNode(0);

    public MyLinkedList() {

    }

    public int get(int index) {
        ListNode pre = virtulHead;
        if(size <= index || index < 0) return -1;
        else {
            while(index >= 0){
                pre = pre.next;
                index--;
            }
            return pre.val;
        }
    }

    public void addAtHead(int val) {
        ListNode listNode = new ListNode(val);
        listNode.next = virtulHead.next;
        virtulHead.next = listNode;
        size++;
    }

    public void addAtTail(int val) {
        ListNode pre = virtulHead;
        ListNode listNode = new ListNode(val);
        while (pre.next != null) pre = pre.next;
        pre.next = listNode;
        listNode.next = null;
        size++;
    }

    public void addAtIndex(int index, int val) {
        ListNode pre = virtulHead;
        ListNode listNode = new ListNode(val);
        if (index<0){
            addAtHead(val);
        }
        if (size >= index){
            while(index > 0){//这里不用=我们要找前一个
                pre = pre.next;
                index--;
            }
            listNode.next=pre.next;
            pre.next = listNode;
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        ListNode pre = virtulHead;
        if (index >= 0 && index < size){
            while (index > 0){
                pre = pre.next;
                index--;
            }
            pre.next = pre.next.next;
            size--;
        }
    }
}
