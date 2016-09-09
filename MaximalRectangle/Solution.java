public class Solution {
    /**
     * @param matrix a boolean 2D matrix
     * @return an integer
     */
    public int maximalRectangle(boolean[][] matrix) {
        // Write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result = Math.max(result, findMax(matrix, i, j));
            }
        }
        return result;
    }
    int findMax(boolean[][] matrix, int row, int column) {
        int result = 0;
        int minWidth = Integer.MAX_VALUE;
        for (int i = row; i < matrix.length && matrix[i][column] == true; i++) {
            int curWidth = 0;
            while (column + curWidth < matrix[0].length && matrix[i][column + curWidth] == true) {
                curWidth++;
            }
            minWidth = Math.min(minWidth, curWidth);
            result = Math.max(result, (i - row + 1) * minWidth);
        }
        return result;
    }
}