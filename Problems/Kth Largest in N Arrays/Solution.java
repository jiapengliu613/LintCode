class Node {
    int val;
    int i;
    int j;
    public Node(int val, int i, int j) {
        this.i = i;
        this.j = j;
        this.val = val;
    }
}
public class Solution {
    /**
     * @param arrays a list of array
     * @param k an integer
     * @return an integer, K-th largest element in N arrays
     */
    public int KthInArrays(int[][] arrays, int k) {
        // Write your code here
        if (arrays == null || arrays.length == 0) {
            return 0;
        }
        int m = arrays.length;
        int n = arrays[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            Arrays.sort(arrays[i]);
            
            int l = 0, r = arrays[i].length - 1;
            count += r + 1;
            while (l < r) {
                int tmp = arrays[i][r];
                arrays[i][r] = arrays[i][l];
                arrays[i][l] = tmp;
                l++;
                r--;
            }
            
        }
        if (k > count) {
             return 0;
        }
        int result = 0;
        PriorityQueue<Node> pq = new PriorityQueue<Node>(m, new Comparator<Node>() {
            public int compare(Node a, Node b) {
                return b.val - a.val;
            }
            });
        
        for (int i = 0; i < m; i++) {
            if (arrays[i].length > 0)
                pq.offer(new Node(arrays[i][0], i, 0));
        }
        
        
        for (int i = 0; i < k; i++) {
            Node cur = pq.poll();
            result = cur.val;
            
            if (cur.j < arrays[cur.i].length - 1) {
                pq.offer(new Node(arrays[cur.i][cur.j + 1], cur.i, cur.j + 1));
            } 
        }
        return result;
    }
}