// public class RottingOranges {
//     public static int orangeRotting(int[][] grid) {
//         if (grid == null || grid.length == 0) {
//             return 0;
//         }

//         int rows = grid.length;
//         int cols = grid[0].length;
//         int countFresh = 0;
//         for (int i = 0; i < rows; i++) {
//             for (int j = 0; j < cols; j++) {
//                 if (grid[i][j] == 1) {
//                     countFresh++;
//                 }
//             }
//         }

//         int minutes = 0;
//         while (countFresh > 0) {
//             int[][] newGrid = new int[rows][cols];
//             for (int i = 0; i < rows; i++) {
//                 for (int j = 0; j < cols; j++) {
//                     if (grid[i][j] == 2) {
//                         newGrid[i][j] = 2;
//                     } else if (grid[i][j] == 1) {
//                         if (i > 0 && grid[i - 1][j] == 1) {
//                             newGrid[i - 1][j] = 2;
//                         }
//                         if (i < rows - 1 && grid[i + 1][j] == 1) {
//                             newGrid[i + 1][j] = 2;
//                         }
//                         if (j > 0 && grid[i][j - 1] == 1) {
//                             newGrid[i][j - 1] = 2;
//                         }
//                         if (j < cols - 1 && grid[i][j + 1] == 1) {
//                             newGrid[i][j + 1] = 2;
//                         }
//                     }
//                 }
//             }
//             grid = newGrid;
//             countFresh = 0;
//             for (int i = 0; i < rows; i++) {
//                 for (int j = 0; j < cols; j++) {
//                     if (grid[i][j] == 1) {
//                         countFresh++;
//                     }
//                 }
//             }
//             minutes++;
//         }

//         return minutes;
//     }
//     public static void main(String[] args) {
//         int[][] grid = {{2,1,1},{1,1,0},{0,1,1}}; // Example input grid
//         int minutes = orangeRotting(grid);
//         System.out.println("Minutes required to rot all oranges: " + minutes);
//     }
// }



















import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public static int orangeRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int countFresh = 0;
        Queue<int[]> queue = new LinkedList<>();

        // Initialize the queue with all rotten oranges and count fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    countFresh++;
                }
            }
        }

        // If there are no fresh oranges, return 0
        if (countFresh == 0) {
            return 0;
        }

        int minutes = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Up, Down, Left, Right

        // Perform BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotted = false;

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                for (int[] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    // Check if the new position is valid and contains a fresh orange
                    if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2; // Rot the fresh orange
                        queue.offer(new int[]{newX, newY});
                        countFresh--; // Decrease the count of fresh oranges
                        rotted = true;
                    }
                }
            }

            if (rotted) {
                minutes++;
            }
        }

        // If there are still fresh oranges left, return -1
        return countFresh == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}; // Example input grid
        int minutes = orangeRotting(grid);
        System.out.println("Minutes required to rot all oranges: " + minutes);
    }
}
