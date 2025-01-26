// package L9GoogleHard;

// public class LargestRectangleHistogram {
//     public int largestRectangleArea(int[] heights) {
//         int len = heights.length;
//         int[] l_right = new int[len];
//         int[] l_left = new int[len];
//         l_left[0] = -1;
//         l_right[len - 1] = len;

//         //less from left
//         for (int i = 1; i < len; i++) {
//             int index = i - 1;
//             while (index >= 0 && heights[index] >= heights[i]) {
//                 index = l_left[index];
//             }
//             l_left[i] = index;
//         }
//         //less from right
//         for (int i = len - 2; i >= 0; i--) {
//             int index = i + 1;
//             while (index < len && heights[index] >= heights[i]) {
//                 index = l_right[index];
//             }
//             l_right[i] = index;
//         }

//         int max_area = 0;
//         for (int i = 0; i < len; i++) {
//             max_area = Math.max(max_area, heights[i] * (l_right[i] - l_left[i] - 1));
//         }
//         return max_area;
//     }
//     public static void main(String[] args) {
//         LargestRectangleHistogram l = new LargestRectangleHistogram();
//         int[] arr = {2, 1, 5, 6, 2, 3};
//         System.out.println(l.largestRectangleArea(arr));
//     }
// }






// import java.util.Stack;
// public class LargestRectangleHistogram {
//     public static void main(String[] args) {
//         int[] heights = {2, 1, 5, 6, 2, 3};
//         System.out.println("Largest Rectangle Area: " + largestRectangleArea(heights));
//     }

//     public static int largestRectangleArea(int[] heights) {
//         int len = heights.length;
//         int[] left = new int[len];
//         int[] right = new int[len];

//         // Preprocessing nearest smaller to the left
//         left[0] = -1; // No smaller element to the left of the first element
//         for (int i = 1; i < len; i++) {
//             int ind = i - 1;
//             while (ind >= 0 && heights[ind] >= heights[i]) {
//                 ind = left[ind];
//             }
//             left[i] = ind;
//         }

//         // Preprocessing nearest smaller to the right
//         right[len - 1] = len; // No smaller element to the right of the last element
//         for (int i = len - 2; i >= 0; i--) {
//             int ind = i + 1;
//             while (ind < len && heights[ind] >= heights[i]) {
//                 ind = right[ind];
//             }
//             right[i] = ind;
//         }

//         // Calculate the maximum area
//         int maxArea = 0;
//         for (int i = 0; i < len; i++) {
//             int width = right[i] - left[i] - 1; // Width of the rectangle
//             int area = heights[i] * width; // Area of the rectangle
//             maxArea = Math.max(maxArea, area);
//         }

//         return maxArea;
//     }
// }






// import java.util.Arrays;

public class LargestRectangleHistogram {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] left = new int[len];
        int[] right = new int[len];

        // Compute nearest smaller to the left
        left[0] = -1; // No smaller element to the left of the first element
        for (int i = 1; i < len; i++) {
            int ind = i - 1;
            while (ind >= 0 && heights[ind] >= heights[i]) {
                ind = left[ind];
            }
            left[i] = ind;
        }

        // Compute nearest smaller to the right
        right[len - 1] = len; // No smaller element to the right of the last element
        for (int i = len - 2; i >= 0; i--) {
            int ind = i + 1;
            while (ind < len && heights[ind] >= heights[i]) {
                ind = right[ind];
            }
            right[i] = ind;
        }

        // Calculate the maximum area
        int maxArea = 0;
        for (int i = 0; i < len; i++) {
            int width = right[i] - left[i] - 1; // Width of the rectangle
            int area = heights[i] * width; // Area of the rectangle
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        LargestRectangleHistogram solution = new LargestRectangleHistogram();

        int[] heights1 = {2, 1, 5, 6, 2, 3};
        System.out.println(solution.largestRectangleArea(heights1)); // Expected output: 10

        int[] heights2 = {1};
        System.out.println(solution.largestRectangleArea(heights2)); // Expected output: 1

        int[] heights3 = {1, 2, 3, 4, 5};
        System.out.println(solution.largestRectangleArea(heights3)); // Expected output: 9

        int[] heights4 = {5, 4, 3, 2, 1};
        System.out.println(solution.largestRectangleArea(heights4)); // Expected output: 9

        int[] heights5 = {1, 1, 1, 1, 1};
        System.out.println(solution.largestRectangleArea(heights5)); // Expected output: 5
    }
}
