
import java.util.*;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int n = nums.length;
        int k = 3;

        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();

        // Process the first k elements
        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }

        // Process the rest of the elements
        for (int i = k; i < n; i++) {
            // Add the maximum of the current window
            ans.add(nums[dq.peekFirst()]);

            // Remove elements out of the current window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // Remove elements smaller than the current element
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);
        }

        // Add the maximum of the last window
        ans.add(nums[dq.peekFirst()]);

        System.out.print(" Sliding window maximum:  ");
        // Print the result
        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
}
