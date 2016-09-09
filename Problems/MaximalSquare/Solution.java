public class Solution {
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
     //Idea : the maximal square at (i, j) is decided by the minimal of its left, leftup ,up square. Further optimization can be 
     //achieved using rolling array
    public int maxSquare(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int result = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 1) {
                dp[i][0] = 1;
                result = Math.max(result, dp[i][0] * dp[i][0]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 1) {
                dp[0][i] = 1;
                result = Math.max(result, dp[0][i] * dp[0][i]);
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
                result = Math.max(result, dp[i][j] * dp[i][j]);
            }
        }
        return result;
    }
}

//Rolling Array Solution, O(n) space
public class Solution {
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maxSquare(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int result = 0;
        int[][] dp = new int[2][n];
        
        for (int i = 0; i < m; i++) {
            dp[i % 2][0] = matrix[i][0];
            result = Math.max(result, dp[i % 2][0] * dp[i % 2][0]);
            for (int j = 1; j < n; j++) {
                if (i > 0) {
                    if (matrix[i][j] == 0) {
                        dp[i % 2][j] = 0;
                    } else {
                        dp[i % 2][j] = Math.min(dp[(i - 1) % 2][j - 1], 
                                       Math.min(dp[i % 2][j - 1], dp[(i - 1) % 2][j])) + 1;
                    }
                } else {
                    dp[i % 2][j] = matrix[0][j];
                }
                result = Math.max(result, dp[i % 2][j] * dp[i % 2][j]);
            }
        }
        return result;
    }
}
