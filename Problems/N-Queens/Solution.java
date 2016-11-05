class Solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        // write your code here
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        int[] row = new int[n];
        solver(result, row, n, 0);
        return result;
    }
    
    public void solver(ArrayList<ArrayList<String>> result, int[] row, int n, int index) {
        if (index == n) {
            ArrayList<String> oneResult = stringTranslator(row);
            result.add(oneResult);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(row, index, i)) {
                row[index] = i;
                solver(result, row, n, index+1);
                row[index] = 0;
            }
        }
    }
    
    public boolean isValid(int[] row, int rowNum, int colNum) {
        for (int i = 0; i < rowNum; i++) {
            if (row[i] == colNum) {
                return false;
            }
            if(Math.abs(row[i]-colNum) == Math.abs(i - rowNum)) {
                return false;
            }
        }
        return true;
    }
    
    public ArrayList<String> stringTranslator(int[] row) {
        ArrayList<String> result = new ArrayList<>();
        for(int i = 0; i < row.length; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < row.length; j++) {
                if (j == row[i]) {
                    sb.append("Q");
                }
                else {
                    sb.append(".");
                }
            }
            result.add(sb.toString());
        }
        return result;
    }
};

//same idea another solution
class Solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        // write your code here
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        boolean[][] visited = new boolean[n][n];
        ArrayList<String> current = new ArrayList<>();
        helper(n, result, current, 0, visited);
        return result;
    }
    
    private void helper(int n, ArrayList<ArrayList<String>> result, ArrayList<String> current, int level, boolean[][] visited) {
        if (level == n) {
            result.add(new ArrayList<String>(current));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!isValid(visited, i, level)) {
                continue;
            }
            visited[level][i] = true;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < i; j ++) {
                sb.append('.');
            }
            sb.append('Q');
            for (int j = i + 1; j < n; j++) {
                sb.append('.');
            }
            current.add(sb.toString());
            helper(n, result, current, level + 1, visited);
            current.remove(current.size() - 1);
            visited[level][i] = false;
        }
    }
    
    private boolean isValid(boolean[][] visited, int col, int row) {
        for (int i = 0; i < row; i++) {
            if (visited[i][col] == true) {
                return false;
            }
        }
        for (int i = 0; i < col; i++) {
            if (visited[row][i] == true) {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (visited[i][j] == true) {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < visited.length; i--, j++) {
            if (visited[i][j] == true) {
                return false;
            }
        }
        return true;
    }
};