public class Solution {
    /**
     * @param A an integer matrix
     * @return  an integer
     */
     int[][] dp;
     int[][] flag;
    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        // Write your code here
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }
        int m = A.length, n = A[0].length;
        int result = 0;
        dp = new int[m][n];
        flag = new int[m][n];
        for (int i = 0; i < A.length; i++) {
            for (int j =0; j < A[0].length; j++) {
                dp[i][j] = helper(A, i, j);
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    public int helper(int[][] A, int row, int col) {
        if (flag[row][col] != 0) {
            return dp[row][col];
        }
        int result = 1;
        for (int i = 0; i < 4; i++) {
            int newX = row + dx[i];
            int newY = col + dy[i];
            if (newX >= 0 && newX < A.length && newY >= 0 && newY < A[0].length
             && A[newX][newY] < A[row][col]) {
                result = Math.max(result, helper(A, newX, newY) + 1);
            }
        }
        flag[row][col] = 1;
        return result;
    }
    
}