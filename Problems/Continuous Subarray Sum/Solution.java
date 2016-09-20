public class Solution {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySum(int[] A) {
        // Write your code here
        ArrayList<Integer> result = new ArrayList<>(2);
        if (A == null || A.length== 0) {
            return result;
        }
        int n = A.length;
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + A[i - 1];
        }
        int max = 0, start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int diff = prefix[j] - prefix[i];
                if (diff > max) {
                    max = diff;
                    start = i;
                    end = j - 1;
                }
            }
        }
        result.add(start);
        result.add(end);
        return result;
    }
}