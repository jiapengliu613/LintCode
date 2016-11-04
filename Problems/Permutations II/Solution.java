class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null ) {
            return result;
        }
        List<Integer> current = new ArrayList<>();
        if (nums.length == 0) {
            result.add(current);
            return result;
        }
        Arrays.sort(nums);
        
        helper(nums, current, result, 0);
        return result;
    } 
    
    private void helper(int[] nums, List<Integer> current, List<List<Integer>> result, int pos){
        if (pos == nums.length) {
            result.add(new ArrayList<Integer>(current));
            return ;
        }
        Set<Integer> visited = new HashSet<>();
        for (int i = pos; i < nums.length; i++) {
            if (!visited.add(nums[i])) {
                continue;
            }
            swap(nums, i, pos);
            current.add(nums[pos]);
            helper(nums, current, result, pos + 1);
            current.remove(current.size() - 1);
            swap(nums, i, pos);
        }
        
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}


