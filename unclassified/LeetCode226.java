/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
    // recursive    
        // if (root == null) return null;
        // TreeNode right = invertTree(root.right);
        // TreeNode left = invertTree(root.left);
        // root.left = right;
        // root.right = left;
        // return root;
    //iterative
        if(root == null) return null;
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.add(root);
        while (!que.isEmpty()) {
            TreeNode current = que.poll();
            TreeNode tmp = current.left;
            current.left = current.right;
            current.right = tmp;
            if (current.left != null) que.offer(current.left);
            if (current.right != null) que.offer(current.right);
        }
        return root;
    }
}