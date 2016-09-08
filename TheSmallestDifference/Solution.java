public class Solution {
    /**
     * @param A, B: Two integer arrays.
     * @return: Their smallest difference.
     */
     /* for each element in A, use binary search to find the smallest difference in B, so the big O is O(nlog(n)) */
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
// twp pointers solution big O is 2nlog(n) + O(2n) so still nlog(n)
/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                head.next = l1;
                head = head.next;
                l1 = l1.next;
            } else {
                head.next = l2;
                head = head.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            head.next = l1;
        }
        if (l2 != null) {
            head.next = l2;
        }
        return dummy.next;
    }
}
