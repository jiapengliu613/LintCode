public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        // write your code here
        if (board == null || board.length == 0 || board[0].length == 0 || word == null) {
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (helper(i, j, board, word, visited, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    private boolean helper(int i, int j, char[][] board, String word, int[][] visited, int pos) {
        if (word.length() == pos) {
            return true;
        }
        if (i< 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] == 1) {
            return false;
        }
        visited[i][j] = 1;
        boolean result = false;
        if (board[i][j] == word.charAt(pos)) {
            for (int k = 0; k < 4; k++) {
                int newX = i + dx[k];
                int newY = j + dy[k];
                if (helper(newX, newY, board, word, visited, pos + 1)) {
                    result = true;
                    break;
                }
                
            }
        }
        visited[i][j] = 0;
        return result;
    }
}