class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();
        helper(result, nums, list, 0);
        return result;
    }
    
    public void helper(ArrayList<ArrayList<Integer>> result, int[] nums,
                       ArrayList<Integer> list, int pos) {
        result.add(new ArrayList<Integer>(list));
        for (int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            helper(result, nums, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}

class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        ArrayList<Integer> cur = new ArrayList<>();
        helper(result, nums, 0, cur);
        return result;
    }
    public void helper(ArrayList<ArrayList<Integer>> result, int[] nums, 
                       int pos, ArrayList<Integer> cur) {
        
        if (pos == nums.length) {
            result.add(new ArrayList<Integer>(cur));
            return ;
        }
        cur.add(nums[pos]);
        helper(result, nums, pos + 1, cur);
        cur.remove(cur.size() - 1);
        
        helper(result, nums, pos + 1, cur);
    }
}