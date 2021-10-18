// Java 8 and above will be able to run this file
// Input: (x, y) of each positions
// Output: all shortest path 
// Output: distance of the path.

// Intro: As discussed in the lecture, in order to make sure I traversal all the paths, I used DFS and backtracking, so this program can find all shortest paths. 

import java.util.*;

public class Main {
    
    // To store the final shortest path results
    private static final List<List<Integer>> resultPath = new ArrayList<>();
    
    // According to each point, generate a 2D matrix to show the distance between each node
    private static int[][] getDistanceMatrix(int[][] points) {
        List<List<Integer>> results = new ArrayList<>();
        for (int[] start : points) {
            List<Integer> temp = new ArrayList<>();
            for (int[] point : points) {
                int distance = Math.abs(start[0] - point[0]) + Math.abs(start[1] - point[1]);
                temp.add(distance);                
            }
            results.add(temp);
        }
        int[][] ans = new int[points.length][points.length];
        for (int i = 0; i < points.length; ++ i) {
            for (int j = 0; j < points.length; ++ j) {
                ans[i][j] = results.get(i).get(j);
            }
        }
        return ans;
    }
    
    // Map the results to the letter paths to display
    private static List<String> generatePath(List<List<Integer>> resultPath) {
        
        // To make the program simple, I map index to each color of node
        // For our case: 
        // 0 map to W
        // 1 map to Y 
        // 2 map to M
        // 3 map to B
        // 4 map to C
        // 5 map to R
        HashMap<Integer, Character> map = new HashMap<>();
        map.put(0, 'W');
        map.put(1, 'Y');
        map.put(2, 'M');
        map.put(3, 'B');
        map.put(4, 'C');
        map.put(5, 'R');
        
        List<String> results = new ArrayList<>();
        for (List<Integer> path : resultPath) {
            StringBuilder sb = new StringBuilder();
            sb.append("W -> ");
            for (Integer num : path) {
                sb.append(map.get(num));
                sb.append(" -> ");
            }
            sb.append("W");
            results.add(sb.toString());
        }
        return results;
    }
    
	public static int findShortest(int[][] graph, boolean[] visited, int currPos, int numberOfNode, int count, int cost, int ans, List<Integer> currentPath) {
            
		if (count == numberOfNode && graph[currPos][0] > 0) {
            int lastDistance = cost + graph[currPos][0];
			ans = Math.min(ans, lastDistance);
            // Only add the path that reach back to the starting point "W"
            if (ans == lastDistance) {
                resultPath.add(new ArrayList(currentPath));
            }
			return ans;
		}
 
		/*
		 * Backtracking steps:
		 * loop all edges connected to the currPos，and count++，
         * update cost to cost + graph[currPos][0]
		 */
 
		for (int i = 0; i < numberOfNode; i++) {
			if (visited[i] == false && graph[currPos][i] > 0) {
 
				// Mark this node has been visited
				visited[i] = true;
                currentPath.add(i);
				ans = findShortest(graph, visited, i, numberOfNode, count + 1, cost + graph[currPos][i], ans, currentPath);
                // Backtrack 
                currentPath.remove(currentPath.size() - 1);
				visited[i] = false;
			}
		}
		return ans;
	}
    
    public static void main(String[] args) {      
        int[][] points = {
            {0, 0},
            {3, 0},
            {5, 1},
            {4, 4},
            {5, 6},
            {2, 6}
        };
        // number of nodes in the graph
		int numberOfNode = points.length;
 
		// use to mark if this node has been visited
		boolean[] visited = new boolean[numberOfNode];
 
		// mark the first one as visited
		visited[0] = true;
		int ans = Integer.MAX_VALUE;
 
		// Find the routes with lowest cost
		ans = findShortest(getDistanceMatrix(points), visited, 0, numberOfNode, 1, 0, ans, new ArrayList<Integer>());
		System.out.println("The distance of the shortest path is " + ans);
        for (String s : generatePath(resultPath))
            System.out.println(s);
    }
}