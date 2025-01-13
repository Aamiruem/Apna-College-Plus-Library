// public class NumbersOfIslands {
//     static int CountIslands(char[][] grid) {
//         int row = grid.length;
//         int col = grid[0].length;
//         int count = 0;

//         for (int i = 0; i < row; i++) {
//             for (int j = 0; j < col; j++) {
//                 if (grid[i][j] == 1) {
//                     count++;
//                     dfs(grid, i, j);
//                 }
//             }
//         }
//         return count;
//     }
//     static void dfs(char[][] grid, int i, int j) { //i rows, j columns
//         if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
//             return;
//         }
//         grid[i][j] = 0;
//         dfs(grid, i + 1, j); // up
//         dfs(grid, i - 1, j); // down
//         dfs(grid, i, j + 1); // right
//         dfs(grid, i, j - 1); // left
//     }
//     public static void main(String[] args) {
//         char[][] grid = {
//             {1, 1, 0, 0, 0},
//             {1, 1, 0, 0, 0},
//             {0, 0, 1, 0, 0},
//             {0, 0, 0, 1, 1}
//         };
//         int count = CountIslands(grid);
//         System.out.println("Number of islands: " + count);
//     }
// }







// lecture code
public class NumbersOfIslands {

    // Perform Depth First Search
    static void DFS(int[][] grid, int i, int j, int row, int col) {
        // Boundary conditions
        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] == 0) {
            return;
        }

        // Mark the cell as visited
        grid[i][j] = 0;

        // Explore all 4 directions
        DFS(grid, i - 1, j, row, col); // Up
        DFS(grid, i + 1, j, row, col); // Down
        DFS(grid, i, j - 1, row, col); // Left
        DFS(grid, i, j + 1, row, col); // Right
    }

    // Count the number of islands
    static int countIslands(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int count = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    DFS(grid, i, j, row, col);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 1, 1, 0, 0, 0 },
                { 1, 1, 0, 0, 0 },
                { 0, 0, 1, 0, 0 },
                { 0, 0, 0, 1, 1 }
        };

        System.out.println("Number of islands: " + countIslands(grid));
    }
}
