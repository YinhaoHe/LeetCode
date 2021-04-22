class Solution {
    //DFS
    public void dfs(char[][] grid, int r, int c, int nr, int nc) {
        
        if(r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }
        
        grid[r][c] = '0';
        dfs (grid, r - 1, c, nr, nc);
        dfs (grid, r + 1, c, nr, nc);
        dfs (grid, r, c - 1, nr, nc);
        dfs (grid, r, c + 1, nr, nc);  
    }
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int nr = grid.length;
        int nc = grid[0].length;
        int num = 0;
        
        for (int r = 0; r < nr; r ++) {
            for (int c = 0; c < nc; c ++) {
                if (grid[r][c] == '1') {
                    num ++;
                    dfs (grid, r, c, nr, nc);
                }
            }
        }
        return num;
    }
}