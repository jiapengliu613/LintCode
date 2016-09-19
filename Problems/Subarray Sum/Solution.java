public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        
        for (int i = 1; i < n + 1; i++) {
            if (prefix[i] == 0) {
                result.add(0);
                    result.add(i - 1);
                    return result;
            }
            for (int j = i + 1; j < n + 1; j++) {
                if (prefix[j] - prefix[i] == 0) {
                    result.add(i);
                    result.add(j - 1);
                    return result;
                }
            }
        }
        result.add(-1);
        result.add(-1);
        return result;
    }
}