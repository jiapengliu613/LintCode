public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return a list of lists of integer 
     */ 
    public ArrayList<ArrayList<Integer>> kSumII(int[] A, int k, int target) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (A == null || A.length == 0 || k == 0) {
            return result;
        }
        Arrays.sort(A);
        ArrayList<Integer> cur = new ArrayList<>();
        helper(result, A, cur, 0, target, k);
        return result;
    }
    
    private void helper(ArrayList<ArrayList<Integer>> result, int[] A, ArrayList<Integer> cur,
                        int pos, int target, int numLeft) {
        
        if (target == 0 && numLeft == 0) {
            result.add(new ArrayList<Integer>(cur));
            return;
        }    
        if (target < 0 || pos >= A.length || numLeft < 0) {
            return ;
        }
    
        cur.add(A[pos]);
        helper(result, A, cur, pos + 1, target - A[pos], numLeft - 1);
        cur.remove(cur.size() - 1);
            
        helper(result, A, cur, pos + 1, target, numLeft);
        
    }
}