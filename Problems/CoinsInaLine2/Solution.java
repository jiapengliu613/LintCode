public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
     //Idea : http://www.mamicode.com/info-detail-1114851.html
    public boolean firstWillWin(int[] values) {
        // write your code here
        if (values == null || values.length == 0) {
            return false;
        }
        if (values.length <= 2) {
            return true;
        }
        int n = values.length;
        int[] dp = new int[n + 1];
        
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum  += values[i];
        }
        dp[n - 1] = values[n - 1];
        dp[n - 2] = values[n - 1] + values[n - 2];
        dp[n - 3] = values[n - 3] + values[n - 2];
        for (int i = n - 4; i >= 0; i--) {
            dp[i] = values[i] + Math.min(dp[i + 2], dp[i + 3]);
            dp[i] = Math.max(dp[i], values[i] + values[i + 1] + Math.min(dp[i + 3], dp[i + 4])); 
        }
        return dp[0] > sum / 2;
    }
}
