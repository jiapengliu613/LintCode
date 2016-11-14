public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        if (m == 0 || A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        boolean[][] dp = new boolean[2][m + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i % 2][j] = dp[(i - 1) % 2][j] || (j >= A[i - 1] && dp[(i - 1) % 2][j - A[i - 1]]);
            }
        }
        for (int i = m; i >= 0; i--) {
            if (dp[n % 2][i]) {
                return i;
            }
        }
        return 0;
        
    }
}

// another solution
public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        if (m == 0 || A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1];
                if (i >= A[j - 1]) {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - A[j - 1]][j - 1] + A[j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}