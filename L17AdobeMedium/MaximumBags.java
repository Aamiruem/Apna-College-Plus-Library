
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaximumBags {

    // Function to calculate the maximum number of bags that can be filled
    public static int maximumBags(List<Integer> c, List<Integer> r, int add) {
        List<Integer> diff = new ArrayList<>();
        int count = 0;
        int n = r.size();

        // Calculate the difference between current capacity and required capacity for each bag
        for (int i = 0; i < n; i++) {
            diff.add(c.get(i) - r.get(i));
        }

        // Sort the differences to process the smallest first (optimal for maximizing bags filled)
        Collections.sort(diff);

        // Try to fill the bags that have the smallest difference first
        for (int i = 0; i < n; i++) {
            if (diff.get(i) <= add) {
                add -= diff.get(i);  // Subtract the used capacity
                count++;              // Count this bag as filled
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // Example lists for current capacity and required capacity
        List<Integer> c = new ArrayList<>();
        c.add(13);
        c.add(5);
        c.add(7);

        List<Integer> r = new ArrayList<>();
        r.add(1);
        r.add(2);
        r.add(3);

        int add = 4;  // Additional capacity available to fill the bags

        // Calculate and print the result
        int maximumBags = maximumBags(c, r, add);
        System.out.println("Maximum Bags: " + maximumBags);
    }
}
