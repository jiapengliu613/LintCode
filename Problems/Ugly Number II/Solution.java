class Solution {
    /**
     * @param n an integer
     * @return the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        // Write your code here
        if (n <= 1) {
            return 1;
        }
        //long result;
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        minHeap.offer(1l);
        set.add(1l);
        for (int i = 1; i < n; i++) {
            //result = minHeap.peek();
           long result = minHeap.poll();
            set.remove(result);

            if (!set.contains(result * 2)) { 
                minHeap.offer(result * 2);
                set.add(result * 2);
            }
            if (!set.contains(result * 3)) {    
                minHeap.offer(result * 3);
                set.add(result * 3);
            }
            if (!set.contains(result * 5)) {
                minHeap.offer(result * 5);
                set.add(result * 5);
            }
        }
        return minHeap.poll().intValue();
    }
};
