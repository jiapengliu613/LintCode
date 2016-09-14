public class Solution {
    /**
     * @param nums a list of integer
     * @return an integer, maximum coins
     */
     // Pay attention to the state trasition equation, where midValue is array[left - 1] * array[i] * array[right + 1] instead of 
     // array[i - 1] * array[i] * array[i + 1], because i is the last balloon to burst
    public int maxCoins(int[] nums) {
        // Write your code here
        if (nums ==null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[][] dp = new int[n + 2][n + 2];
        int[] array = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            array[i] = nums[i - 1];
        }
        array[0] = 1;
        array[n + 1] = 1;
        return helper(1, n, dp, array);
    }
    int helper(int left, int right, int[][] dp, int[] array) {
        if (dp[left][right] != 0) {
            return dp[left][right];
        }
        if (left > right) {
            dp[left][right] = 0;
        } else {
            for (int i = left; i <= right; i++) {
                int midValue = array[left - 1] * array[i] * array[right + 1];
                int leftValue = helper(left, i - 1, dp, array);
                int rightValue = helper(i + 1, right, dp, array);
                dp[left][right] = Math.max(dp[left][right], leftValue + rightValue + midValue);
            }
        }
        return dp[left][right];
    }
}
