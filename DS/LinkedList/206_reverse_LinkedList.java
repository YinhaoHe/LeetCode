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