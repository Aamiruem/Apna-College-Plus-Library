// public class ToeplitzMatrix {
//     public boolean isToeplitzMatrix(int[][] matrix) {
//         int rows = matrix.length;
//         int cols = matrix[0].length;
        
//         // Check diagonals starting from (0,0)
//         for (int i = 1; i < rows; i++) {
//             for (int j = 1; j < cols; j++) {
//                 // Compare current element with top-left diagonal element
//                 if (matrix[i][j] != matrix[i-1][j-1]) {
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }

//     public static void main(String[] args) {
//         ToeplitzMatrix checker = new ToeplitzMatrix();
//         int[][] matrix = {
//             {1, 2, 3, 4},
//             {5, 1, 2, 3},
//             {9, 5, 1, 2}
//         };
//         System.out.println("Is Toeplitz? " + checker.isToeplitzMatrix(matrix)); // Output: true
//     }
// }







public class ToeplitzMatrix {
    public static boolean isToeplitzMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {
                if (matrix[row][col] != matrix[row + 1][col + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 1, 2, 3},
            {9, 5, 1, 2}
        };
        
        if (isToeplitzMatrix(matrix)) {
            System.out.println("The matrix is a Toeplitz matrix.");
        } else {
            System.out.println("The matrix is not a Toeplitz matrix.");
        }
    }
}
