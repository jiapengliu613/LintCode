
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
// Same Idea
public class Solution {
    /**
     * @param matrix an integer matrix
     * @return the coordinate of the left-up and right-down number
     */
    public int[][] submatrixSum(int[][] matrix) {
        // Write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[2][2];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] colSum = new int[m + 1][n];
        for (int j = 0; j < n; j++) {
            for (int i = 1; i <= m; i++) {
                colSum[i][j] = colSum[i - 1][j] + matrix[i - 1][j];
                
                
            }
            
        }
        
        int[] subMatrix = new int[n];
        for (int i = 0; i <= m; i++) {
            for (int j = i + 1; j <= m; j++) {
                for (int k = 0; k < n; k++) {
                    subMatrix[k] = colSum[j][k] - colSum[i][k];
                }
                
                Pair p = isZero(subMatrix);
                if (p.left != -2 && p.right != -2) {
                    int[][] result = new int[2][2];
                    result[0][0] = i;
                    result[0][1] = p.left + 1;
                    result[1][0] = j - 1;
                    result[1][1] = p.right;
                    return result;
                }
            }
        }
        return new int[2][2];
    }
    
    private Pair isZero(int[] nums) {
        int n = nums.length;
        Pair result = new Pair(-2, -2);
         int[] prefix = new int[nums.length + 1];
         for (int i = 1; i <= nums.length; i++) {
             prefix[i] = prefix[i - 1] + nums[i - 1];
         }
         for (int i = 1; i < n + 1; i++) {
             if (prefix[i] == 0) {
                 result.left = -1;
                 result.right = i - 1;
                 return result;
             }
             for (int j = i + 1; j <= n; j++) {
                 if (prefix[i] == prefix[j]) {
                     result.left = i - 1;
                     result.right = j - 1;
                     return result;
                 }
             }
         }
         return result;
    }
}

class Pair {
    int left;
    int right;
    public Pair(int left, int right) {
        this.left = left;
        this.right = right;
    }
}