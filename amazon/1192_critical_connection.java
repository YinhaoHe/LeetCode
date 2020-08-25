class Solution {
    int time = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer>[] graph = new List[n];
        buildGraph(graph, connections);
        
        int[] disc = new int[n];
        int[] low = new int[n];
        int[] parents = new int[n];
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        Arrays.fill(parents, -1);
        
        for (int i = 0; i < n; i ++) {
            if (disc[i] == -1) {
                dfs(i, parents, low, disc, res, graph);
            }
        }
        
        return res;
    }
    
    private void dfs(int u, int[] parents, int[] low, int[] disc, List<List<Integer>> res, List<Integer>[] graph) {
        if (disc[u] != -1) return;
        
        low[u] = disc[u] = time ++;
        for (int v : graph[u]) {
            if (disc[v] == -1) {
                parents[v] = u;
                dfs(v, parents, low, disc, res, graph);
                
                if(low[v] > disc[u]) {
                    res.add(Arrays.asList(u, v));
                }
                
                low[u] = Math.min(low[u], low[v]);
            } else if (parents[u] != v) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    } 
    
    private void buildGraph(List<Integer>[] graph, List<List<Integer>> connections) {
        for (List<Integer> c : connections) {
            int a = c.get(0);
            int b = c.get(1);
            if (graph[a] == null) {
                graph[a] = new ArrayList<>();
            }
            
            if(graph[b] == null) {
                graph[b] = new ArrayList<>();
            }
            
            graph[a].add(b);
            graph[b].add(a);
        }
    }
}