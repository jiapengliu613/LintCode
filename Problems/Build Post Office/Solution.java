// bigO is O(m * n * k), TLE in LintCode, use binary search to optimize
class Number {
    int x;
    int y;
    public Number(int x, int y) {
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
        int minDis = Integer.MAX_VALUE;
        int m = grid.length;
        int n = grid[0].length;
        ArrayList<Number> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    list.add(new Number(i, j));
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    continue;
                }
                int tmp = findDis(i, j, list);
                minDis = Math.min(minDis, tmp);
            }
        }
        return minDis;
    }
    private int findDis(int row, int col, ArrayList<Number> list) {
        int result = 0;
        for (Number num : list) {
            result += Math.abs(row - num.x);
            result += Math.abs(col - num.y);
        }
        return result;
    }
}
