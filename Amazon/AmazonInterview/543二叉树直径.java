/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: a root of binary tree
     * @return: return a integer
     */
    private int max = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        // write your code here
        dfs(root);
        return max;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int L = dfs(node.left);
        int R = dfs(node.right);
        max = Math.max(L+R, max);
        return Math.max(L, R) + 1;
    }
}