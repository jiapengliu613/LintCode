class Pair {
    int x;
    int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Solution {
    /**
     * @param grid a 2D grid
     * @return an integer
     */
    public int shortestDistance(int[][] grid) {
        // Write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        ArrayList<Pair> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    list.add(new Pair(i, j));
                }
            }
        }
        int k = list.size();
        int[][][] distance = new int[k][m][n];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(distance[i][j], Integer.MAX_VALUE);
            }
        }
        int result = Integer.MAX_VALUE;
        int[][] visited;
        for (int index = 0; index < k; index++) {
            visited = new int[m][n];
            findDis(distance, grid, list.get(index), index, visited);
        
        }
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 || grid[i][j] == 2) {
                    continue;
                }
                int tmpDis = 0;
                for (index = 0; index < k; index++) {
                    if (distance[index][i][j] == Integer.MAX_VALUE) {
                        break;
                    }
                    tmpDis += distance[index][i][j];
                }
                if (index != k) {
                    continue;
                }
                result = Math.min(result, tmpDis);
            }
        }
        if (result == Integer.MAX_VALUE) {
            return -1;
        }
        return result;
    }
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    private void findDis(int[][][] distance, int[][] grid, Pair cur, int index, int[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.push(cur);
        visited[cur.x][cur.y] = 1;
        distance[index][cur.x][cur.y] = 0;
        while (!queue.isEmpty()) {
            Pair now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = now.x + dx[i];
                int newY = now.y + dy[i];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 0 && visited[newX][newY] == 0) {
                    queue.offer(new Pair(newX, newY));
                    visited[newX][newY] = 1;
                    distance[index][newX][newY] = distance[index][now.x][now.y] + 1;
                }
            }
        }
        
    }
}