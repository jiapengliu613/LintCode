public class Solution {
    /**
     * @param nums a list of integer
     * @return void
     */
    public void wiggleSort(int[] nums) {
        // Write your code here
        if (nums == null || nums.length <= 1) {
            return ;
        }
        int n = nums.length;
        quickSort(nums, 0, n - 1);
        int start = 1, end = n % 2 == 0 ? n - 2 : n - 1;
        while (start < end) {
            swap(nums, start, end);
            start += 2;
            end -= 2;
        }
        return;
    }
    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
            
        int left = start, right = end;
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        quickSort(nums, start, left - 1);
        quickSort(nums, left + 1, end);
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}