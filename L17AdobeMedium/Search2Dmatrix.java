
// public class Search2Dmatrix {

//     public int searchMatrix(int[][] matrix, int target) {
//         if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
//             return 0;  // Return 0 if the matrix is empty or null
//         }

//         int rows = matrix.length;
//         int cols = matrix[0].length;

//         // Start from the top-right corner
//         int row = 0;
//         int col = cols - 1;

//         while (row < rows && col >= 0) {
//             if (matrix[row][col] == target) {
//                 // Target found, return 1
//                 return 1;
//             } else if (matrix[row][col] < target) {
//                 // Move down if current value is smaller than the target
//                 row++;
//             } else {
//                 // Move left if current value is larger than the target
//                 col--;
//             }
//         }

//         return 0;  // Return 0 if the target is not found
//     }

//     public static void main(String[] args) {
//         Search2Dmatrix solution = new Search2Dmatrix();
//         int[][] matrix = {
//             {1, 4, 7, 11},
//             {2, 5, 8, 12},
//             {3, 6, 9, 16},
//             {10, 13, 14, 17}
//         };
//         int target = 5;
//         int result = solution.searchMatrix(matrix, target);
//         System.out.println("Target found: " + result);
//     }
// }










public class Search2Dmatrix {

    public String searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return "Matrix is empty or null";  // Handle empty or null matrix
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Start from the top-right corner
        int row = 0;
        int col = cols - 1;

        while (row < rows && col >= 0) {
            if (matrix[row][col] == target) {
                // Target found, return its position
                return "Target found at index: [" + row + ", " + col + "]";
            } else if (matrix[row][col] < target) {
                // Move down if current value is smaller than the target
                row++;
            } else {
                // Move left if current value is larger than the target
                col--;
            }
        }

        return "Target not found";  // Return message if target isn't found
    }

    public static void main(String[] args) {
        Search2Dmatrix solution = new Search2Dmatrix();
        int[][] matrix = {
            {1, 4, 7, 11},
            {2, 5, 8, 12},
            {3, 6, 9, 16},
            {10, 13, 14, 17}
        };
        int target = 14;
        String result = solution.searchMatrix(matrix, target);
        System.out.println(result);
    }
}
