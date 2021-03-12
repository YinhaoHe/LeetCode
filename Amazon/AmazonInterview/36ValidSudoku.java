class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Integer> [] rows = new HashSet[9];
        HashSet<Integer> [] cols = new HashSet[9];
        HashSet<Integer> [] boxes = new HashSet[9];
        for (int i = 0; i < 9; ++ i) {
            rows[i] = new HashSet<Integer>();
            cols[i] = new HashSet<Integer>();
            boxes[i] = new HashSet<Integer>();
        }
        
        for (int i = 0; i < 9; ++ i) {
            for (int j = 0; j < 9; ++ j) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int)num;
                    int boxIdx = (i / 3) * 3 + j / 3;
                    
                    if ( (!rows[i].add(n)) || (!cols[j].add(n)) || (!boxes[boxIdx].add(n)) ) return false;
                }
            }
        }
        return true;
    }
}