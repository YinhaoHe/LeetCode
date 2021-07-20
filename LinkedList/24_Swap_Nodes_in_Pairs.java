/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode swapHead = dummy;
        ListNode first, second;
        while(swapHead.next != null && swapHead.next.next != null) {
            first = swapHead.next;
            second = first.next;
            first.next = second.next;
            second.next = first;
            swapHead.next = second;
            swapHead = swapHead.next.next;
        }
        return dummy.next;
    }
}