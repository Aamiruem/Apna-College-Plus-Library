
// import java.util.*;
// import static java.util.Arrays.asList;
// public class FourSum {
//     public List<List<Integer>> fourSum(int[] nums, int target) {
//         List<List<Integer>> result = new ArrayList<>();
//         int n = nums.length;
//         for (int i = 0; i < n; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 for (int k = j + 1; k < n; k++) {
//                     long newTarget = target;
//                     newTarget -= nums[i] + nums[j] + nums[k];
//                     int low = k + 1;
//                     int high = n - 1;
//                     while (low < high) {
//                         int mid = (low + high) / 2;
//                         if (nums[mid] == newTarget) {
//                             result.add(asList(nums[i], nums[j], nums[k], nums[mid]));
//                             while (low < high && nums[mid] == nums[mid + 1])
//                                 mid++;
//                             while (low < high && nums[mid] == nums[mid - 1])
//                                 mid--;
//                             low = mid + 1;
//                             high = mid - 1;
//                         } else if (nums[mid] < newTarget) {
//                             low = mid + 1;
//                         } else {
//                             high = mid - 1;
//                         }
//                     }
//                 }
//             }
//         }
//         return result;
//     }
//     public static void main(String[] args) {
//         FourSum fourSum = new FourSum();
//         int[] nums = {1, 0, -1, 0, -2, 2};
//         int target = 4;
//         List<List<Integer>> result = fourSum.fourSum(nums, target);
//         System.out.println(result);
//     }
// }




import java.util.*;
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums); // Sort the array
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>(); // To store unique quadruplets

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    long newTarget = (long) target - nums[i] - nums[j] - nums[k];

                    // Binary search to find the fourth element
                    int low = k + 1, high = n - 1;
                    while (low <= high) {
                        int mid = low + (high - low) / 2;
                        if (nums[mid] == newTarget) {
                            List<Integer> quad = new ArrayList<>();
                            quad.add(nums[i]);
                            quad.add(nums[j]);
                            quad.add(nums[k]);
                            quad.add(nums[mid]);
                            set.add(quad); // Add to set to avoid duplicates
                            break; // Exit binary search
                        } else if (nums[mid] < newTarget) {
                            low = mid + 1;
                        } else {
                            high = mid - 1;
                        }
                    }
                }
            }
        }

        return new ArrayList<>(set); // Convert set to list
    }

    public static void main(String[] args) {
        FourSum solution = new FourSum();
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(solution.fourSum(nums, target)); // Example: [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]
    }
}
