
import java.util.*;

public class ColorSort {

    public void sortColors(List<Integer> nums) {
        int low = 0;
        int mid = 0;
        int high = nums.size() - 1;

        while (mid <= high) {
            switch (nums.get(mid)) {
                case 0 -> // Swap nums.get(low) and nums.get(mid), then move both pointers
                    swap(nums, low++, mid++);
                case 1 -> // Just move the mid pointer
                    mid++;
                case 2 -> // Swap nums.get(high) and nums.get(mid), then move high pointer
                    swap(nums, high--, mid);
            }
        }
    }

    // Helper method to swap two elements in the list
    private void swap(List<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }

    public static void main(String[] args) {
        ColorSort solution = new ColorSort();
        List<Integer> nums = new ArrayList<>(Arrays.asList(2, 0, 2, 1, 1, 0)); // Example input
        solution.sortColors(nums);

        System.out.print("Sorted Colors: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
