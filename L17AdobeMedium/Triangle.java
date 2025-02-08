
import java.util.ArrayList;
import java.util.List;

public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // Start with the last row in the triangle
        List<Integer> dp = new ArrayList<>(triangle.get(n - 1));

        // Traverse from the second-last row to the top
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                // Update dp[j] with the minimum path sum from below
                dp.set(j, triangle.get(i).get(j) + Math.min(dp.get(j), dp.get(j + 1)));
            }
        }

        // The top element of dp will hold the minimum total
        return dp.get(0);
    }

    public static void main(String[] args) {
        Triangle solution = new Triangle();

        // Initialize the triangle as a list of lists
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(List.of(2));
        triangle.add(List.of(3, 4));
        triangle.add(List.of(6, 5, 1));
        triangle.add(List.of(4, 1, 8, 3));

        // Get the minimum total path sum
        int minTotal = solution.minimumTotal(triangle);
        System.out.println("Minimum Total: " + minTotal);
    }
}
