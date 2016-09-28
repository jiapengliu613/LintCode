class Node {
    int val;
    int i;
    int j;
    public Node(int val, int i, int j) {
        this.val = val;
        this.i = i;
        this.j = j;
    }
    
}

public class Solution {
    /**
     * @param A an integer arrays sorted in ascending order
     * @param B an integer arrays sorted in ascending order
     * @param k an integer
     * @return an integer
     */
    public int kthSmallestSum(int[] A, int[] B, int k) {
        // Write your code here
        int m = A.length;
        int n = B.length;
        if (k > m * n) {
            return 0;
        }
        if (m == 0) {
            return B[k - 1];
        }
        if (n == 0) {
            return A[k - 1];
        }
        PriorityQueue<Node> pq = new PriorityQueue<>(k, 
        new Comparator<Node>() {
            public int compare(Node a, Node b) {
                return a.val - b.val;
            }
        });
        HashMap<Integer, Boolean> map = new HashMap<>();
        pq.offer(new Node(A[0] + B[0], 0, 0));
        map.put(0, true);
        int result = 0;
        for (int i = 0; i < k; i++) {
            Node cur = pq.poll();
            int x = cur.i;
            int y = cur.j;
            result = cur.val;
            if (cur.i < m - 1 && !map.containsKey((x + 1) * n + y)) {
                pq.offer(new Node(A[x + 1] + B[y], x + 1, y));
                map.put((x + 1) * n + y, true);
            }
            if (cur.j < n - 1 && !map.containsKey(x * n + y + 1)) {
                pq.offer(new Node(A[x] + B[y + 1], x, y + 1));
                map.put(x * n + y + 1, true);
            }
            
        }
        return result;
    }
}