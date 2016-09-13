public class Solution {
    /**
     * @param A an integer array
     * @return an integer
     */
    public int stoneGame(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int[][] dp = new int[n][n];
        int[][] sum = new int[n][n];
        for (int i = 0; i < n; i++) {
            sum[i][i] = A[i];
            for (int j = i + 1; j < n; j++) {
                sum[i][j] = sum[i][j - 1] + A[j];
            }
        }
        dp[0][n - 1] = helper(0, n - 1, dp, sum);
        return dp[0][n - 1];
    }
    int helper(int left, int right, int[][] dp, int[][] sum) {
        if (dp[left][right] != 0) {
            return dp[left][right];
        }
        if (left == right) {
            dp[left][right] = 0;
        } else if (left + 1 == right) {
            dp[left][right] = sum[left][right];
        } else if (left > right) {
            return 0;
        } else {
            dp[left][right] = Integer.MAX_VALUE;
            for (int i = left; i < right; i++) {
                dp[left][right] = Math.min(dp[left][right], helper(left, i, dp, sum) + 
                                        helper(i + 1, right, dp, sum) + sum[left][right]);
            }
        }
        return dp[left][right];
    }
}