public class Solution {
    /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
     /* O(n) space
    public long houseRobber(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        long[] dp = new long[A.length + 1];
        dp[0] = 0;
        dp[1] = A[0];
        for (int i = 2; i <= A.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + A[i - 1]);
        }
        return dp[A.length];
    }
}
/* Since state dp[i] is only related to dp[i - 1] and dp[i - 2], so the length of dp array can be reduced to 2, so it's O(1) space */
public class Solution {
    /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        long[] dp = new long[2];
        dp[0] = 0;
        dp[1] = A[0];
        for (int i = 2; i <= A.length; i++) {
            dp[i % 2] = Math.max(dp[(i - 1) % 2], dp[(i - 2) % 2] + A[i - 1]);
        }
        return dp[A.length % 2];
    }
}
