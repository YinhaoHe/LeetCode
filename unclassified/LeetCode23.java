/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //Use merge 2 sorted list to implement k lists
    public ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode dummyhead = head;
        
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                head.next = l1;
                head = head.next;
                l1 = l1.next;
            } else {
                head.next = l2;
                head = head.next;
                l2 = l2.next;
            }
        }
        
        if (l1 != null) head.next = l1;
        if (l2 != null) head.next = l2;
        
        return dummyhead.next;
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 1) {
            return lists[0];
        }
        if (lists.length == 0) {
            return null;
        }
        ListNode ans = merge2Lists(lists[0], lists[1]);
        for (int i = 2; i < lists.length; i ++) {
            ans = merge2Lists(ans, lists[i]);
        }
        return ans;
    }
}