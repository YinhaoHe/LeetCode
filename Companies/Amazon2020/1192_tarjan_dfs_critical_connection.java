class Solution {
    List<List<Integer>> res = new ArrayList<>(); // the result
    int depthArray[]; // depth array
    ArrayList<Integer>[] map; // representing graph
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        depthArray = new int[n]; // initialize depth array
        Arrays.fill(depthArray, -1); // depth set to -1
        map = new ArrayList[n]; // initialize graph: map[i] represents the node that node[i] can connect to
        for (int i = 0; i < n; i ++) {
            map[i] = new ArrayList<>();
        }
        // build graph
        for (List<Integer> connection : connections) {
            map[connection.get(0)].add(connection.get(1));
            map[connection.get(1)].add(connection.get(0));
        }
        dfs(0, 0, 0); // begin dfs
        return res;
    }
    // current node
    // previous node
    // depth 
    // 返回值为当前节点的所有dfs路径的终点的最小深度
    private int dfs(int current, int previous, int depth) {
        depthArray[current] = depth; // put depth into depth array
        int result = Integer.MAX_VALUE; // return
        for (int child : map[current]) { // travesal all nodes connected to the current node
            if (child == previous) { // go one way down, not turning back
                continue;
            }
            int endDeep; // dps find depth
            if (depthArray[child] == -1) { // depth == -1 means not visited, do dfs
                endDeep = dfs(child, current, depth+1);
                // 如果深度大于当前深度，说明当前点不在闭环上
                // 且当前node与下一个节点i之间的连线为答案之一
                if (endDeep > depth) {
                    List<Integer> list = new ArrayList<>();
                    list.add(current);
                    list.add(child);
                    res.add(list);
                }
            } else {
                // i节点深度不为 -1，说明已经走过，i节点为dfs终点
                endDeep = depthArray[child];
            }
            // Update min depth
            result = Math.min(result, endDeep);  
        }
        return result; // return min depth
    }      
}