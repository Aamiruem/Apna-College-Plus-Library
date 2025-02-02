
import java.util.Arrays;

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int index = 0; // Position to place the next non-zero element

        // Move non-zero elements to the front
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }

        // Fill remaining positions with zeros
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr)); // Output: [1, 3, 12, 0, 0]
    }
}



// Explanation
// Iterate through the array, moving non-zero elements forward.
// Fill the remaining positions with zeroes.
// Time Complexity: O(N) (single pass).
// Space Complexity: O(1) (in-place modification).
