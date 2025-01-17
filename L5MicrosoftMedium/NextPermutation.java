
import java.util.*; // Importing the utility package for using helper classes like Arrays

// Class definition for the NextPermutation algorithm
public class NextPermutation {

    // Method to compute the next lexicographical permutation of the array
    public void setNextPermutation(int[] nums) {
        int n = nums.length; // Get the length of the input array
        int i = n - 2; // Start from the second last element (to compare with the last)

        // Find the first decreasing element from the right
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--; // Move left until nums[i] < nums[i + 1]
        }

        // If a valid index is found (not the entire array in descending order)
        if (i >= 0) {
            int j = n - 1; // Start from the last element
            // Find the smallest element greater than nums[i] to the right
            while (j >= 0 && nums[i] >= nums[j]) {
                j--; // Move left until nums[j] > nums[i]
            }
            swap(nums, i, j); // Swap nums[i] and nums[j] to make the next larger permutation
        }

        // Reverse the subarray from i+1 to the end to make it the smallest possible order
        reverse(nums, i + 1, n - 1);

        // Convert the array to a string for easier printing and debugging
        String result = Arrays.toString(nums);
        System.out.println(result); // Print the result
    }

    // Helper method to swap two elements in the array
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i]; // Store the value of nums[i] in a temporary variable
        nums[i] = nums[j]; // Assign nums[j] to nums[i]
        nums[j] = temp; // Assign the temporary value to nums[j]
    }

    // Helper method to reverse a portion of the array
    private void reverse(int[] nums, int start, int end) {
        // Swap elements from the start and end moving towards the center
        while (start < end) {
            swap(nums, start, end); // Swap the elements at 'start' and 'end'
            start++; // Move the start pointer to the right
            end--; // Move the end pointer to the left
        }
    }

    // Main method to test the algorithm
    public static void main(String[] args) {
        NextPermutation np = new NextPermutation(); // Create an instance of the class
        int[] nums = {1, 5, 1}; // Define a sample input array
        np.setNextPermutation(nums); // Call the method to compute the next permutation
    }
}
