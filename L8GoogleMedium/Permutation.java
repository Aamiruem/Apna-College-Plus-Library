// import java.util.*;
// public class Permutation {
//     List<List<Integer>> ans;
//     public List<List<Integer>> permute(int[] nums) {
//         ans = new LinkedList<>();
//        helper(nums, new ArrayList<>());
//         return ans;
//     }

//     public void helper(int[] nums, List<Integer> path) {
//         if (path.size() == nums.length) {
//             ans.add(new ArrayList<>(path));
//             return;
//         }
//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] != -11) {
//                 int temp = nums[i];
//                 path.add(temp);
//                 nums[i] = -11;
//                 helper(nums, path);
//                 path.remove(path.size() - 1);
//                 nums[i] = temp;
//             }
//         }
//     }
//     public static void main(String[] args) {
//         Permutation p = new Permutation();
//         int[] nums = {1, 2, 3};
//         List<List<Integer>> ans = p.permute(nums);
//         for (List<Integer> l : ans) {
//             System.out.println(l);
//         }

//         // Test case
//         int[] nums1 = {1, 2, 3, 4};
//         List<List<Integer>> Expected1 = new ArrayList<>(); 
//         Expected1.add(Arrays.asList(1, 2, 3, 4));
//         Expected1.add(Arrays.asList(1, 2, 4, 3));
//         Expected1.add(Arrays.asList(1, 3, 2, 4));
//         Expected1.add(Arrays.asList(1, 3, 4, 2));
//         Expected1.add(Arrays.asList(1, 4, 2, 3));
//         Expected1.add(Arrays.asList(1, 4, 3, 2));
//         Expected1.add(Arrays.asList(2, 1, 3, 4));
//         Expected1.add(Arrays.asList(2, 1, 4, 3));
//         Expected1.add(Arrays.asList(2, 3, 1, 4));
//         Expected1.add(Arrays.asList(2, 3, 4, 1));
//         Expected1.add(Arrays.asList(2, 4, 1, 3));
//         Expected1.add(Arrays.asList(2, 4, 3, 1));
//         Expected1.add(Arrays.asList(3, 1, 2, 4));
//         Expected1.add(Arrays.asList(3, 1, 4, 2));
//         Expected1.add(Arrays.asList(3, 2, 1, 4));
//         Expected1.add(Arrays.asList(3, 2, 4, 1));
//         Expected1.add(Arrays.asList(3, 4, 1, 2));
//         Expected1.add(Arrays.asList(3, 4, 2, 1));
//         Expected1.add(Arrays.asList(4, 1, 2, 3));
//         Expected1.add(Arrays.asList(4, 1, 3, 2));
//         Expected1.add(Arrays.asList(4, 2, 1, 3));
//         Expected1.add(Arrays.asList(4, 2, 3, 1));    
//         Expected1.add(Arrays.asList(4, 3, 1, 2));
//         Expected1.add(Arrays.asList(4, 3, 2, 1));
//         List<List<Integer>> ans1 = p.permute(nums1);
//         if (Expected1.equals(ans1)) {
//             System.out.println("Test case1 passed!");
//         } else {
//             System.out.println("Test case1 failed!");
//         }


//         // Test case
//         int[] nums2 = {1, 1, 2};
//         List<List<Integer>> Expected2 = new ArrayList<>(); 
//         Expected2.add(Arrays.asList(1, 1, 2));
//         Expected2.add(Arrays.asList(1, 2, 1));
//         Expected2.add(Arrays.asList(2, 1, 1));
//         List<List<Integer>> ans2 = p.permute(nums2);
//         if (Expected2.equals(ans2)) {
//             System.out.println("Test case2 passed!");
//         } else {
//             System.out.println("Test case2 failed!");
//         }

//         // Test case
//         int[] nums3 = {0, 1};
//         List<List<Integer>> Expected3 = new ArrayList<>(); 
//         Expected3.add(Arrays.asList(0, 1));
//         Expected3.add(Arrays.asList(1, 0));
//         List<List<Integer>> ans3 = p.permute(nums3);
//         if (Expected3.equals(ans3)) {
//             System.out.println("Test case3 passed!");
//         } else {
//             System.out.println("Test case3 failed!");
//         }

//         // Test case
//         int[] nums4 = { 1 };
//         List<List<Integer>> Expected4 = new ArrayList<>(); 
//         Expected4.add(Arrays.asList(1));
//         List<List<Integer>> ans4 = p.permute(nums4);
//         if (Expected4.equals(ans4)) {
//             System.out.println("Test case4 passed!");
//         } else {
//             System.out.println("Test case4 failed!");
//         }
//     }
// }













import java.util.*;

public class Permutation {

    List<List<Integer>> ans;

    public List<List<Integer>> permute(int[] nums) {
        ans = new LinkedList<>();
        helper(nums, new ArrayList<>());
        return ans;
    }

    public void helper(int[] nums, List<Integer> path) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != -11) {
                int temp = nums[i];
                path.add(temp);
                nums[i] = -11;
                helper(nums, path);
                path.remove(path.size() - 1);
                nums[i] = temp;
            }
        }
    }

    public static void runTestCase(int[] nums, List<List<Integer>> expected, Permutation p, int testCaseNumber) {
        List<List<Integer>> result = p.permute(nums);
        if (result.equals(expected)) {
            System.out.println("Test case " + testCaseNumber + " passed!");
        } else {
            System.out.println("Test case " + testCaseNumber + " failed!");
        }
    }

    public static void main(String[] args) {
        Permutation p = new Permutation();

        // Test case 1
        int[] nums1 = {1, 2, 3, 4};
        List<List<Integer>> expected1 = new ArrayList<>();
        expected1.add(Arrays.asList(1, 2, 3, 4));
        expected1.add(Arrays.asList(1, 2, 4, 3));
        expected1.add(Arrays.asList(1, 3, 2, 4));
        expected1.add(Arrays.asList(1, 3, 4, 2));
        expected1.add(Arrays.asList(1, 4, 2, 3));
        expected1.add(Arrays.asList(1, 4, 3, 2));
        expected1.add(Arrays.asList(2, 1, 3, 4));
        expected1.add(Arrays.asList(2, 1, 4, 3));
        expected1.add(Arrays.asList(2, 3, 1, 4));
        expected1.add(Arrays.asList(2, 3, 4, 1));
        expected1.add(Arrays.asList(2, 4, 1, 3));
        expected1.add(Arrays.asList(2, 4, 3, 1));
        expected1.add(Arrays.asList(3, 1, 2, 4));
        expected1.add(Arrays.asList(3, 1, 4, 2));
        expected1.add(Arrays.asList(3, 2, 1, 4));
        expected1.add(Arrays.asList(3, 2, 4, 1));
        expected1.add(Arrays.asList(3, 4, 1, 2));
        expected1.add(Arrays.asList(3, 4, 2, 1));
        expected1.add(Arrays.asList(4, 1, 2, 3));
        expected1.add(Arrays.asList(4, 1, 3, 2));
        expected1.add(Arrays.asList(4, 2, 1, 3));
        expected1.add(Arrays.asList(4, 2, 3, 1));
        expected1.add(Arrays.asList(4, 3, 1, 2));
        expected1.add(Arrays.asList(4, 3, 2, 1));
        runTestCase(nums1, expected1, p, 1);

        // Test case 2
        int[] nums2 = {1, 1, 2};
        List<List<Integer>> expected2 = new ArrayList<>();
        expected2.add(Arrays.asList(1, 1, 2));
        expected2.add(Arrays.asList(1, 2, 1));
        expected2.add(Arrays.asList(2, 1, 1));
        runTestCase(nums2, expected2, p, 2);

        // Test case 3
        int[] nums3 = {0, 1};
        List<List<Integer>> expected3 = new ArrayList<>();
        expected3.add(Arrays.asList(0, 1));
        expected3.add(Arrays.asList(1, 0));
        runTestCase(nums3, expected3, p, 3);

        // Test case 4
        int[] nums4 = {1};
        List<List<Integer>> expected4 = new ArrayList<>();
        expected4.add(Arrays.asList(1));
        runTestCase(nums4, expected4, p, 4);
    }
}
