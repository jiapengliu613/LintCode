public class Solution {
    /**
     * @param A an integer array
     * @param start an integer
     * @param end an integer
     * @return the number of possible answer
     */
    public int subarraySumII(int[] A, int start, int end) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + A[i - 1];
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int diff = prefix[j] - prefix[i];
                if (diff >= start && diff <= end) {
                    count++;
                }
            }
        }
        return count;
    }
}