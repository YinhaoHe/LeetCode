class Solution {
    // 用于存放result
    List<List<Integer>> res = new ArrayList<>();
    // 用于存储深度的数组
    int depthArray[];
    // 用邻接表 建立图
    List<Integer>[] graph;
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // 初始化深度数组 为-1
        depthArray = new int[n];
        Arrays.fill(depthArray, -1);
        // 建图
        graph = new ArrayList[n];
        buildGraph(graph, connections);
        // 做dfs
        dfs(0, -1, 0);
        // 返回结果
        return res;
    }
    
    // 定义dfs
    private int dfs(int node, int parent, int depth) {
        depthArray[node] = depth + 1;
        for (int child : graph[node]) {
            if (child == parent) {
                continue;
            } else if (depthArray[child] == -1) {
                depthArray[node] = Math.min(depthArray[node], dfs(child, node, depth + 1));
            } else {
                depthArray[node] = Math.min(depthArray[node], depthArray[child]);
            }
        }
        if (depthArray[node] == depth + 1 && node != 0) {
            List<Integer> list = new ArrayList<>();
            list.add(parent);
            list.add(node);
            res.add(list);
        }
        return depthArray[node];
    }
    
    // 建立图 函数定义 注意是无向图 所以双向都要加进去
    private void buildGraph(List<Integer>[] graph, List<List<Integer>> connections) {
        for (List<Integer> connection : connections) {
            int a = connection.get(0);
            int b = connection.get(1);
            
            if (graph[a] == null) {
                graph[a] = new ArrayList<>();
            }
            
            if (graph[b] == null) {
                graph[b] = new ArrayList<>();
            }
            
            graph[a].add(b);
            graph[b].add(a);
        }
    }
}