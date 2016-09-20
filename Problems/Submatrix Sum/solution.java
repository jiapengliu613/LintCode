
public class Solution {
    /**
     * @param matrix an integer matrix
     * @return the coordinate of the left-up and right-down number
     */
    public int[][] submatrixSum(int[][] matrix) {
        // Write your code here
        
        int[][] result = new int[2][2];
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] prefix = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prefix[i + 1][j + 1] = matrix[i][j] + prefix[i][j + 1] + 
                               prefix[i + 1][j] - prefix[i][j]; 
                //System.out.print(prefix[i][j] + " ");
            }
            //System.out.println();
            
        }
        
        for (int upper = 0; upper < m; upper++) {
            for (int lower = upper + 1; lower <= m; lower++) {
                HashMap<Integer, Integer> map = new HashMap<>();
                for (int j = 0; j <= n; j++) {
                    int diff = prefix[lower][j] - prefix[upper][j];
                    if (!map.containsKey(diff)) {
                        map.put(diff, j);
                    } else {
                        int k = map.get(diff);
                        result[0][0] = upper;
                        result[0][1] = k;
                        result[1][0] = lower - 1;
                        result[1][1] = j - 1;
                        return result;
                    }
                }
            }
        }
        return result;
    }
    
}