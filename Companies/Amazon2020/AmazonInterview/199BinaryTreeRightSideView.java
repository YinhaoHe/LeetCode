class Solution {
    
    public ArrayList<Integer> res = new ArrayList<>();
    
    public void dfs(TreeNode node, int level) {
        if (level == res.size()) {
            res.add(node.val);
        } 
        
        if (node.right != null) {
            dfs(node.right, level + 1);
        }
        if (node.left != null) {
            dfs(node.left, level + 1);
        }
    }
    
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return res;
        // dfs traversal
        dfs(root, 0);
        return res;
    }
}


class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            
            int level = queue.size();
            for (int i = 0; i < level; ++ i) {
                TreeNode node = queue.poll();
                if (i == level - 1) {
                    res.add(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }
}