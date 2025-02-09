public class FirstMissingPositiveNumber {

        public int firstMissingPositive(int[] nums) {
            int n = nums.length;

            // Rearrange the array
            for (int i = 0; i < n; i++) {
                while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                    swap(nums, i, nums[i] - 1);
                }
            }

            // Find the first missing positive integer
            for (int i = 0; i < n; i++) {
                if (nums[i] != i + 1) {
                    return i + 1;
                }
            }

            // If all positive integers from 1 to n are present, return n + 1
            return n + 1;
        }

        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        public static void main(String[] args) {
            FirstMissingPositiveNumber solution = new FirstMissingPositiveNumber();
            int[] nums = {3, 4, -1, 1};
            int result = solution.firstMissingPositive(nums);
            System.out.println("First Missing Positive Number: " + result);
        }
}
