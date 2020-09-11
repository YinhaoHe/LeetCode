class Solution {
    public int[][] kClosest(int[][] points, int K) {
        // edge case 
        if (points == null || points.length == 0 || K < 1) 
            return points;
        // 重写comparator实现最大堆
        PriorityQueue<int []> pq = new PriorityQueue<int []>((a, b) -> {
           return findDist(b) - findDist(a); 
        });
        // 把点放到pq里面去 一旦size大于k 就poll出来
        for (int[] point : points) {
            pq.add(point);
            if(pq.size() > K) {
                pq.poll();
            }
        }
        // 新建一个res数组用来存放k个点
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i ++) {
            res[i] = pq.poll();
        }
    
        return res;
    }
    
    public int findDist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}