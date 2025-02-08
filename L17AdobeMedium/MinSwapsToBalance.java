// Approach:
// Count imbalanced brackets

// Traverse the string and keep track of unmatched closing brackets (]).
// If a closing bracket (]) appears before an opening bracket ([), it contributes to imbalance.
// Formula for swaps

// Every swap fixes two misplaced brackets (]] → []).
// Minimum swaps needed:

// swaps= imbalance+1/2

// Java Code:
// java
// Copy code





// public class MinSwapsToBalance {

//     public int minSwaps(String s) {
//         int imbalance = 0, size = 0;

//         for (char ch : s.toCharArray()) {
//             if (ch == '[') {
//                 size++; // Increase count of open brackets
//             } else {
//                 if (size > 0) {
//                     size--; // Match closing bracket with an open bracket
//                 } else {
//                     imbalance++; // Unmatched closing bracket found
//                 }
//             }
//         }

//         return (imbalance + 1) / 2; // Minimum swaps needed
//     }

//     public static void main(String[] args) {
//         MinSwapsToBalance solution = new MinSwapsToBalance();

//         String s = "]]][[";
//         int minSwaps = solution.minSwaps(s);

//         System.out.println("Minimum Swaps: " + minSwaps);
//     }
// }






// Explanation
// Example 1
// Input:
// java
// Copy code
// s = "]]][["
// Step-by-Step Execution:
// Character	Open Count (size)	Unmatched Closing (imbalance)
// ]	0	1
// ]	0	2
// ]	0	3
// [	1	3
// [	2	3
// Calculation:

// Swaps= (3+1)/2 = 2 ​

// s = "[]][]["
// Step-by-Step Execution:
// Character	Open Count (size)	Unmatched Closing (imbalance)
// [	1	0
// ]	0	0
// ]	0	1
// [	1	1
// ]	0	1
// [	1	1
// Calculation:
// Swaps

// Minimum Swaps: 1
// Time Complexity Analysis
// Sorting is NOT needed → O(n) time complexity
// Space Complexity: O(1) (only a few integer variables used)
// This solution is efficient and optimal for balancing bracket strings. Let me know if you need further clarifications!







public class MinSwapsToBalance {

    public static void main(String[] args) { // Fixed "Stringll" to "String[]"
        String s = "]]][[["; // Fixed incorrect input string
        int size = 0, imbalance = 0;

        for (char ch : s.toCharArray()) { // Added missing parentheses ()
            if (ch == '[') {
                size++; // Increase count of open brackets
            } else {
                if (size > 0) {
                    size--; // Match closing bracket with an open bracket
                } else {
                    imbalance++; // Unmatched closing bracket found
                }
            }
        }

        int minSwaps = (imbalance + 1) / 2; // Minimum swaps needed
        System.out.println("Minimum Swaps: " + minSwaps); // Fixed "printin" to "println"
    }
}
