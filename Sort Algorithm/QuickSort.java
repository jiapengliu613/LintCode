public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers2(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return ;
        }
        quickSort(A, 0, A.length - 1);
    }
    void quickSort(int[] A, int start, int end) {
        int left = start, right = end;
        if (left >= right) {
            return;
        }
        int pivot = A[left];
        while (left < right) {
            while (left < right && A[right] >= pivot) {
                right--;
            }
            A[left] = A[right];
            while (left < right && A[left] <= pivot) {
                left++;
            }
            A[right] = A[left];
        }
        A[left] = pivot;
        quickSort(A, start, left);
        quickSort(A, left + 1, end);
    }
}