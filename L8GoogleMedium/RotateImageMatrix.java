
public class RotateImageMatrix {

    public void rotate(int[][] board) {
        int row = board.length;
        int col = board[0].length;

        // Transpose the matrix
        for (int i = 0; i < row; i++) {
            for (int j = i; j < col; j++) {
                int temp = board[i][j];
                board[i][j] = board[j][i];
                board[j][i] = temp;
            }
        }

        // Reverse each row
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col / 2; j++) {
                int temp = board[i][j];
                board[i][j] = board[i][col - j - 1];
                board[i][col - j - 1] = temp;
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        RotateImageMatrix obj = new RotateImageMatrix();

        // Test case 1: 4x4 matrix
        int[][] board = {
            {5, 1, 9, 11},
            {2, 4, 8, 10},
            {13, 3, 6, 7},
            {15, 14, 12, 16}
        };

        System.out.println("Original Matrix:");
        printMatrix(board);
        System.out.println();

        obj.rotate(board);

        System.out.println("Rotated Matrix:");
        printMatrix(board);

        // Expected Output:
        // 15 13 2  5
        // 14 3  4  1
        // 12 6  8  9
        // 16 7  10 11
        // Test case 2: 3x3 matrix
        int[][] board3x3 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("\nOriginal 3x3 Matrix:");
        printMatrix(board3x3);
        System.out.println();

        obj.rotate(board3x3);

        System.out.println("Rotated 3x3 Matrix:");
        printMatrix(board3x3);

        // Expected Output:
        // 7 4 1
        // 8 5 2
        // 9 6 3
    }
}
