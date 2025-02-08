
import java.util.HashSet;

public class Sudoku {

    public boolean isValidSudoku(char[][] board) {
        // Create sets to track seen numbers in rows, columns, and 3x3 subgrids
        HashSet<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    // Create unique keys for rows, columns, and subgrids
                    String rowKey = "row" + i + num;
                    String colKey = "col" + j + num;
                    String subgridKey = "subgrid" + (i / 3) + (j / 3) + num;

                    // If any of the keys already exist, the board is invalid
                    if (seen.contains(rowKey) || seen.contains(colKey) || seen.contains(subgridKey)) {
                        return false;
                    }

                    // Otherwise, add the keys to the set
                    seen.add(rowKey);
                    seen.add(colKey);
                    seen.add(subgridKey);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Sudoku solution = new Sudoku();
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println("Is the Sudoku valid? " + solution.isValidSudoku(board));
    }
}
