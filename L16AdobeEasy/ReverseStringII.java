public class ReverseStringII {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        
        for (int i = 0; i < n; i += 2 * k) {
            int left = i;
            int right = Math.min(i + k - 1, n - 1); // Ensure we don't go out of bounds
            reverse(arr, left, right);
        }
        return new String(arr);
    }

    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        ReverseStringII solution = new ReverseStringII();
        String s = "abcdefg";
        int k = 2;
        System.out.println("Reversed string: " + solution.reverseStr(s, k)); // Output: "bacdfeg"
    }
}






// Time Complexity:y

// O(n) – We process each character in the string once.

// Space Complexity:

// O(1) – No extra space is used (in-place modification).

// Example
// Input:

// Copy
// s = "abcdefg", k = 2
// Steps:

// Process the first 2k = 4 characters:

// Reverse the first k = 2 characters: ab → ba.

// Leave the next k = 2 characters as is: cd.

// Result after first chunk: bacd.

// Process the remaining 3 characters:

// Reverse the first k = 2 characters: ef → fe.

// Leave the remaining 1 character as is: g.

// Result after second chunk: feg.

// Final output: bacdfeg.

// Output:

// Copy
// "bacdfeg"
