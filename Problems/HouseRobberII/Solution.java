public class Solution {
    /**
     * @param nums: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
     /* Idea : divide the array into 2 pieces, from 0 to n - 1 and from 1 to n, and use HouseRobber solution
    public int houseRobber2(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[1], nums[0]);
        }
        return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
    }
    int helper(int[] nums, int start, int end) {
        if (start + 1 == end) {
            return Math.max(nums[start], nums[end]);
        }
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = nums[start];
        for (int i = 2; i < nums.length; i++) {
            dp[i % 2] = Math.max(dp[(i - 1) % 2], dp[(i - 2) % 2] + nums[start + i - 1]);
        }
        return dp[(nums.length - 1) % 2];
    }
}
