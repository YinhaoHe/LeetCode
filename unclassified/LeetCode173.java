/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {
    //将BST全部放入一个数组里面
    //inorder遍历 由于中序遍历会得到从小到大的有序数组
    ArrayList<Integer> sortedNode; // declare an ArrayList
    int index;
    

    public BSTIterator(TreeNode root) {
        this.sortedNode = new ArrayList<Integer>();
        this.index = 0;
        this.inorder(root);
    }
    
    private void inorder(TreeNode root) {
        if (root == null) return;
        this.inorder(root.left);
        this.sortedNode.add(root.val);
        this.inorder(root.right);
    }
    
    /** @return the next smallest number */
    public int next() {
        return this.sortedNode.get(this.index ++);
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return this.index < this.sortedNode.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */