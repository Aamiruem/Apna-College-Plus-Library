
import java.util.*;

public class EqualRowColPairs {

    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<List<Integer>, Integer> rowMap = new HashMap<>();
        for (int[] row : grid) {
            List<Integer> rowList = new ArrayList<>();
            for (int num : row) {
                rowList.add(num);
            }
            rowMap.put(rowList, rowMap.getOrDefault(rowList, 0) + 1);
        }

        Map<List<Integer>, Integer> colMap = new HashMap<>();
        for (int j = 0; j < n; j++) {
            List<Integer> colList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                colList.add(grid[i][j]);
            }
            colMap.put(colList, colMap.getOrDefault(colList, 0) + 1);
        }

        int count = 0;
        for (List<Integer> row : rowMap.keySet()) {
            count += rowMap.get(row) * colMap.getOrDefault(row, 0);
        }
        return count;
    }
    public static void main(String[] args) {
        EqualRowColPairs obj = new EqualRowColPairs();
        int[][] grid = {
            {1, 2, 3},
            {4, 5, 6},
            {2, 5, 5}
        };
        System.out.println("Number of equal row-column pairs: " + obj.equalPairs(grid));
    }
}




















// import java.util.*;

// public class EqualRowColPairs {

//     // Function to compute the transpose of a matrix
//     public static int[][] transpose(int[][] matrix) {
//         int rows = matrix.length;
//         int cols = matrix[0].length;
//         int[][] result = new int[cols][rows];

//         for (int i = 0; i < cols; i++) {
//             for (int j = 0; j < rows; j++) {
//                 result[i][j] = matrix[j][i]; // Corrected indexing
//             }
//         }
//         return result;
//     }

//     // Function to count equal row-column pairs
//     public static int equalPairs(int[][] grid) {
//         int n = grid.length;
//         int[][] transposedGrid = transpose(grid);
//         int count = 0;

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (Arrays.equals(grid[i], transposedGrid[j])) { // Compare entire row and column
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }

//     // Main function to test the program
//     public static void main(String[] args) {
//         int[][] grid = {
//             {1, 2, 3},
//             {4, 5, 6},
//             {2, 5, 5}
//         };

//         System.out.println("Number of equal row-column pairs: " + equalPairs(grid));
//     }
// }
