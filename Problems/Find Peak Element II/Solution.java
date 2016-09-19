//O(nlog(n)) solution

class Solution {
    /**
     * @param A: An integer matrix
     * @return: The index of the peak
     */
    public List<Integer> findPeakII(int[][] A) {
        // write your code here
        int m = A.length;
        int n = A[0].length;
        List<Integer> result = new ArrayList<>();
        int start = 0, end = m - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int index = maxInRow(A, mid);
            //System.out.println(mid + " " + index);
            if (A[mid][index] < A[mid - 1][index]) {
                end = mid;
            } else if (A[mid][index] < A[mid + 1][index]) {
                start = mid;
            } else {
                result.add(mid);
                result.add(index);
                return result;
            }
        }
        int index1 = maxInRow(A, start);
        if (A[start][index1] > A[end][index1]) {
            result.add(start);
            result.add(index1);
            return result;
        } else {
            int index2 = maxInRow(A, end);
            result.add(end);
            result.add(index2);
            return result;
        }
    }
    private int maxInRow(int[][] A, int row) {
        int index = 0;
        int tmp = Integer.MIN_VALUE;
        for (int i = 0; i < A[row].length; i++) {
            if (A[row][i] > tmp) {
                tmp = A[row][i];
                index = i;
            }
        }
        return index;
    }
}
