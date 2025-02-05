
import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSubarrayWithSumAtLeastK {

    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1];

        // Compute prefix sums
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int result = Integer.MAX_VALUE;
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i <= n; i++) {
            // Remove indices from the front of the deque if the sum is >= k
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peekFirst()] >= k) {
                result = Math.min(result, i - deque.pollFirst());
            }

            // Maintain the deque in increasing order of prefix sums
            while (!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offerLast(i);
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static void main(String[] args) {
        ShortestSubarrayWithSumAtLeastK solution = new ShortestSubarrayWithSumAtLeastK();
        int[] nums = {2, -1, 2};
        int k = 3;
        System.out.println(solution.shortestSubarray(nums, k)); // Output: 3
    }
}
