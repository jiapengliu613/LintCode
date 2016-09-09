public class Solution {
    /**
     * @param A an array of Integer
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int result = 1;
        int count = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                count++;
                result = Math.max(result, count);
            } else {
                count = 1;
            }
        }
        count = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                count++;
                result = Math.max(result, count);
            } else {
                count = 1;
            }
        }
        return result;
        
    }
}