public class Solution {
    /**
     * @param A, B: Two integer arrays.
     * @return: Their smallest difference.
     */
    public int smallestDifference(int[] A, int[] B) {
        // write your code here
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return 0;
        }
        Arrays.sort(A);
        Arrays.sort(B);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            result = Math.min(result, findMinDif(A[i], B));
        }
        return result;
    }
    int findMinDif(int a, int[] A) {
        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == a) {
                return 0;
            } else if (a > A[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[start] > a) {
            if (start > 0) {
                return Math.min(Math.abs(a - A[start]), Math.abs(a - A[start - 1]));
            } else {
                return Math.abs(a - A[start]);
            }
        } else if (A[end] < a) {
            if (end < A.length - 1) {
                return Math.min(Math.abs(a - A[end]), Math.abs(a - A[end + 1]));
            } else {
                return Math.abs(a - A[end]);
            }
        } else {
            return Math.min(Math.abs(a - A[start]), Math.abs(a - A[end]));
        }
    }
}
