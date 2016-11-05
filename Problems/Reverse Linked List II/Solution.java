/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param ListNode head is the head of the linked list 
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        for (int i = 1; i < m; i++) {
            head = head.next;
        }
        ListNode prev = head;
        //System.out.println(prev.val);
        ListNode mth = prev.next;
        ListNode nth = dummy.next;
        for (int i = 1; i < n; i++) {
            nth = nth.next;
        }
        //System.out.println(nth.val);
        ListNode tail = nth.next;
        
        prev.next = nth;
        reverse(mth, nth);
        mth.next = tail;
        return dummy.next;
    }
    
    private void reverse(ListNode start, ListNode end) {
        
        if (start == end) {
            return;
        }
        ListNode next = start.next;
        reverse(next, end);
        next.next = start;
        
        /*
        ListNode prev = null;
        ListNode cur = start;
        for (int i = m; i < n; i++) {
            start = start.next;
            cur.next = prev;
            prev = cur;
            cur = start;
            
        }
        */
    }
    
}