public class Solution {
    /**
     * @param matrix a matrix of m x n elements
     * @return an integer list
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        // Write your code here
        List<Integer> re = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) 
            return re;
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int upRow = 0, boRow = m-1, leCol = 0, riCol = n-1;
        while (true) {
            for (int i = start; i <= riCol; i++) {
                re.add(matrix[upRow][i]);
            }
            if (re.size() == m*n) 
                return re;
            start++;
            for (int i = upRow + 1; i <= boRow; i++) {
                re.add(matrix[i][riCol]);
            }
            if(re.size() == m*n) 
                return re;
            for (int i = n - 1 - start; i >= leCol; i--) {
                re.add(matrix[boRow][i]);
            }
            if (re.size() == m*n) 
                return re;
            for (int i = m - 1 - start; i > upRow; i--) {
                re.add(matrix[i][leCol]);
            }
            if (re.size() == m*n) 
                return re;
            riCol--; boRow--; leCol++; upRow++;
        }
   
  
    }
    
    
}

// another solution
public class Solution {
    /**
     * @param matrix a matrix of m x n elements
     * @return an integer list
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int offset = 0;
        
        while (true) {
            int left = offset, right = n - 1 - offset, up = offset, down = m - 1 - offset;
            
            if (left == right) {
                for (int j = up; j <= down; j++)
                    result.add(matrix[j][left]);
                return result;
            }
            if (up == down) {
                for (int j = left; j <= right; j++)
                    result.add(matrix[up][j]);
                return result;
            }
            for (int i = left; i < right; i++) {
                result.add(matrix[up][i]);
            }
            if (result.size() == m * n) {
                return result;
            }
            
            for (int i = up; i < down; i++) {
                result.add(matrix[i][right]);
            }
            if (result.size() == m * n) {
                return result;
            }
            for (int i = right; i > left; i--) {
                result.add(matrix[down][i]);
            }
            if (result.size() == m * n) {
                return result;
            }
            for (int i = down; i > up; i--) {
                result.add(matrix[i][left]);
            }
            if (result.size() == m * n) {
                return result;
            }
            
            offset++;
        }     
        
  
    }
    
    
}