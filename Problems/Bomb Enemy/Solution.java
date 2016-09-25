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
     * @param grid Given a 2D grid, each cell is either 'W', 'E' or '0'
     * @return an integer, the maximum enemies you can kill using one bomb
     */
    public int maxKilledEnemies(char[][] grid) {
        // Write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        ArrayList<Pair> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    list.add(new Pair(i, j));
                }
            }
        }
        int size = list.size();
        int result = 0;
        for (int i = 0; i < size; i++) {
            boolean[][] visited = new boolean[m][n];
            int tmp = findNum(grid, list.get(i));
            result = Math.max(tmp, result);
        }
        return result;
    }
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    private int findNum(char[][] grid, Pair cur) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < 4; i++) {
            int newX = cur.x + dx[i];
            int newY = cur.y + dy[i];
            while (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] != 'W') {
                if (grid[newX][newY] == 'E') {
                    count++;
                }
                newX += dx[i];
                newY += dy[i];
            }
        }
        return count;
    }
}