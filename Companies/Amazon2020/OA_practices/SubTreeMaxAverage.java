import java.util.*;

public class BusiestNode {
    static class EmployeeNode {
        public int value;
        public ArrayList<EmployeeNode> subEmployeeNode;
        public EmployeeNode() {
            subEmployeeNode = new ArrayList<EmployeeNode>();
        }
        public EmployeeNode(int tenure) { 
            value = tenure;
            subEmployeeNode = new ArrayList<EmployeeNode>();
        }
        // public EmployeeNode(int tenure, List<EmployeeNode> _children) {
        //     value = tenure;
        //     subEmployeeNode = _children;
        // }
    }
    
    double max;
    EmployeeNode maxNode;
    
    public EmployeeNode getBusiestNode(EmployeeNode president) {
        maxNode = null;
        max = Double.MIN_VALUE;
        
        helper(president);
        return maxNode;
    }
    
    public double[] helper(EmployeeNode root) {
        if(root == null) return new double[]{0, 0};
        double count = 1;
        double sum = root.value;
        
        if(root.subEmployeeNode != null) {
            for(EmployeeNode child: root.subEmployeeNode) {
                double[] cur = helper(child);
                sum += cur[0];
                count += cur[1];
            }
        }
        double average = sum / count;
        if(count > 1 && average > max) {
            max = average;
            maxNode = root;
        }
        return new double[]{sum, count};
    }
    
    public static void main(String[] args) {
        // Input:
        //              20
        //            /   \
        //          12     18
        //       /  |  \   / \
        //     11   2   3 15  8
        // EmployeeNode left = new EmployeeNode(12);
        // left.subEmployeeNode = Arrays.asList(new EmployeeNode(11), new EmployeeNode(2), new EmployeeNode(3));

        // EmployeeNode right = new EmployeeNode(18);
        // right.subEmployeeNode = Arrays.asList(new EmployeeNode(15), new EmployeeNode(8));
        
        // EmployeeNode root = new EmployeeNode(20);
        // root.subEmployeeNode = Arrays.asList(left, right);


        EmployeeNode left = new EmployeeNode(12);
        left.subEmployeeNode.add(new EmployeeNode(11));
        left.subEmployeeNode.add(new EmployeeNode(2));
        left.subEmployeeNode.add(new EmployeeNode(3));

        EmployeeNode right = new EmployeeNode(18);
        right.subEmployeeNode.add(new EmployeeNode(15));
        right.subEmployeeNode.add(new EmployeeNode(8));
        
        EmployeeNode root = new EmployeeNode(20);
        root.subEmployeeNode.add(left);
        root.subEmployeeNode.add(right);

        test(root); // output: 18
    }
    
    private static void test(EmployeeNode root) {
        EmployeeNode maxNode = new BusiestNode().getBusiestNode(root);
        System.out.println("Max Average: " + maxNode.value);
    }
}