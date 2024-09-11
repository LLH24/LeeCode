package ArraysAndLinkedLists;

public class IntersectionOflLinkedLists {
    /***
     * 求链表相交的节点
     * 这个题，只要相交就一定合并到最后
     * 我们只需要依次判断后面几个是否相交
     * 有pre就很好判断，没有的话，我们通过计算长度，从短的头部开始判断
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA= 0;
        int lenB= 0;
        ListNode curA = headA;
        ListNode curB = headB;
        while(headA!= null){
            lenA++;
            headA = headA.next;
        }

        while(headB!= null){
            lenB++;
            headB = headB.next;
        }

        if (lenA >= lenB){
            int gap =lenA -lenB;
            while(gap != 0){
                curA = curA.next;
                gap--;
            }
            while(curA != null){
                if(curA == curB){
                    return curA;
                }
                curA = curA.next;
                curB = curB.next;
            }
            return null;
        }
        else {
            int gap =lenB -lenA;
            while(gap != 0){
                curB = curB.next;
                gap--;
            }
            while(curB != null){
                if(curA == curB){
                    return curA;
                }
                curB = curB.next;
                curA = curA.next;
            }
            return null;
        }
    }
}
