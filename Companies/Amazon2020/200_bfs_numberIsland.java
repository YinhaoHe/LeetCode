class Solution {

    private void bfs(char[][] grid, Queue<int[]> que) {
        int nr = grid.length;
        int nc = grid[0].length;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // right, left, down, up
        
        while (!que.isEmpty()) {
            int[] curr = que.poll();
            
            for(int[] dir: dirs) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];
                
                if(x < 0 || x >= nr || y < 0 || y >= nc || grid[x][y] != '1') {
                    continue;
                } else {
                    grid[x][y] = '0';
                    que.offer(new int[]{x, y});
                }
            }
        }
    }
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        
        for (int r = 0; r < nr; r ++) {
            for (int c = 0; c < nc; c ++) {
                if (grid[r][c] == '1') {
                    Queue<int[]> que = new LinkedList<>();
                    num_islands ++;
                    que.offer(new int[]{r, c});
                    bfs(grid, que);
                }
            }
        }
        return num_islands;
    }
}