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
// binary search solution O(log(k) * m * n)

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
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    x.add(i);
                    y.add(j);
                }
            }
        }
        int k = x.size();
        Collections.sort(x);
        Collections.sort(y);
        ArrayList<Integer> sumX = new ArrayList<>();
        ArrayList<Integer> sumY = new ArrayList<>();
        sumX.add(0);
        sumY.add(0);
        for (int i = 1; i <= x.size(); i++) {
            sumX.add(sumX.get(i - 1) + x.get(i - 1));
            sumY.add(sumY.get(i - 1) + y.get(i - 1));
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    continue;
                }
                int costX = findDis(i, x, sumX, k);
                int costY = findDis(j, y, sumY, k);
                minDis = Math.min(minDis, costX + costY);
                //System.out.println(costX + " " + costY);
            }
        }
        return minDis;
    }
    private int findDis(int pos, ArrayList<Integer> x, ArrayList<Integer> sum, int k) {
        if (pos < x.get(0) || pos > x.get(k - 1)) {
            return Math.abs(sum.get(k) - k * pos);
        }
        int left = 0, right = x.size() - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (pos == x.get(mid)) {
                return mid * pos - sum.get(mid) + sum.get(k) - sum.get(mid + 1) - (k - mid - 1) * pos;
            } else if (pos < x.get(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        
        int index = 0;
        if (x.get(right) <= pos)
            index = right;
        else
            index = left;
        return sum.get(k) - sum.get(index + 1) - pos * (k - index - 1) + 
               (index + 1) * pos - sum.get(index + 1);
    }
}
