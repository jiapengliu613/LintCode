class Number {
    int val;
    int x;
    int y;
    public Number(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}
public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
     int[] dx = {0, 1};
     int[] dy = {1, 0};
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return -1;
        }
        int m = matrix.length, n = matrix[0].length;
        if (m * n < k) {
            return -1;
        }
        PriorityQueue<Number> pq = new PriorityQueue<>(k, 
        new Comparator<Number>() {
            @Override
            public int compare(Number a, Number b) {
                return a.val - b.val;
            }
        });
        boolean[][] visited = new boolean[m][n];
        pq.add(new Number(0, 0, matrix[0][0]));
        visited[0][0] = true;
        for (int i = 0; i < k - 1; i++) {
            Number current = pq.poll();
            for (int j = 0; j < 2; j++) {
                int newX = current.x + dx[j];
                int newY = current.y + dy[j];
                if (newX < m && newY < n && visited[newX][newY] == false) {
                    pq.add(new Number(newX, newY, matrix[newX][newY]));
                    visited[newX][newY] = true;
                }
            }
        }
        return pq.poll().val;
    }
}