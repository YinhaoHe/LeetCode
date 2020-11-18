/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next; 
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// Use hashSet to track the nodeVisited
/*
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodeVisited = new HashSet<>();
        while (head != null) {
            if (nodeVisited.contains(head)) {
                return true;
            } else {
                nodeVisited.add(head);
            }
            head = head.next;
        }
        return false;
    }
}
*/

// Use two pointers; one is slow; the other one is fast; slow one move one step at a time; while fast one moves two steps at a time
// if there is a circle; two pointers will eventually meet since fast one will catch up from behind; 
// Otherwise, the fast one will meet the end finally.

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}