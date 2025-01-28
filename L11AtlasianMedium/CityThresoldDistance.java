// package L11AtlasianMedium;

import java.util.*;

public class CityThresoldDistance {

    public static void main(String[] args) {
        int[][] edges = {{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 2}};
        int thold = 4;
        int n = 4;
        int[][] dis = new int[n][n];

        // Initialize the distance matrix
        for (int[] row : dis) {
            Arrays.fill(row, (int) 1e4 + 1); // Use a large value to represent infinity
        }

        // Fill in distances from the edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            dis[u][v] = wt;
            dis[v][u] = wt; // Assuming the graph is undirected
        }

        // Set distance to self as 0
        for (int i = 0; i < n; i++) {
            dis[i][i] = 0;
        }

        // Floyd-Warshall algorithm to compute all-pairs shortest paths
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dis[i][k] != (int) 1e4 + 1 && dis[k][j] != (int) 1e4 + 1) {
                        dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                    }
                }
            }
        }

        // Find the city with the smallest number of reachable cities within the threshold
        int cityNo = -1;
        int noCity = n;

        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int adj = 0; adj < n; adj++) {
                if (dis[i][adj] <= thold) {
                    temp++;
                }
            }
            if (temp <= noCity) {
                cityNo = i;
                noCity = temp;
            }
        }

        // Output the result
        System.out.println(cityNo);
    }
}
