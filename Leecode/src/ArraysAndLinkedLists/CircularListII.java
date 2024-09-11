package ArraysAndLinkedLists;

public class CircularListII {
    /***
     * 非常好，非常有意思的一个题目
     * 快慢指针，慢为1，快为慢的两倍，两个一定会相交
     * 假设出发点到环形交点距离为x，环形交点到快慢指针交点的距离为y，指针交点到环形交点距离为z
     * 2（x+y） = x+y+n(y+z)
     * x= n(y+z)-y
     * 其意义为：x的长度，就是从快慢指针交点走n圈后-y到达环形交点的距离
     * 意味着，环形交点的位置，就是一个从头走，一个从快慢指针交点走，他们相遇的位置
     * X = 转了N圈加Z，所以，只要从快慢指针交点出发，相遇则为X尾部的交点
     *
     *
     *
     *方法二：非常的简单，用hash表，相同的node会被保存的相同的位置
     * if (visited.contains(pos)) {
     *                 return pos;
     *             } else {
     *                 visited.add(pos);
     *             }
     *只需要如此就可以了
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode virtulNode = new ListNode(0, head);
        int pos = 0;
        if(head == null){
            pos = -1;
            return null;
        }
        ListNode slow = virtulNode.next;
        ListNode fast = virtulNode.next.next;
        while(slow != fast){
            if (fast == null || fast.next == null) {
                pos = -1;
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode overlappingNode = slow;
        ListNode curNode = virtulNode;
        while(overlappingNode != curNode){
            overlappingNode = overlappingNode.next;
            curNode = curNode.next;
            pos++;
        }
        return curNode;
    }
}
