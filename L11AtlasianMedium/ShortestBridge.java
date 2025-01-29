
// import java.util.*;

// public class ShortestBridge {

//     private static final int[] DX = {-1, 1, 0, 0};
//     private static final int[] DY = {0, 0, -1, 1};

//     // DFS to mark the first island and add its boundary to the queue
//     public static void dfs(int[][] grid, int i, int j, Queue<int[]> queue) {
//         int n = grid.length, m = grid[0].length;
//         grid[i][j] = 2; // Mark as visited
//         queue.offer(new int[]{i, j, 0}); // Add to BFS queue

//         for (int k = 0; k < 4; k++) {
//             int nx = i + DX[k];
//             int ny = j + DY[k];

//             if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 1) {
//                 dfs(grid, nx, ny, queue);
//             }
//         }
//     }

//     // BFS to find the shortest bridge
//     public static int bfs(int[][] grid, Queue<int[]> queue) {
//         int n = grid.length, m = grid[0].length;

//         while (!queue.isEmpty()) {
//             int[] front = queue.poll();
//             int x = front[0], y = front[1], distance = front[2];

//             for (int k = 0; k < 4; k++) {
//                 int nx = x + DX[k];
//                 int ny = y + DY[k];

//                 if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
//                     if (grid[nx][ny] == 1) {
//                         return distance; // Found the second island
//                     } else if (grid[nx][ny] == 0) {
//                         queue.offer(new int[]{nx, ny, distance + 1});
//                         grid[nx][ny] = 2; // Mark as visited
//                     }
//                 }
//             }
//         }
//         return -1; // Should not reach here
//     }

//     public static void main(String[] args) {
//         int[][] grid = {
//             {1, 0, 0, 0},
//             {1, 0, 0, 0},
//             {1, 0, 0, 1},
//             {0, 0, 0, 1},
//             {0, 0, 0, 1}
//         };

//         int n = grid.length, m = grid[0].length;
//         Queue<int[]> queue = new LinkedList<>();
//         boolean found = false;

//         // Find and mark the first island using DFS
//         for (int i = 0; i < n && !found; i++) {
//             for (int j = 0; j < m; j++) {
//                 if (grid[i][j] == 1) {
//                     dfs(grid, i, j, queue);
//                     found = true;
//                     break;
//                 }
//             }
//         }

//         // Run BFS to find the shortest bridge
//         int ans = bfs(grid, queue);
//         System.out.println(ans);
//     }
// }



















import java.util.*;

public class ShortestBridge {

    private List<int[]> q;

    public void dfs(int[][] grid, int x, int y) {
        int n = grid.length, m = grid[0].length;
        grid[x][y] = 2;
        q.add(new int[]{0, x, y});

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m && grid[nx][ny] == 1) {
                dfs(grid, nx, ny);
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1, 0, 0, 0},
            {1, 0, 0, 0},
            {1, 0, 0, 1},
            {0, 0, 0, 1},
            {0, 0, 0, 1}
        };

        int n = grid.length;
        int m = grid[0].length;
        ShortestBridge obj = new ShortestBridge();
        obj.q = new ArrayList<>();

        boolean found = false;

        // Finding the first island and marking it using DFS
        for (int i = 0; i < n && !found; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    obj.dfs(grid, i, j);
                    found = true;
                    break;
                }
            }
        }

        // BFS to find the shortest bridge
        while (!obj.q.isEmpty()) {
            List<int[]> newq = new ArrayList<>();
            for (int[] cur : obj.q) {
                int wt = cur[0];
                int x = cur[1];
                int y = cur[2];

                int[] dx = {-1, 1, 0, 0};
                int[] dy = {0, 0, -1, 1};

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                        if (grid[nx][ny] == 1) {
                            System.out.println(wt + 1);
                            return;
                        } else if (grid[nx][ny] == 0) {
                            newq.add(new int[]{wt + 1, nx, ny});
                            grid[nx][ny] = -1;
                        }
                    }
                }
            }
            obj.q = newq;
        }
    }
}
