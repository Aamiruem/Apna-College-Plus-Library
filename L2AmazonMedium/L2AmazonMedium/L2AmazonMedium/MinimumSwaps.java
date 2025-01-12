package L2AmazonMedium;

import java.util.*;

public class MinimumSwaps {
    // Function to find the minimum number of swaps required to sort the array
    public static int minSwaps(int[] arr) {
        int n = arr.length;
        int[] temp = Arrays.copyOfRange(arr, 0, n); // Create a copy of the array
        Arrays.sort(temp); // Sort the copy
        Map<Integer, Integer> map = new HashMap<>(); // Map to store the index of elements in the original array
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
        boolean[] visited = new boolean[n]; // Array to keep track of visited elements
        int swaps = 0; // Initialize swap count
        for (int i = 0; i < n; i++) {
            // If element is already visited or already in the correct position, skip it
            if (visited[i] || arr[i] == temp[i]) {
                continue;
            }
            int cycleSize = 0;
            int x = i;
            // Find the cycle of swaps needed for the current element
            while (!visited[x]) {
                visited[x] = true;
                x = map.get(temp[x]);
                cycleSize++;
            }
            // If there is a cycle, add the number of swaps needed for this cycle
            if (cycleSize > 0) {
                swaps += (cycleSize - 1);
            }
        }
        return swaps; // Return the total number of swaps
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1}; // Example array
        System.out.println("Minimum number of swaps required: " + minSwaps(arr)); // Print the result
    }
}
