
public class MinimumPathSum {

    public static int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        // Update first row
        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j - 1];
        }

        // Update first column
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        // DP Transition for the rest of the grid
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[m - 1][n - 1]; // Bottom-right cell contains the answer
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };
        System.out.println("Minimum Path Sum: " + minPathSum(grid)); // Output: 7
    }
}





// Minimum Path Sum : 7
// Time Complexity: O(m*n), where m is the number of rows and n is the number of columns in the grid.
// Space Complexity: O(1), as we are not using any extra space.

// Taken path =>  → 3 → 1 → 1 → 1
