
import java.util.Arrays;

public class WiggleSort2 {

    public void wiggleSort(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums); // Step 1: Sort the array

        int[] temp = Arrays.copyOf(nums, n); // Step 2: Copy sorted array
        int mid = (n - 1) / 2;  // Midpoint index
        int end = n - 1; // Last index

        // Step 3: Rearrange the elements in wiggle order
        for (int i = 0; i < n; i++) {
            nums[i] = (i % 2 == 0) ? temp[mid--] : temp[end--];
        }
    }

    public static void main(String[] args) {
        WiggleSort2 solution = new WiggleSort2();
        int[] nums = {3, 5, 2, 1, 6, 4};

        System.out.println("Before: " + Arrays.toString(nums));
        solution.wiggleSort(nums);
        System.out.println("After: " + Arrays.toString(nums));
    }
}
