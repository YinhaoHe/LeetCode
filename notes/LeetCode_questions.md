# LeetCode questions

## 2020.08.25

### 1192 Critical connection

[My solution 1](../Amazon/1192_critical_connection.java)

[My solution 2](../Amazon/1192_tarjan_dfs_critical_connection.java)

[blog](https://leetcode.jp/leetcode-1192-critical-connections-in-a-network-%E8%A7%A3%E9%A2%98%E6%80%9D%E8%B7%AF%E5%88%86%E6%9E%90/)

[YouTube solution1](https://www.youtube.com/watch?v=kYcUIEQqL2Y)

[YouTube solution2](https://www.youtube.com/watch?v=mKUsbABiwBI)

[Tarjan algorithm](https://www.cnblogs.com/nullzx/p/7968110.html)

- 用临接表 adjancy list
  - List<Integer>[] graph
- Iterate all vertexs 
  - Try to do dfs()
  - Three variables:
    - int[] discoverTime
    - int[] parent
    - int[] lowestVertexInSubtree 
  - for unvisited node u
    - low[u] = disc[u] = time
    - for (neighbors of u) => v
    - if(v is not visited)
    - parent[v] = u
    - 递归调用，对v做dfs
    - 更新low[u] = min(low[u], low[v])
    - if(low[v] > disc[u]) -> edge(u, v) is critical connection

![1192. Critical Connections in a Network](./imgs/1192. Critical Connections in a Network.png)

