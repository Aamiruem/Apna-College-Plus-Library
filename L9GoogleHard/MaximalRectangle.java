import java.util.Stack;

public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] dp = new int[cols]; // Array to store heights
        int maxArea = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Update the height for column j
                dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
            }
            // Calculate the largest rectangle for the current row's histogram
            maxArea = Math.max(maxArea, largestRectangleArea(dp));
        }

        return maxArea;
    }

    private int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Stack<Integer> stack = new Stack<>();

        // Fill the nearest smaller to the left
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Fill the nearest smaller to the right
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? len : stack.peek();
            stack.push(i);
        }

        // Calculate the maximum area
        int maxArea = 0;
        for (int i = 0; i < len; i++) {
            int width = right[i] - left[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        MaximalRectangle sol = new MaximalRectangle();

        // Test case 1
        char[][] matrix1 = {
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}
        };
        System.out.println(sol.maximalRectangle(matrix1)); // Expected output: 6

        // Test case 2
        char[][] matrix2 = {
            {'0'}
        };
        System.out.println(sol.maximalRectangle(matrix2)); // Expected output: 0

        // Test case 3
        char[][] matrix3 = {
            {'1'}
        };
        System.out.println(sol.maximalRectangle(matrix3)); // Expected output: 1
    }
}
