public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        int right = 0;
        for (int i = 0; i < n; i++) {
            while (right < n) {
                if (sum >= s) {
                    
                    break;
                } else {
                    sum += nums[right];
                    right++;
                }
            }
            if (sum >= s) {
                result = Math.min(result, right - i);
                sum -= nums[i];
            }
        }
        if (result == Integer.MAX_VALUE) {
            return -1;
        }
        return result;
    }
}