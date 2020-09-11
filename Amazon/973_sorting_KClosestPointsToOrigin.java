class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int len = points.length;
        int[] dists = new int[len];
        for (int i = 0; i < len; i ++) {
            dists[i] = findDist(points[i]);
        }
        
        Arrays.sort(dists);
        int distK = dists[K - 1];
        
        int[][] ans = new int[K][2];
        int tmp = 0;
        for (int i = 0; i < len; i ++) {
            if (findDist(points[i]) <= distK) {
                ans[tmp] = points[i];
                tmp ++;
            }
        }
        return ans;
    }
    
    public int findDist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}