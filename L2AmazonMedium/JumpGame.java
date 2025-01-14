// import java.util.HashMap;

// public class JumpGame {
//     static HashMap<Integer, Boolean> memo; // memoization map

//     public static boolean helper(int[] nums, int i) {
//         if (i == nums.length - 1) {
//             return true;
//         }
//         if (i >= nums.length || nums[i] == 0) {
//             return false;
//         }
//         if (memo.containsKey(i)) {
//             return false;
//         }
//         boolean res = false;
//         for (int j = 1; j <= nums[i]; j++) {
//             res = helper(nums, i + j);
//             if (res) {
//                 return true;
//             }
//             memo.put(i, true); // store in memoization map
//             return false;
//         }
//         return false;
//     }
//     static boolean jumpGame(int nums[]){
//         memo = new HashMap<>();
//         return helper(nums, 0);
//     }
//     public static void main(String[] args) {
//         int nums[] = {2, 3, 1, 1, 4};
//         System.out.println(jumpGame(nums)); // true
//     }
// }















import java.util.HashMap;

public class JumpGame {

    static HashMap<Integer, Boolean> memo; // Memoization map

    public static boolean helper(int[] nums, int i) {
        if (i == nums.length - 1) {
            return true; // Reached the last index
        }
        if (i >= nums.length || nums[i] == 0) {
            return false; // Out of bounds or stuck
        }
        if (memo.containsKey(i)) {
            return memo.get(i); // Return memoized result
        }

        for (int j = 1; j <= nums[i]; j++) {
            if (helper(nums, i + j)) {
                memo.put(i, true); // Store result in memo
                return true;
            }
        }

        memo.put(i, false); // Store result in memo
        return false;
    }

    static boolean jumpGame(int[] nums) {
        memo = new HashMap<>();
        return helper(nums, 0);
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jumpGame(nums)); // true

        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println(jumpGame(nums2)); // false
    }
}
