public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum2(int[] nums, int target) {
        // Write your code here
        /*
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0, end = nums.length - 1;
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            start = i;
            end = i + 1;
            while (end < nums.length) {
                if (nums[start] + nums[end] <= target) {
                    end++;
                } else if (nums[start] + nums[end] > target) {
                    count += nums.length - end;
                    break;
                }
            }
        }
        return count;
        */
        Arrays.sort(nums);
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0, end = nums.length - 1;
        int count = 0;
        while (start < end) {
            if (nums[start] + nums[end] > target) {
                count += end - start;
                end--;
            } else {
                start++;
            }
        }
        return count;
    }
}