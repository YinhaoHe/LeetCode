/*
Problem statement:
Given a binary tree where some of the nodes need to be removed from the tree. Output the forest (collection of trees) created by removing the nodes indicated by node.shouldBeRemoved == True.

Example:
Given a tree with sequentially lettered nodes A - H, for which node.shouldBeRemoved will return True for B, J and I (depicted in brackets in the diagram below), and False for the rest.

     F
    / \
   /   \  
 [B]     G 
 / \     /\
A   D  [J] [I]
   / \     / 
  C   E   H   


The resulting forest root list is : [ A, D, F, H ]

A  F      D    H
    \    / \
     G  C   E
*/

class TreeNode { 
	int val; // value of the node
	TreeNode left; // left child of root
	TreeNode right; // right child of root
	TreeNode parent; // parent of root
	boolean shouldBeRemoved; // removeBoolean
	TreeNode (int x) { 
		Val = x; //consturct 
	}
}

class removeNode {
            main(TreeNode root){
            	TreeSet = set();
             	findNode(root);
             	return TreeSet;
            }
	public void findNode (TreeNode root) {
      	if (!root.shouldBeRemoved && root.parent == null && root.parent.val != null) {
         	TreeSet.add(root);
     	}
                       
		if (root != null) {
			findNode(root.left);
			findNode(root.right);
			if (root.shouldBeRemoved) {
				root.val = null;
			}
	 	}
	}
}
