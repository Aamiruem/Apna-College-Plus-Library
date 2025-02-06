// public class RemoveElements {
//     public int removeElement(int[] nums, int val) {
//         int index = 0; // Pointer for placing non-val elements

//         for (int num : nums) {
//             if (num != val) {
//                 nums[index] = num;
//                 index++;
//             }
//         }
//         return index; // New length of the array
//     }

//     public static void main(String[] args) {
//         RemoveElements solution = new RemoveElements();
//         int[] nums = {3, 2, 2, 3, 4, 3, 5};
//         int val = 3;
//         int newLength = solution.removeElement(nums, val);

//         System.out.print("Updated array: ");
//         for (int i = 0; i < newLength; i++) {
//             System.out.print(nums[i] + " ");
//         }
//     }
// }










import java.util.Arrays;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int index = 0; // Pointer for placing non-val elements

        for (int num : nums) {
            if (num != val) {
                nums[index] = num;
                index++;
            }
        }
        return index; // New length of the array
    }

    public static void main(String[] args) {
        RemoveElement solution = new RemoveElement();
        
        // Example 1
        int[] nums1 = {10, 1, 2, 2, 3, 0, 4, 21};
        int val1 = 2;
        int newLength1 = solution.removeElement(nums1, val1);
        System.out.println("Output: " + newLength1 + ", nums = " + Arrays.toString(Arrays.copyOf(nums1, newLength1)));

        // Example 2
        int[] nums2 = {3, 2, 2, 3};
        int val2 = 3;
        int newLength2 = solution.removeElement(nums2, val2);
        System.out.println("Output: " + newLength2 + ", nums = " + Arrays.toString(Arrays.copyOf(nums2, newLength2)));
    }
}
