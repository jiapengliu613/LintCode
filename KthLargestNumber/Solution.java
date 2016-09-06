class Solution {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return helper(nums, 0, nums.length - 1, k);
    }
    private int helper(int[] nums, int start, int end, int target) {
        if (start == end) {
            return nums[start];
        }
        int kthPos = partition(nums, start, end);
        if (kthPos + 1 == target) {
            return nums[kthPos];
        } else if (kthPos + 1 < target) {
            return helper(nums, kthPos + 1, end, target);
        } else {
            return helper(nums, start, kthPos, target);
        }
    }
    private int partition(int[]nums, int start, int end) {
        int pivot = nums[start];
        while (start < end) {
            while (start < end && nums[end] <= pivot) {
                end--;
            }
            nums[start] = nums[end];
            while (start < end && nums[start] >= pivot) {
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = pivot;
        return start;
    }
};