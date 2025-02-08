
import java.util.Arrays;
import java.util.Scanner;

public class StringCanBreakOtherString {

    public static boolean checkIfCanBreak(String s1, String s2) {
        int n = s1.length();

        // Step 1: Sort both strings
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        boolean s1CanBreakS2 = true;
        boolean s2CanBreakS1 = true;

        // Step 2: Compare character by character
        for (int i = 0; i < n; i++) {
            if (arr1[i] < arr2[i]) {
                s1CanBreakS2 = false;
            }
            if (arr2[i] < arr1[i]) {
                s2CanBreakS1 = false;
            }
        }

        // Step 3: Return true if either condition is met
        return s1CanBreakS2 || s2CanBreakS1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User input
        System.out.print("Enter first string: ");
        String s1 = scanner.nextLine();
        System.out.print("Enter second string: ");
        String s2 = scanner.nextLine();

        // Check if one string can break another
        boolean result = checkIfCanBreak(s1, s2);

        // Output result
        if (result) {
            System.out.println("One string can break the other.");
        } else {
            System.out.println("Neither string can break the other.");
        }

        scanner.close();
    }
}
