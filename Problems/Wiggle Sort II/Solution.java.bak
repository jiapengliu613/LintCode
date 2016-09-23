public class Solution {
    /**
     * @param nums a list of integer
     * @return void
     */
    public void wiggleSort(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length;
        int mid = quickSelect(nums, 0, n - 1, n / 2 + 1);
        int[] tmp = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        int l = 0, r = n - 1, middle = n / 2;
        for (int i = 0; i < n; i++) {
            if (nums[i] < mid) {
                tmp[l++] = nums[i];
            } else if (nums[i] > mid) {
                tmp[r--] = nums[i];
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(tmp[i] + " ");
        }
        System.out.println();
        while (l < middle) {
            tmp[l++] = mid;
        }
        
        while (r >= middle) {
            tmp[r--] = mid;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(tmp[i] + " ");
        }
        System.out.println();
        if (n % 2 == 0) {
            int left = n / 2 - 1, right = n - 1;
            for (int i = 0; i < n; i++) {
                nums[i] = i % 2 == 0 ? tmp[left--] : tmp[right--];
            }
        } else {
            int left = n / 2, right = n - 1;
            for (int i = 0; i < n; i++) {
                nums[i] = i % 2 == 0 ? tmp[left--] : tmp[right--];
            }
        }
        
        return ;
        
    }
    private int quickSelect(int[] nums, int start, int end, int mid) {
        if (start >= end) {
            return nums[start];
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
        if (left + 1 == mid) {
            return nums[left];
        } else if (left + 1 < mid) {
            return quickSelect(nums, left + 1, end, mid);
        } else {
            return quickSelect(nums, start, left - 1, mid);
        }
        
    }
}
