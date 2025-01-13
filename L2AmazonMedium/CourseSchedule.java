
import java.util.*;

public class CourseSchedule {

    @SuppressWarnings("Convert2Diamond")
    public static boolean canFinish(int n, int[][] prerequisites) {
        // Create an adjacency list to represent the graph
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }

        // Array to track the in-degree of each course
        int[] indegree = new int[n];

        // Build the graph and populate in-degree array
        for (int[] x : prerequisites) {
            adj[x[1]].add(x[0]);
            indegree[x[0]]++;
        }

        // Queue to store courses with in-degree 0 (no prerequisites)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // Process courses in topological order
        int count = 0;
        while (!queue.isEmpty()) {
            int c = queue.poll();
            count++;

            // Reduce the in-degree of dependent courses
            for (int j : adj[c]) {
                if (--indegree[j] == 0) {
                    queue.add(j);
                }
            }
        }

        // If all courses are processed, return true
        return count == n;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};

        System.out.println("Can finish all courses: " + canFinish(n, prerequisites));
    }
}
