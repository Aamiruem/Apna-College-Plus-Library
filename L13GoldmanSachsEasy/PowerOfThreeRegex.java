
// public class PowerOfThree {

//     public static boolean isPowerOfThree(int n) {
//         if (n <= 0) {
//             return false;
//         }
//         while (n % 3 == 0) {
//             n /= 3;
//         }
//         return n == 1;
//     }

//     public static void main(String[] args) {
//         int num = 27; // Hardcoded input
//         System.out.println(isPowerOfThree(num)); // Output: true
//     }
// }













// Explanation
// Convert n to base 3

// Integer.toString(n, 3) converts n into a base-3 string.
// Example:
// 27 → "1000"
// 9 → "100"
// 10 → "101"
// Match a Power of Three Pattern (^10*$)

// ^10*$ is a regular expression that:
// ^ → Ensures the string starts with "1".
// 0* → Ensures the rest of the string consists of zero or more "0" characters.
// $ → Ensures it ends at that point.
// This pattern ensures that the number is a power of 3 because:
// 1 in base-3 is 3⁰
// 10 in base-3 is 3¹
// 100 in base-3 is 3²
// 1000 in base-3 is 3³
// etc.

public class PowerOfThreeRegex {
    public static void main(String[] args) {
        int n = 27; // Test value
        System.out.print(Integer.toString(n, 3).matches("^10*$")); // Output: true
    }
}
// Outputs
// n	Base-3 Representation	Matches ^10*$?	Output
// 1	1	✅ Yes	true
// 3	10	✅ Yes	true
// 9	100	✅ Yes	true
// 27	1000	✅ Yes	true
// 10	101	❌ No	false
// Pros & Cons
// ✅ Very concise and elegant.
// ✅ No loops, no recursion, no math operations.
// ❌ Slower than direct math-based solutions due to string conversion & regex matching.
