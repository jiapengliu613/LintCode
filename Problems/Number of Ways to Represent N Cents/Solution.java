public class Solution {
    /**
     * @param n an integer
     * @return an integer
     */
     int[] coins = {25, 10, 5, 1};
    public int waysNCents(int n) {
        // Write your code here
        if (n == 0) {
            return 1;
        }
        int[] result = new int[1];
      
        helper(result, n, 0);
        return result[0];
    }
    private void helper(int[] result, int left, int level) {
        if (level == 3) {
            result[0]++;
            return;
        }
        for (int i = 0; i * coins[level] <= left; i++) {
            helper(result, left - i * coins[level], level + 1);
        }
    }
}
// dp solution
public class Solution {
    /**
     * @param n an integer
     * @return an integer
     */
    public int waysNCents(int n) {
        // Write your code here
        if (n == 0) {
            return 1;
        }
        int[] dp = new int[n + 1];
        int[] coins = {1, 5, 10, 25};
        dp[0] = 1;
        for (int i = 0; i <= 3; i++) {
            for (int j = 1; j <= n; j++) {
                if (j >= coins[i]) {
                    dp[j] += dp[j - coins[i]]; 
                }
            }
        }
        return dp[n];
    }
}
