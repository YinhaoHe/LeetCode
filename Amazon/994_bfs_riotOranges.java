class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int fresh_oranges = 0;
        Queue<int[]> que = new LinkedList<>();
        // count fresh
        // put riot oranges in queue
        
        for (int r = 0; r < nr; r ++) {
            for (int c = 0; c < nc; c ++) {
                if (grid[r][c] == 2) {
                    que.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    fresh_oranges ++;
                }
            } 
        }
        
        if (fresh_oranges == 0) return 0;
        int dirs[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // right, left, down, up
        int mins = 0;
        
        while(!que.isEmpty()) {
            ++ mins;
            int len = que.size();
            for (int i = 0; i < len; i ++){
                int curr[] = que.poll();

                for(int dir[]: dirs) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];

                    if (x < 0 || x >= nr || y < 0 || y >= nc || grid[x][y] == 2 || grid[x][y] == 0){
                        continue;
                    } 
                    grid[x][y] = 2;
                    que.offer(new int[]{x, y});
                    fresh_oranges --;
                }
            }
        }
         
        return fresh_oranges == 0 ? mins - 1 : -1;
    }
}