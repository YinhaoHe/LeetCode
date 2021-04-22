/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Preorder to travesal the tree
    public String preorderSerialize (TreeNode root, String str) {
        // Root:
        if (root == null) {
            str += "null,";
        } else {
            str += str.valueOf(root.val) + ",";
            
            //其他的丢给结构体
            str = preorderSerialize(root.left, str);
            str = preorderSerialize(root.right, str);
        }
        return str;
    }
/* 用StringBuilder 直接append是个更好的想法 没必要一点一点的str + 

    public String serialize(TreeNode root) {
        if(null == root) return "#";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val)
        .append(",").append(serialize(root.left))
        .append(",").append(serialize(root.right));
        
        return sb.toString();
    }
*/
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return preorderSerialize(root, "");
    }
    
    // preorder to construct tree
    public TreeNode preorderDeserialize (List<String> l) {
        if (l.get(0).equals("null")) {
            l.remove(0);
            return null;
        }
        
        // preorder recursion to construct the tree
        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = preorderDeserialize(l);
        root.right = preorderDeserialize(l);
        
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) { // 传入的参数是一个字符串
        
        //data = String.valueOf(data); in case there will be some 空字符在data中
        //貌似没有B用？
        
        String[] data_array = data.split(","); //将字符串分割成字符串数组
        
        //if (data_array.length == 0) return null;
        // 其实也可以不需要考虑数组为0 因为本题目中反序列化中数组不可能为0
        
        List<String> data_list = new LinkedList<String>(Arrays.asList(data_array)); // 将字符串数组转化成字符串列表
        return preorderDeserialize(data_list); // 按照前序遍历 构建二叉树
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));