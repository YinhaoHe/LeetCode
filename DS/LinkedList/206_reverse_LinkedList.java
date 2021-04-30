class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp;
        
        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            // Update pre and cur
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}

//////////////////////////

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}