class Solution {
    public int numTrees(int n) {
    
    /*
    G(n) 表示N个node的时候有多少个unique的BST
    F(i, n) 表示N个node的时候第i个数字作为root时 有多少个BST
    F(i, n) = G(i - 1) * G(n - i)
    
    G(n) = sigma i = 1 to N G(i - 1) * G(n - i)
    */ 
    
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        
        for (int i = 2; i <= n; i ++) { //依次循环有1，2，3 到n个node 的有几个树
            for (int j = 1; j <= i; j++) { //依次循环1到i个node里 依次作为root有几个树
                G[i] += G[j - 1] * G[i - j]; // 结果依次累加起来 最终只维护一个一位数组
            }
        }
        return G[n];
    }
}