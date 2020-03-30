/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyhead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyhead;
        
        while (p != null && q != null) {
            if (p.val <= q.val) {
                curr.next = p;
                p = p.next;
            } else {
                curr.next = q;
                q = q.next;
            }
            curr = curr.next;
        }
        if (p != null) curr.next = p;
        if (q != null) curr.next = q;
        
        return dummyhead.next;
    }
}