

// This is a more efficient solution using dynamic programming.

public class UniquePath3 {

    private int empty = 1; // Count of empty cells (including the starting cell)
    private int res = 0;   // Result to store the number of unique paths

    public void dfs(int[][] grid, int x, int y, int count) {
        // Boundary checks and obstacle checks
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == -1) {
            return;
        }

        // If reached the ending cell
        if (grid[x][y] == 2) {
            if (empty == count) { // If all empty cells are covered
                res++;
            }
            return;
        }

        // Mark the current cell as visited
        grid[x][y] = -1;

        // Explore all four directions
        dfs(grid, x + 1, y, count + 1);
        dfs(grid, x - 1, y, count + 1);
        dfs(grid, x, y + 1, count + 1);
        dfs(grid, x, y - 1, count + 1);

        // Backtrack: Unmark the current cell
        grid[x][y] = 0;
    }

    public int uniquePathsIII(int[][] grid) {
        int start_x = 0, start_y = 0;

        // Find the starting cell and count empty cells
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    start_x = i;
                    start_y = j;
                } else if (grid[i][j] == 0) {
                    empty++;
                }
            }
        }

        // Start DFS from the starting cell
        dfs(grid, start_x, start_y, 0);

        return res;
    }

    public static void main(String[] args) {
        UniquePath3 solution = new UniquePath3(); // Create an instance of UniquePath3
        int[][] grid = {
            {1, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 2, -1}
        };

        int uniquePaths = solution.uniquePathsIII(grid);
        System.out.println("Number of Unique Paths: " + uniquePaths);
    }
}
