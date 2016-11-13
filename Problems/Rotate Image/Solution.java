public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @return: Void
     */
    public void rotate(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return ;
        }
        int n = matrix.length;
        int offset = 0;
        int upRow, downRow, leftCol, rightCol;
        while (offset <= n / 2) {
            upRow = offset;
            downRow = n - 1 - offset;
            leftCol = offset;
            rightCol = n - 1 - offset;
            for (int i = 0; i < n - 2 * offset - 1; i++) {
                int tmp = matrix[upRow][i + leftCol];
                matrix[upRow][i + leftCol] = matrix[downRow - i][leftCol];
                matrix[downRow - i][leftCol] = matrix[downRow][rightCol - i];
                matrix[downRow][rightCol - i] = matrix[upRow + i][rightCol];
                matrix[upRow + i][rightCol] = tmp;
                
            }
            offset++;
        }
        return;
    }
}