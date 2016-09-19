public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return ;
        }
        int n = A.length;
        for (int i = n / 2; i >= 0; i--) {
            minHeapify(A, i, n);
            
        }
    }
    void minHeapify(int[] A, int i, int n) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int index = i;
        if (left < n && A[i] > A[left]) {
            index = left;
        }
        if (right < n && A[index] > A[right]) {
            index = right;
        }
        if (index != i) {
         swap(A, index, i);
         minHeapify(A, index, n);
        }
    }
    void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}