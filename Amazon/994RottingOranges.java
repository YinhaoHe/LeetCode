class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return -1;
        
        Queue<int[]> queue = new LinkedList<>();
        int freshOrange = 0;
        int row = grid.length;
        int col = grid[0].length;
        
        for (int r = 0; r < row; ++ r) {
            for (int c = 0; c < col; ++ c) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                    // queue.offer(new Pair<Integer, Integer>(r, c));
                } else if (grid[r][c] == 1) {
                    freshOrange ++;
                }
            }
        }
        
        if (freshOrange == 0) return 0;
        int min = 0;
        int dirs[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // u d l r
        
        while (!queue.isEmpty()) {
            // BFS depth ++
            min ++;
            int len = queue.size();
            for (int i = 0; i < len; ++ i) {
                int curr[] = queue.poll();
                for (int dir[] : dirs) {
                    int x = dir[0] + curr[0];
                    int y = dir[1] + curr[1];
                    
                    if (x < 0 || x >= row || y < 0 || y >= col || grid[x][y] == 2 || grid[x][y] == 0) {
                        continue;
                    }
                    grid[x][y] = 2;
                    queue.offer(new int[]{x, y});
                    freshOrange --;
                }
            }
        }
        return freshOrange == 0 ? min - 1 : -1;
    }
}