
public class Solution {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySumII(int[] A) {
        // Write your code here
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);
        result.add(0);
        if (A == null || A.length == 0) {
            return result;
        }
        int n = A.length;
        int total = 0, sum = 0, start = 0, end = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            total += A[i];
            if (sum < 0) {
                sum = A[i];
                start = i;
                end = i;
            } else {
                sum += A[i];
                end = i;
            }
            if (sum > max) {
                max = sum;
                result.set(0, start);
                result.set(1, end);
            }
        }
        sum = 0; 
        start = 0; 
        end = 0;
        for (int i = 0; i < n; i++) {
            if (sum > 0) {
                sum = A[i];
                start = i;
                end = i;
            } else {
                sum += A[i];
                end = i;
            }
            if (start == 0 && end == n - 1) {
                continue;
            }
            if (total - sum > max) {
                max = total - sum;
                result.set(0, (end + 1) % n);
                result.set(1, (start - 1 + n) % n);
            }
        }
        return result;
    }
}