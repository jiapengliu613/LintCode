public class Solution {
    /**
     * @param matrix a boolean 2D matrix
     * @return an integer
     */
     //Version 1 : Idea: http://www.cnblogs.com/lichen782/p/leetcode_maximal_rectangle.html bigO is O(m²n²), TLE in lintcode, use dp to optimize
    public int maximalRectangle(boolean[][] matrix) {
        // Write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result = Math.max(result, findMax(matrix, i, j));
            }
        }
        return result;
    }
    int findMax(boolean[][] matrix, int row, int column) {
        int result = 0;
        int minWidth = Integer.MAX_VALUE;
        for (int i = row; i < matrix.length && matrix[i][column] == true; i++) {
            int curWidth = 0;
            while (column + curWidth < matrix[0].length && matrix[i][column + curWidth] == true) {
                curWidth++;
            }
            minWidth = Math.min(minWidth, curWidth);
            result = Math.max(result, (i - row + 1) * minWidth);
        }
        return result;
    }
}
//Version 2 : DP  solution
//Idea : preprocess the dp array, dp[i][j] records how many '1' exist before(i,j). Use dp[i][j] as width, and go upwards and downword 
// to find the maximum height. big O is O(m*n*m). AC in leetcode but still TLE in lintcode
public class Solution {
    /**
     * @param matrix a boolean 2D matrix
     * @return an integer
     */
    public int maximalRectangle(boolean[][] matrix) {
        // Write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        
        
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == true) {
                dp[i][0] = 1;
            }
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == false) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i][j - 1] + 1;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result = Math.max(result, maxHisto(dp, i, j));
            }
        }
        return result;
    }
    
    public int maxHisto(int[][] d, int I, int J) {
        
        int height = 0;
        int curWidth = dp[row][column];
        
        for (int i = row - 1; i >= 0; i--) {
            if (dp[i][column] >= curWidth) {
                height++;
            } else {
                break;
            }
        }
        for (int i = row; i < dp.length; i++) {
            if (dp[i][column] >= curWidth) {
                height++;
            } else {
                break;
            }
        }
        return curWidth * height;
        
    }
        
    
}
//Version 3 : dp solution, using monotone stack, imagine the matrix as a histogram and find the largest area, big O is O(m * n)
public class Solution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        // write your code here
        if (height == null || height.length == 0) {
            return 0;
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int result = 0;
        for (int i = 0; i <= height.length; i++) {
            int curHeight = (i == height.length) ? - 1 : height[i];
            while (!stack.isEmpty() && height[stack.peek()] >= curHeight) {
                int h = height[stack.peek()];
                stack.pop();
                int w = stack.isEmpty() ? i : i - (stack.peek() + 1);
                result = Math.max(result, h * w);
            }
            stack.push(i);
        }
        return result;
    }
}
