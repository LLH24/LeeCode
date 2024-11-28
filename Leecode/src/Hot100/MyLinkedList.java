package Hot100;


public class MyLinkedList {
    /***
     * 相交链表
     * 双指针，天才
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;
        while (A != B) {//真没有交点，也会一起到达最后的null
            A = A == null ? headB : A.next;
            B = B == null ? headA : B.next;
        }
        return A;
    }

    /***
     * 翻转链表，也不简单
     * 有时候画图会好理解很多
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode cur = head;
        ListNode pre = null;
        ListNode next = cur.next;
        while (next != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
        }
        cur.next = pre;
        return cur;
    }

    /***
     * 回文链表
     * @param head
     * @return
     */
    ListNode firstPoint;

    public boolean isPalindrome(ListNode head) {
        firstPoint = head;
        return toComnpare(head);
    }

    public boolean toComnpare(ListNode cur) {
        if (cur == null) return true;
        boolean results = toComnpare(cur.next);
        if (results == false) return false;
        if (cur.val == firstPoint.val) {
            firstPoint = firstPoint.next;
            return true;
        } else return false;

    }

    /***
     * 环形链表
     * 我觉得起码两个方法
     * 一个是hash，存在过的直接就知道了
     * 一个是快慢指针，一个走两个，一个走一个
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = new ListNode();
        ListNode fast = new ListNode();
        slow.next = head;
        fast.next = head;
        while (slow != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null) return false;
            fast = fast.next;
            if (fast == null) return false;
            if (fast == slow) return true;
        }
        return false;
    }

    /***
     * 环形列表II
     * @param head
     * @return
     */

    public ListNode detectCycle(ListNode head) {
        ListNode slow = new ListNode();
        ListNode fast = new ListNode();
        ListNode againPoint = new ListNode();
        slow.next = head;
        fast.next = head;
        againPoint.next = head;
        while (slow != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null) return null;
            fast = fast.next;
            if (fast == null) return null;
            if (fast == slow) {
                break;
            }
        }
        while (fast != againPoint) {
            againPoint = againPoint.next;
            fast = fast.next;
        }
        return againPoint;
    }

    /***
     * 合并两个有序链表
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode pre = new ListNode();
        ListNode cur = new ListNode();
        pre.next = cur;
        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                cur.next = list2;
                cur = cur.next;
                list2 = list2.next;
            } else {
                cur.next = list1;
                cur = cur.next;
                list1 = list1.next;
            }
        }
        if (list1 == null) {
            cur.next = list2;
        } else if (list2 == null) {
            cur.next = list1;
        }
        return pre.next.next;
    }


    /***
     * 两数相加
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode();
        ListNode cur = new ListNode();
        pre.next = cur;
        int preNumber = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + preNumber;
            preNumber = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l2 != null) {
            int sum = l2.val + preNumber;
            l2.val = (sum) % 10;
            preNumber = sum / 10;
            cur.next = l2;
            cur = cur.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + preNumber;
            l1.val = (sum) % 10;
            preNumber = sum / 10;
            cur.next = l1;
            cur = cur.next;
            l1 = l1.next;
        }
        if (preNumber == 1){
            cur.next = new ListNode(1);
        }

        return pre.next.next;
    }
}
