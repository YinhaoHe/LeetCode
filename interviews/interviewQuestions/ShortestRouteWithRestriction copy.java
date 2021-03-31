/*
You decided to run every night when you see your roomate is more charming than you because he/she works out regularly.
Now you have a dictionary of places in Beijing. It's in the form of {location: elevation}. 
And an array of distances you find on Baidu Map connecting each places. 
Please find the length of the shortest route on which you can run completely uphill then completely downhill. 
Assume you live in "Huilongguan".
elevations = {"Huilongguan": 5, "Chaoyang Park": 25, "National Stadium": 15, "Olympic Park": 20, "Tsinghua University": 10}
paths = {
    ("Huilongguan", "Chaoyang Park"): 10,
    ("Huilongguan", "National Stadium"): 8,
    ("Huilongguan", "Olympic Park"): 15,
    ("Chaoyang Park", "Olympic Park"): 12,
    ("National Stadium", "Tsinghua University"): 10,
    ("Olympic Park", "Tsinghua University"): 5,
    ("Olympic Park", "Huilongguan"): 17,
    ("Tsinghua University", "Huilongguan"): 10
}
For this set of data, the shortest valid path would be 
"Huilongguan" -> "National Stadium" -> "Tsinghua University" -> "Huilongguan", with a distance of 28.
*/


import java.util.*;
public class ShortestRouteWithRestriction {
    public static int shortestRouteWithRestriction(int[] elevations, int[][] paths) {
        int n = elevations.length;
        int[] rising = new int[n];
        int[] falling = new int[n];
        Arrays.fill(rising, Integer.MAX_VALUE);
        Arrays.fill(falling, Integer.MAX_VALUE);

        Map<Integer, List<int[]>> risingGraph = new HashMap<>();
        Map<Integer, List<int[]>> fallingGraph = new HashMap<>();
        for(int i = 0; i < n; i++) {
            risingGraph.put(i, new ArrayList<>());
            fallingGraph.put(i, new ArrayList<>());
        }

        // 构建上升图/下降图
        for(int i = 0; i < paths.length; i++) {
            if (elevations[paths[i][0]] < elevations[paths[i][1]]) {
                risingGraph.get(paths[i][0]).add(new int[]{paths[i][1], paths[i][2]});
            }else if (elevations[paths[i][0]] > elevations[paths[i][1]]) {
                fallingGraph.get(paths[i][1]).add(new int[]{paths[i][0], paths[i][2]});
            }
        }
        // 原点到各点上升最短距离
        dijkstra(risingGraph, rising, 0);
        // 原点到各点下降最短距离
        dijkstra(fallingGraph, falling, 0);

        int res = Integer.MAX_VALUE;
        // 遍历所有点找到转折点
        for(int i = 1; i < n; i++) {
            if(rising[i] < Integer.MAX_VALUE && falling[i] < Integer.MAX_VALUE) {
                res = Math.min(res, rising[i] + falling[i]);
            }
        }
        return res;
    }
    private static void dijkstra(Map<Integer, List<int[]>> g, int[] distance, int startNode) {
        boolean[] processed = new boolean[distance.length];
        distance[startNode] = 0;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a1, a2) -> {return a1[0] - a2[0];});
        minHeap.add(new int[]{0, startNode});
        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int currNodeDistance = curr[0];
            int currNodeLabel = curr[1];
            if(processed[currNodeLabel]) {
                continue;
            }
            processed[currNodeLabel] = true;
            for(int[] edge : g.get(currNodeLabel)) {
                int neighbor = edge[0];
                int weight = edge[1];
                if(currNodeDistance + weight < distance[neighbor]) {
                    distance[neighbor] = currNodeDistance + weight;
                    minHeap.add(new int[]{distance[neighbor], neighbor});
                }
            }
        }
    }
    public static void main(String[] args) {
        // 抽象题意，"Huilongguan": 0, "Chaoyang Park": 1, "National Stadium": 2, "Olympic Park": 3, "Tsinghua University": 4
        int[] elevations = {5,25,15,20,10};
        int[][] paths = {{0, 1, 10}, {0, 2, 8}, {0, 3, 15}, {1, 3, 12}, {2, 4, 10}, {3, 4, 5}, {3, 0, 17}, {4, 0, 10}};
        System.out.println(shortestRouteWithRestriction(elevations, paths));
    }
}