public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers2(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return;
        }
        int[] tmp = new int[A.length];
        mergeSort(A, 0, A.length - 1, tmp);
        
    }
    private void mergeSort(int[] A, int start, int end, int[] tmp) {
        if (start >= end) {
            return ;
        }
        int mid = start + (end - start) / 2;
        mergeSort(A, start, mid, tmp);
        mergeSort(A, mid + 1, end, tmp);
        merge(A, start, mid, end, tmp);
    }
    private void merge(int[] A, int start, int mid, int end, int[] tmp) {
        int left = start, right = mid + 1, index = start;
        while (left <= mid && right <= end) {
            if (A[left] < A[right]) {
                tmp[index++] = A[left++];
            } else {
                tmp[index++] = A[right++];
            }
        }
        while (left <= mid) {
            tmp[index++] = A[left++];
        }
        while (right <= end) {
            tmp[index++] = A[right++];
        }
        for (int i = start; i <= end; i++) {
            A[i] = tmp[i];
        }
    }
}