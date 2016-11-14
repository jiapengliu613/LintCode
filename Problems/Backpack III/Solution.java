public class Solution {
    /**
     * @param A an integer array
     * @param V an integer array
     * @param m an integer
     * @return an array
     */
    public int backPackIII(int[] A, int[] V, int m) {
        // Write your code here
        if (m == 0 || A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        
        int[][] dp = new int[2][m + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j >= A[i - 1]) {
                    dp[i % 2][j] = Math.max(dp[(i - 1) % 2][j], 
                                            dp[i % 2][j - A[i - 1]] + V[i - 1]);
                } else {
                    dp[i % 2][j] = dp[(i - 1) % 2][j];
                }
            }
        }
        return dp[n % 2][m];
    }
}