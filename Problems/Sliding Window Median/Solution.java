public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: The median of the element inside the window at each moving.
     */
    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
        
        if (nums == null || nums.length == 0 || k == 0 || k > nums.length) {
            return new ArrayList<Integer>();
        }
        int n = nums.length;
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> smaller = new PriorityQueue<Integer>(k, Collections.reverseOrder());
        PriorityQueue<Integer> larger = new PriorityQueue<>(k);
        for (int i = 0 ; i < n; i++) {
            larger.add(nums[i]);
            smaller.add(larger.poll());
            if (smaller.size() > larger.size()) {
                larger.add(smaller.poll());
            }
            if (i >= k - 1) {
                if (smaller.size() < larger.size()) {
                    result.add(larger.peek());
                } else {
                    result.add(smaller.peek());
                }
                int index = i - k + 1;
                if (!smaller.isEmpty() && nums[index] <= smaller.peek()) {
                    smaller.remove(nums[index]);
                } else {
                    larger.remove(nums[index]);
                }
                if (larger.size() - smaller.size() > 1) {
                    smaller.add(larger.poll());
                }
                //System.out.println(smaller.peek() + " " + larger.peek());
            }
        }
        return result;
        
    }
}
