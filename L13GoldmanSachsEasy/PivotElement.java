
// import java.util.*;

// public class PivotElement {

//     public static int findPivot(int[] nums) {
//         int totalSum = 0, leftSum = 0;

//         // Calculate total sum of the array
//         for (int num : nums) {
//             totalSum += num;
//         }

//         // Traverse the array and check for pivot index
//         for (int i = 0; i < nums.length; i++) {
//             if (leftSum == totalSum - leftSum - nums[i]) {
//                 return i; // Pivot index found
//             }
//             leftSum += nums[i]; // Update left sum
//         }

//         return -1; // No pivot found
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int[] arr = new int[n];

//         for (int i = 0; i < n; i++) {
//             arr[i] = sc.nextInt();
//         }

//         System.out.println(findPivot(arr));
//         sc.close();
//     }
// }


public class PivotElement {
    public static int findPivot(int[] nums) {
        int totalSum = 0, leftSum = 0;

        // Calculate total sum of the array
        for (int num : nums) {
            totalSum += num;
        }

        // Traverse the array and check for pivot index
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i; // Pivot index found
            }
            leftSum += nums[i]; // Update left sum
        }

        return -1; // No pivot found
    }


    public static void main(String[] args) {
        int[] arr = { 1, 7, 3, 6, 5, 6 }; // Hardcoded input
        System.out.print("pivot index is: "  );
        System.out.println(findPivot(arr));
    }
}
