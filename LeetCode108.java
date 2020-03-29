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
    // height balance means we need to select the node at the mid to be the root
    // Sorted array -> inorder to construct the tree
    
    // In order to let inorder() work, we need to declare the int[] nums first
    // Because the function is writen before sortedArrayBST
    public int[] nums;
    
    public TreeNode inorder (int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        
        // New TreeNode root needs to use the construct function which should be
        TreeNode root = new TreeNode(nums[mid]);
        //It should not be defined by TreeNode root; root.val = nums[mid];
        
        root.left = inorder(left, mid - 1);
        root.right = inorder(mid + 1, right);
        return root;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums; // Give the parameter to the public int[] nums in class solution
        return inorder(0, nums.length - 1);
    }
}