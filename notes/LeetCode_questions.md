# LeetCode questions

## 2020.08.25

### 1192 Critical connection

#### My solutions

- [My solution 1](../Amazon/1192_critical_connection.java)

- [**My solution 2 best!**](../Amazon/1192_tarjan_dfs_critical_connection.java)

- [My solution 3 **My idea**](../Amazon/1192_critical_connection_solution3.java)

#### Online solutions

- [blog **best solution**](https://leetcode.jp/leetcode-1192-critical-connections-in-a-network-%E8%A7%A3%E9%A2%98%E6%80%9D%E8%B7%AF%E5%88%86%E6%9E%90/)

- [YouTube solution1](https://www.youtube.com/watch?v=kYcUIEQqL2Y)

- [YouTube solution2](https://www.youtube.com/watch?v=mKUsbABiwBI)

- [Tarjan algorithm](https://www.cnblogs.com/nullzx/p/7968110.html)

#### Steps

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

## 2020.09.02

### 957 Prison Cells After N Days 找规律

感觉没啥意义

#### [My solution](../Amazon/957_findPattern_prisonCellsAfterNDays.java) 

- 记录下每一步的state 
- 找到规律 例如：经过多少天就会形成 repetitive state
- 用给定step N mod C (我们找到的规律)
- N 对 C 取余数后找到对应state就是答案

#### Online solution

- [解法大全](https://massivealgorithms.blogspot.com/2019/01/leetcode-957-prison-cells-after-n-days.html)

### 973 K Closest Points to Origin 

#### My solutions

- [sorting](../Amazon/973_sorting_KClosestPointsToOrigin.java)
  - 计算所有点到原点距离
  - 排序
  - 根据排序找到前k个点

- [max Heap](../Amazon/973_maxHeap_KClosestPointsToOrigin.java) ([优先队列](https://www.liaoxuefeng.com/wiki/1252599548343744/1265120632401152))
  - 求距离最近的k个值
  - 建立一个k + 1 大小的heap 然后按照距离倒序排列 形成一个max heap
  - 每次遇到一个点就放入heap 如果大于k了就弹出一个 也就是弹出距离最远的 最后剩下的就是距离最近的k个点

#### Online solutions

- [max Heap 1](http://www.noteanddata.com/leetcode-973-K-Closest-Points-to-Origin-java-solution-note.html)
- [max Heap 2](https://www.cnblogs.com/Dylan-Java-NYC/p/10556223.html)



