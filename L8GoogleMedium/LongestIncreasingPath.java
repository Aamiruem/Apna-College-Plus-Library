// public class LongestIncreasingPath {

//     private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//     private int[][] dp;

//     public int longestIncreasingPath(int[][] matrix) {
//         if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
//             return 0;
//         }

//         int rows = matrix.length, cols = matrix[0].length;
//         dp = new int[rows][cols];
//         int maxLength = 0;

//         for (int i = 0; i < rows; i++) {
//             for (int j = 0; j < cols; j++) {
//                 maxLength = Math.max(maxLength, dfs(matrix, i, j));
//             }
//         }

//         return maxLength;
//     }

//     private int dfs(int[][] matrix, int row, int col) {
//         if (dp[row][col] != 0) {
//             return dp[row][col];
//         }

//         int maxLength = 1;
//         for (int[] dir : directions) {
//             int newRow = row + dir[0];
//             int newCol = col + dir[1];

//             if (newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol < matrix[0].length
//                     && matrix[newRow][newCol] > matrix[row][col]) {
//                 maxLength = Math.max(maxLength, 1 + dfs(matrix, newRow, newCol));
//             }
//         }

//         dp[row][col] = maxLength;
//         return maxLength;
//     }

//     public static void main(String[] args) {
//         LongestIncreasingPath obj = new LongestIncreasingPath();

//         int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//         System.out.println(obj.longestIncreasingPath(matrix1)); // Output: 9

//         int[][] matrix2 = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
//         System.out.println(obj.longestIncreasingPath(matrix2)); // Output: 4

//         int[][] matrix3 = {{1, 2, 3}, {5, 6, 7}, {9, 10, 11}};
//         System.out.println(obj.longestIncreasingPath(matrix3)); // Output: 9

//         int[][] matrix4 = {{1, 2, 4}, {5, 6, 8}, {9, 10, 12}};
//         System.out.println(obj.longestIncreasingPath(matrix4)); // Output: 9
//     }
// }















import java.util.*;

public class LongestIncreasingPath {

    int dp[][];

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length, col = matrix[0].length;
        if (row == 1 || col == 1) {
            return 1;
        }
        dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(dp[i], -1);
        }
        int max = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int curr = bfs(matrix, i, j, dp);
                dp[i][j] = curr;
                max = Math.max(max, curr);
            }
        }
        return max;
    }

    private int bfs(int[][] matrix, int x, int y, int[][] dp) {
        int dirs[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        int ans = 0;
        int row = matrix.length, col = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { x, y });
        int fin_ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ans++;
            for (int i = 0; i < size; i++) {
                int[] currPos = queue.poll();
                for (int[] dir : dirs) {
                    int nextX = currPos[0] + dir[0];
                    int nextY = currPos[1] + dir[1];
                    if (nextX < 0 && nextX >= row || nextY < 0 || nextY >= col) {
                        continue;
                    }
                    if (matrix[nextX][nextY] <= matrix[currPos[0]][currPos[1]]) {
                        continue;
                    }
                    if (dp[nextX][nextY] != -1) {
                        fin_ans = Math.max(ans + dp[nextX][nextY], fin_ans);
                    } else {
                        queue.offer(new int[] { nextX, nextY });
                    }
                }
            }

        }
        return Math.max(ans, fin_ans);
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        LongestIncreasingPath obj = new LongestIncreasingPath();
        System.out.println(obj.longestIncreasingPath(matrix)); // Output: 9

        // Test case
        int[][] matrix2 = { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } };
        int expected1 = 4;
        int result1 = obj.longestIncreasingPath(matrix2);
        if (expected1 == result1) {
        System.out.println("Test case 1 passed!");
        } else {
            System.out.println("Test case 1 failed!");
        }
    
        


        // // Test case
        // int[][] matrix3 = { { 1, 2, 3}, { 5, 6, 7}, { 9, 10, 11}};
        // int expected2 = 8;
        // int result2 = obj.longestIncreasingPath(matrix3);
        // if (expected2 == result2) {
        //     System.out.println("Test case 2 passed!");
        // } else {
        //     System.out.println("Test case 2 failed!");
        // }


        // // Test case
        // int[][] matrix4 = { { 1, 2, 4 }, { 5, 6, 8 }, { 9, 10, 12 } };
        // int expected3 = 16;
        // int result3 = obj.longestIncreasingPath(matrix4);
        // if (expected3 == result3) {
        //     System.out.println("Test case 3 passed!");
        // } else {
        //     System.out.println("Test case 3 failed!");
        // }
        // System.out.println(obj.longestIncreasingPath(matrix4)); // Output: 16

    }
}
