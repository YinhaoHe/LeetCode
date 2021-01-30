/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//redo


class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // DO NOT FORGET THE EDGE CASE
        // When p and q both null
        if (p == null && q == null) {
            return true;
        } else if (p == null && q != null || p != null && q == null) {
            return false;
        }
        
        // if both not null
        
        if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}