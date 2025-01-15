
import java.util.Arrays;

public class FindKthSmallestPairDistance {

    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0, r = nums[n - 1] - nums[0];

        while (l < r) {
            int mid = l + (r - l) / 2;
            int count = 0;

            // Count the number of pairs with distance <= mid
            for (int i = 0, j = 0; i < n; i++) {
                while (j < n && nums[j] - nums[i] <= mid) {
                    j++;
                }
                count += (j - i - 1); // Count pairs (i, i+1), (i, i+2), ..., (i, j-1)
            }

            if (count < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {1, 6, 1};
        int k = 3;
        System.out.println(smallestDistancePair(nums, k)); // Output: 5
    }
}
