public class Solution {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
     // O(n^2), TLE in lintcode, use dp to optimize it to O(n)
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
//O(n) solution
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
        int[] dp = new int[n];
        dp[0] = A[0];
        int maxVal = A[0], tmpstart = 0, start = 0, end = 0;
        for (int i = 1; i < n; i++) {
            if (dp[i - 1] < 0) {
                tmpstart = i;
                dp[i] = A[i];
            } else {
                dp[i] = dp[i - 1] + A[i];
            }
            if (dp[i] > maxVal) {
                maxVal = dp[i];
                start = tmpstart;
                end = i;
            }
            //System.out.println(start + " " + end);
        }
        result.add(start);
        result.add(end);
        return result;
    }
}
