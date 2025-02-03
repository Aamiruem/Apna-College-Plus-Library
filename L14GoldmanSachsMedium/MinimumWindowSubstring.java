
// import java.util.HashMap;

// public class MinimumWindowSubstring {

//     public static String minWindow(String s, String t) {
//         if (s == null || t == null || s.length() < t.length()) {
//             return "";
//         }

//         // Frequency map for characters in t
//         HashMap<Character, Integer> tMap = new HashMap<>();
//         for (char c : t.toCharArray()) {
//             tMap.put(c, tMap.getOrDefault(c, 0) + 1);
//         }

//         // Sliding window
//         int left = 0, right = 0, requiredChars = tMap.size();
//         HashMap<Character, Integer> windowMap = new HashMap<>();
//         int minLen = Integer.MAX_VALUE;
//         int minLeft = 0;

//         while (right < s.length()) {
//             char rightChar = s.charAt(right);
//             windowMap.put(rightChar, windowMap.getOrDefault(rightChar, 0) + 1);

//             // If the current window has all the required characters, try to shrink it
//             while (windowMap.size() == requiredChars) {
//                 if (right - left + 1 < minLen) {
//                     minLen = right - left + 1;
//                     minLeft = left;
//                 }

//                 // Shrink the window
//                 char leftChar = s.charAt(left);
//                 windowMap.put(leftChar, windowMap.get(leftChar) - 1);
//                 if (windowMap.get(leftChar) == 0) {
//                     windowMap.remove(leftChar);
//                 }
//                 left++;
//             }

//             right++;
//         }

//         return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
//     }

//     public static void main(String[] args) {
//         String s = "ADOBECODEBANC";
//         String t = "ABC";
//         System.out.println("Minimum Window Substring: " + minWindow(s, t)); // Output: "BANC"
//     }
// }







import java.util.HashMap;

public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Frequency map for characters in t
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        // Sliding window
        int left = 0, right = 0, requiredChars = tMap.size();
        int formed = 0; // Number of unique characters formed in the current window
        HashMap<Character, Integer> windowMap = new HashMap<>();
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            windowMap.put(rightChar, windowMap.getOrDefault(rightChar, 0) + 1);

            // If the frequency of the current character in the window matches the frequency in t, increment formed
            if (tMap.containsKey(rightChar) && windowMap.get(rightChar).intValue() == tMap.get(rightChar).intValue()) {
                formed++;
            }

            // If the current window has all the required characters, try to shrink it
            while (left <= right && formed == requiredChars) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }

                // Shrink the window
                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                if (tMap.containsKey(leftChar) && windowMap.get(leftChar) < tMap.get(leftChar)) {
                    formed--;
                }
                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("Minimum Window Substring: " + minWindow(s, t)); // Expected Output: "BANC"
    }
}
