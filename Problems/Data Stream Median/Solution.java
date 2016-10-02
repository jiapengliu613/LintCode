
public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        // write your code here
        
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int n = nums.length;
        int[] result = new int[n];
        PriorityQueue<Integer> larger = new PriorityQueue<>();
        PriorityQueue<Integer> smaller = new PriorityQueue<Integer>(n / 2 + 1, Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            larger.add(nums[i]);
            smaller.add(larger.poll());
            if (larger.size() < smaller.size()) {
                larger.add(smaller.poll());
            }
            if (smaller.size() < larger.size()) {
                result[i] = larger.peek();
            } else {
                result[i] = smaller.peek();
            }
        }
        return result;
        
    }
}