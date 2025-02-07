
import java.util.*;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subs = new ArrayList<>();
        subs.add(new ArrayList<>()); // Start with an empty subset

        for (int num : nums) {
            int n = subs.size();
            for (int i = 0; i < n; i++) {
                List<Integer> subset = new ArrayList<>(subs.get(i)); // Copy existing subset
                subset.add(num); // Add current number
                subs.add(subset); // Store new subset
            }
        }
        return subs;
    }

    public static void main(String[] args) {
        Subsets solution = new Subsets();
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = solution.subsets(nums);

        System.out.println("Subsets:");
        for (List<Integer> subset : subsets) {
            System.out.print("[ ");
            for (int num : subset) {
                System.out.print(num + " ");
            }
            System.out.println("]");
        }
    }
}


// subset = number of 2^n subsets
// number of 2^3 = 8
