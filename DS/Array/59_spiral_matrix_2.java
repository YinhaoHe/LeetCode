class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int left = 0, top = 0;
        int right = n - 1, down = n - 1;
        int count = 1;
        
        while (left <= right) {
            for (int i = left; i <= right; ++ i) {
                res[top][i] = count ++;
            }
            top ++;
            for (int j = top; j <= down; ++ j) {
                res[j][right] = count ++;
            }
            right --;
            for (int i = right; i >= left; -- i) {
                res[down][i] = count ++;
            }
            down --;
            for (int j = down; j >= top; -- j) {
                res[j][left] = count ++;
            }
            left ++;
        }
        
        return res;
    }
}