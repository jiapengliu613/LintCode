public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        // write your code here
        if (m == 0 || A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int result = 0;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j >= A[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - A[i - 1]] + V[i - 1]);
                    result = Math.max(result, dp[i][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return result;
    }
}
// Rolling array to optimize space
public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        // write your code here
        if (m == 0 || A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        
        int[][] dp = new int[2][m + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j >= A[i - 1]) {
                    dp[i % 2][j] = Math.max(dp[(i - 1) % 2][j], 
                                            dp[(i - 1) % 2][j - A[i - 1]] + V[i - 1]);
                } else {
                    dp[i % 2][j] = dp[(i - 1) % 2][j];
                }
            }
        }
        return dp[n % 2][m];
    }
}
