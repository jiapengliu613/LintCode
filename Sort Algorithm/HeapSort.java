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
        int n = A.length;
        heapSort(A, n);
    }
    void heapSort(int[] A, int n) {
        heapify(A, n);
        
        
        int index = n;
        for (int i = n - 1; i >= 0; i--) {
            swap(A, i, 0);
            
            index--;
            maxHeapify(A, 0, index);
            
        }
    }
    void heapify(int[] A, int n) {
        for (int i = n / 2; i >= 0; i--) {
            maxHeapify(A, i, n);
        }
    }
    void maxHeapify(int[] A, int i, int n) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int index = i;
        if (left < n && A[left] > A[i]) {
            index = left;
        }
        if (right < n && A[right] > A[index]) {
            index = right;
        }
        if (index != i) {
            swap(A, i, index);
            maxHeapify(A, index, n);
        }
    }
    void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}