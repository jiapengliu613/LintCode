public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        if (nums == null) {
            return 0;
        }
        if (nums.length <= 2) {
            return nums.length;
        }
        int slow = 1;
        int fast = 2;
        while (fast < nums.length) {
            if (nums[fast] == nums[slow] && nums[fast] == nums[slow - 1]) {
                fast++;
            } else {
                
                nums[++slow] = nums[fast++];
               
            }
        }
        return slow + 1;
    }
}