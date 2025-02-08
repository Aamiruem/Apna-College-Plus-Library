
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatrixSum {

    public int matrixSum(List<List<Integer>> nums) {
        int ans = 0;
        int m = nums.size();      // Number of rows
        int n = nums.get(0).size();   // Number of columns

        // Sort each row in descending order
        for (List<Integer> row : nums) {
            Collections.sort(row, Collections.reverseOrder());
        }

        // Find the max element in each column
        for (int j = 0; j < n; ++j) {
            int x = 0;
            for (int i = 0; i < m; ++i) {
                x = Math.max(x, nums.get(i).get(j));  // Get the maximum value in column j
            }
            ans += x;  // Add the maximum value from the column to the sum
        }

        return ans;
    }

    public static void main(String[] args) {
        MatrixSum solution = new MatrixSum();

        // Creating the List of List of Integers (matrix)
        List<List<Integer>> nums = new ArrayList<>();

        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(5);
        row1.add(3);
        nums.add(row1);

        List<Integer> row2 = new ArrayList<>();
        row2.add(4);
        row2.add(2);
        row2.add(7);
        nums.add(row2);

        List<Integer> row3 = new ArrayList<>();
        row3.add(2);
        row3.add(5);
        row3.add(1);
        nums.add(row3);

        // Compute the matrix sum
        int sum = solution.matrixSum(nums);
        System.out.println("Matrix Sum: " + sum);
    }
}
