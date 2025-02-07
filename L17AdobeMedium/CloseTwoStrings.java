
// import java.util.*;

// public class CloseTwoStrings {

//     public static boolean closeStrings(String s1, String s2) {
//         // If the strings have different lengths, they can't be close
//         if (s1.length() != s2.length()) {
//             return false;
//         }

//         int[] a = new int[26];  // Frequency count for s1
//         int[] b = new int[26];  // Frequency count for s2

//         // Count the frequencies of each character in s1 and s2
//         for (int i = 0; i < s1.length(); i++) {
//             a[s1.charAt(i) - 'a']++;
//             b[s2.charAt(i) - 'a']++;
//         }

//         // If the sets of characters in s1 and s2 are not the same, return false
//         for (int i = 0; i < 26; i++) {
//             if ((a[i] == 0 && b[i] > 0) || (a[i] > 0 && b[i] == 0)) {
//                 return false;
//             }
//         }

//         // Sort the frequency arrays and check if they are equal
//         Arrays.sort(a);
//         Arrays.sort(b);

//         return Arrays.equals(a, b);  // If the sorted frequencies are equal, return true
//     }

//     public static void main(String[] args) {
//         // Get user input for strings
//         try (Scanner scanner = new Scanner(System.in)) {
//             // Get user input for strings
//             System.out.print("Enter string s1: ");
//             String s1 = scanner.nextLine();
//             System.out.print("Enter string s2: ");
//             String s2 = scanner.nextLine();
//             // Check if the strings are close
//             boolean result = closeStrings(s1, s2);
//             // Output the result
//             if (result) {
//                 System.out.println("The strings are close.");
//             } else {
//                 System.out.println("The strings are not close.");
//             }
//             // Close the scanner
//         }
//     }
// }









import java.util.*;

public class CloseTwoStrings {
    
    public static boolean closeStrings(String s1, String s2) {
        // Step 1: If the strings have different lengths, they cannot be close
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] a = new int[26];  // Frequency count for characters in s1
        int[] b = new int[26];  // Frequency count for characters in s2

        // Step 2: Count the frequency of each character in both strings
        for (int i = 0; i < s1.length(); i++) {
            a[s1.charAt(i) - 'a']++;  // Increment the frequency of s1's character
            b[s2.charAt(i) - 'a']++;  // Increment the frequency of s2's character
        }

        // Step 3: Check if the sets of characters in s1 and s2 are the same
        // We need to ensure that for every character, both strings have it or do not have it
        for (int i = 0; i < 26; i++) {
            // If one string has a character and the other doesn't, return false
            if ((a[i] == 0 && b[i] > 0) || (a[i] > 0 && b[i] == 0)) {
                return false;
            }
        }

        // Step 4: Sort the frequency arrays and compare them
        Arrays.sort(a);
        Arrays.sort(b);

        // Step 5: If the frequency distributions are identical, return true
        return Arrays.equals(a, b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input strings from the user
        System.out.print("Enter string s1: ");
        String s1 = scanner.nextLine();
        System.out.print("Enter string s2: ");
        String s2 = scanner.nextLine();

        // Step 6: Check if the strings are close and display the result
        boolean result = closeStrings(s1, s2);

        if (result) {
            System.out.println("The strings are close.");
        } else {
            System.out.println("The strings are not close.");
        }

        scanner.close();  // Close the scanner to prevent memory leaks
    }
}
