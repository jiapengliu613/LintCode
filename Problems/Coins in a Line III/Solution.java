public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        if (values == null || values.length == 0) {
            return false;
        }
        int n = values.length;
        int[][] sum = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                sum[i][j] = i == j ? values[i] : sum[i][j - 1] + values[j];
            }
        }
        int[][] dp = new int[n][n];
        dp[0][n - 1] = helper(0, n - 1, dp, sum, values);
        return dp[0][n - 1] > sum[0][n - 1] / 2;
    }
    int helper(int left, int right, int[][] dp, int[][] sum, int[] values) {
        if (dp[left][right] != 0) {
            return dp[left][right];
        }
        if (left == right) {
            dp[left][right] = values[left];
        } else if (left > right) {
            dp[left][right] = 0;
        } else if (left + 1 == right) {
            dp[left][right] = Math.max(values[left], values[right]);
        } else {
            dp[left][right] = sum[left][right] - Math.min(helper(left, right - 1, dp, sum, values),
                                                         helper(left + 1, right, dp, sum, values));
        }
        return dp[left][right];
    }
}