import java.util.*;
import java.io.*;
import java.lang.*;


OPT: 

public int cutOffRank(int cutOffRank, int num, int[] scores) {
    if(cutOffRank == 0) return 0;
    if(cutOffRank == num) return num;
    int[] cache = new int[101];
    for (int n : scores){
        cache[n]++;
    }
    int  res = 0;
    for (int i = 100; i >= 0; i--){
        if (cutOffRank <= 0) break;
        cutOffRank -= cache[i];
        res += cache[i];
    }    
    return res;
}


class Solution {
    public int cutOffRank(int cutOffRank, int num, int[] scores) {
        
        Arrays.sort(scores);
        int[] rank = new int[num];
        int countPlayer = 0;
        
        rank[num - 1] = 1;
        int sameScoreCount = 1;
        
        for (int i = num - 1; i > 0; -- i) {
            if (scores[i - 1] == scores[i]){
                rank[i - 1] = rank[i];
                sameScoreCount ++;
            } else {
                rank[i - 1] = rank[i] + sameScoreCount;
                sameScoreCount = 1;
            }
        }
        
        for (int r : rank) {
            // System.out.println(r);
            if (r <= cutOffRank) {
                countPlayer++;
            }
        }
        return countPlayer;
    }

    public static void main(String args[]) {
        Solution sol = new Solution();
        int[] scores = {100, 50, 50, 25};
        int ans = sol.cutOffRank(3, 4, scores);
        System.out.println(ans);
    }
}