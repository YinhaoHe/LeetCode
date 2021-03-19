public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param target: An integer you want to search in matrix
     * @return: An integer indicate the total occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        int row = matrix.length - 1;
        int col = 0;
        int count = 0;

        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                row --;
            } else if (matrix[row][col] < target) {
                col ++;
            } else {
                count ++;
                row --;
                col ++;
            }
        }
        return count;
    }
}