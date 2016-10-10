class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (nums == null || nums.size() == 0) {
            return result;
        }
        ArrayList<Integer> list = new ArrayList<>();
        helper(result, nums, list);
        return result;
    }
    
    public void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> nums,
                       ArrayList<Integer> list) {
        if (list.size() == nums.size()) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            if (list.contains(nums.get(i))) {
                continue;
            }
            list.add(nums.get(i));
            helper(result, nums, list);
            list.remove(list.size() - 1);
        }
        
    }
    
}

//
class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null ) {
            return result;
        }
        if (nums.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
         }
        List<Integer> cur = new ArrayList<>();
        helper(nums, result, 0, cur);
        return result;
    }
    private void helper(int[] nums, List<List<Integer>> result, int pos, List<Integer> cur) {
        if (pos == nums.length) {
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i = pos; i < nums.length; i++) {
            cur.add(nums[i]);
            swap(nums, i, pos);
            helper(nums, result, pos + 1, cur);
            cur.remove(cur.size() - 1);
            swap(nums, i, pos);
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
