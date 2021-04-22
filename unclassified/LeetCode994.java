class Solution {
    public int orangesRotting(int[][] grid) {
        
        int row = grid.length; // length of row
        int col = grid[0].length; // length of column
        Queue<int[]> queue = new LinkedList<>(); 
        
        // counter to count the fresh orange number
        int counter = 0;
        
        // count the number of fresh oranges
        // add coordinate of rotten oranges to queue
        
        for (int r = 0; r < row; r ++) {
            for (int c = 0; c < col; c ++) {
                if (grid[r][c] == 1) {
                    // count the fresh oranges
                    counter ++;
                } else if (grid[r][c] == 2) {
                    // add rotten orange coordinates 
                    queue.add(new int[] {r, c});
                }
            }
        }
        
        int round = 0; // record how many minutes to rot all oranges
        
        // stop the loop when no more fresh oranges AND queue is empty(no more rotten oranges)
       while (counter > 0 && !queue.isEmpty()) {
           
           // BFS depth plus 1
           round ++;
           // get how many rotten oranges at current depth in BFS
           int n = queue.size();
           
           for (int i = 0; i < n; i ++) {
               
               // take one rotten out of queue
               int orange[] = queue.poll();
               // store the coordinate of orange
               int r = orange[0];
               int c = orange[1];
               
               // rot the one above it
               if (r - 1 >= 0 && grid[r - 1][c] == 1) {
                   grid[r - 1][c] = 2;
                   // fresh orange mins 1
                   counter --;
                   // add it to queue
                   queue.offer(new int[]{r - 1, c}); 
               }
               
               // rot the one below it
               if (r + 1 < row && grid[r + 1][c] == 1) {
                   grid[r + 1][c] = 2;
                   // fresh -1
                   counter --;
                   // add to queue
                   queue.offer(new int[]{r + 1, c});
               }
               
               // rot the one to the left
               if (c - 1 >= 0 && grid[r][c - 1] == 1) {
                   grid[r][c - 1] = 2;
                   // fresh -1
                   counter --;
                   // add 
                   queue.offer(new int[]{r, c - 1});
               }
               
               // rot the one to the right
               if (c + 1 < col && grid[r][c + 1] == 1) {
                   grid[r][c + 1] = 2;
                   // fresh -1
                   counter --;
                   // add
                   queue.offer(new int[]{r, c + 1});
               }
           }
       }
        // if counter > 0 it means fresh orange left. so it fails
        if (counter > 0) {
            return -1;
        } else { 
            return round;
        }
    }
}









