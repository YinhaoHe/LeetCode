class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int minCost = 0;
        for (int stick: sticks) {
            pq.add(stick);
        }
        
        while(pq.size() > 1) {
            int s1 = pq.poll();
            int s2 = pq.poll();
            int cost = s1 + s2;
            pq.add(cost);
            minCost += cost;
        }
        return minCost;
    }
}