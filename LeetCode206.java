/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode tmpNext = curr.next; // 用tmpNext存储curr.next
            curr.next = prev; // 将next置为前一个（prev）
            prev = curr; // 将当前curr 等于 prev
            curr = tmpNext; // 将tmpNext中存储的原先的curr.next给现在的curr 
        }
        return prev; 
    }
}