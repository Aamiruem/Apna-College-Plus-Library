
public class WordSearch {

    public boolean wordSearch(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;

        for (int start = 0; start < row; start++) {
            for (int end = 0; end < col; end++) {
                if (dfs(board, start, end, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int start, int end, String word) {
        if (word.length() == 0) {
            return true; // All characters in the word are found
        }
        if (start < 0 || end < 0 || start >= board.length || end >= board[0].length || board[start][end] != word.charAt(0)) {
            return false; // Out of bounds or character mismatch
        }

        // Temporarily mark the cell as visited
        char temp = board[start][end];
        board[start][end] = '.';

        // Check all four directions
        boolean found = dfs(board, start + 1, end, word.substring(1))
                || dfs(board, start - 1, end, word.substring(1))
                || dfs(board, start, end + 1, word.substring(1))
                || dfs(board, start, end - 1, word.substring(1));

        // Restore the original value
        board[start][end] = temp;

        return found;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'},};

        String word = "SEE";
        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.wordSearch(board, word)); // Expected output: true

        word = "ABCB";
        System.out.println(wordSearch.wordSearch(board, word)); // Expected output: false
    }
}
