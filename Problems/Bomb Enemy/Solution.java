//O(k * m * n) solution, k is number of cells, TLE in LintCode, use dp tp optimize

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
// O(m * n) Solution because repeated computation is avoided
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
        int row = 0;
        int[] col = new int[n];
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 || grid[i][j - 1] == 'W') {
                    row = 0;
                    for (int k = j; k < n && grid[i][k] != 'W'; k++) {
                        if (grid[i][k] == 'E') {
                            row++;
                        }
                    }
                }
                if (i == 0 || grid[i - 1][j] == 'W') {
                    col[j] = 0;
                    for (int k = i; k < m && grid[k][j] != 'W'; k++) {
                        if (grid[k][j] == 'E') {
                            col[j] += 1;
                        }
                    }
                }
                if (grid[i][j] == '0') {
                    result = Math.max(result, row + col[j]);
                }
                
            }
        }
        return result;
    }
}
