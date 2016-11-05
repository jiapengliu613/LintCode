public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = nums[0];
        int result = dp[1];
        
        for (int i = 2; i <= n; i++) {
            if (dp[(i - 1) % 2] <= 0) {
                dp[i % 2] = nums[(i - 1)];
            } else {
                dp[i % 2] = dp[(i - 1) % 2] + nums[(i - 1)];
            }
            result = Math.max(result, dp[i % 2]);
        }
        return result;
    }
}

//O(1) space
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int globalMax = Integer.MIN_VALUE;
        int currentMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                currentMax = currentMax + nums[i] > 0 ? currentMax + nums[i] : 0;
                if (globalMax < nums[i]) {
                    globalMax = nums[i];
                }
            } else {
                currentMax += nums[i];
                globalMax = Math.max(globalMax, currentMax);
            }
        }
        return globalMax;
    }
}