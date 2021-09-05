import java.util.*;

class Solution {
    public int shortestDistace(int n, int[] xPos, int[] yPos) {
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int distance = ((xPos[j] - xPos[i]) * (xPos[j] - xPos[i]))
                        + ((yPos[j] - yPos[i]) * (yPos[j] - yPos[i]));
                if (distance > 0)
                    // Not considering robos at same point
                    minDistance = Math.min(minDistance, distance);
            }
        }
        return minDistance;
    }

    public static void main(String args[]) {
        Solution sol = new Solution();
        int x[] = { 0, 1, 0 };
        int y[] = { 0, 3, 0 };
        System.out.println(sol.shortestDistace(2, x, y));
    }
}