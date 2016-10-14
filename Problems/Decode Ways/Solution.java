public class Solution {
    /**
     * @param s a string,  encoded message
     * @return an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        if(s.charAt(0) >= '1' && s.charAt(0) <= '9') {
            dp[1] = 1;
        } else {
            return 0;
        }
        for (int i = 2; i <= n; i++) {
            if (s.charAt(i - 1) == '0') {
                if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2') {
                    dp[i] = dp[i - 2];
                    continue;
                } else {
                    return 0;
                }
            }
            dp[i] = dp[i - 1];
            int twoDigit = s.charAt(i - 1) - '0' + (s.charAt(i - 2) - '0') * 10;
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}