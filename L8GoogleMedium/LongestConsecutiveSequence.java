
import java.util.HashSet;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int current = num;
                int count = 1;
                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence s = new LongestConsecutiveSequence();

        int[] nums1 = {100, 4, 200, 1, 3, 2};
        int expected1 = 4;
        int actual1 = s.longestConsecutive(nums1);
        System.out.println("Length of the longest consecutive sequence: " + actual1);
        if (actual1 == expected1) {
            System.out.println("Test case 1 passed!");
        } else {
            System.out.println("Test case 1 failed!");
        }
        System.out.println();

        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int expected2 = 9;
        int actual2 = s.longestConsecutive(nums2);
        System.out.println("Length of the longest consecutive sequence: " + actual2);
        if (actual2 == expected2) {
            System.out.println("Test case 2 passed!");
        } else {
            System.out.println("Test case 2 failed!");
        }
        System.out.println();

        int[] nums3 = {1, 2, 0, 1};
        int expected3 = 3;
        int actual3 = s.longestConsecutive(nums3);
        System.out.println("Length of the longest consecutive sequence: " + actual3);
        if (actual3 == expected3) {
            System.out.println("Test case 3 passed!");
        } else {
            System.out.println("Test case 3 failed!");
        }
    }
}
