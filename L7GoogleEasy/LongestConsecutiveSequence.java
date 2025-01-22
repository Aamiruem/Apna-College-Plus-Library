
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
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        System.out.println(lcs.longestConsecutive(nums)); // Output: 4

        int[] nums2 = { 0, 3, 7, 2, 5, 8, 4, 6, 9, 1 };
        System.out.println(lcs.longestConsecutive(nums2)); // Output: 9

        int[] nums3 = { -1, -2, -3 };
        System.out.println(lcs.longestConsecutive(nums3)); // Output: 3
    }
        
}
