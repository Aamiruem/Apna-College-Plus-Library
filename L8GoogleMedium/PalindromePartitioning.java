// import java.util.ArrayList;
// import java.util.LinkedList;
// import java.util.List;

// public class PalindromePartitioning {
//     List<List<String>> ans = new ArrayList<>();
    
//     public List<List<String>> partition(String s) {
//         dfs(s, new LinkedList<>());
//         return ans;
//     }
    
//     public void dfs(String s, List<String> path) {
//         if (s.length() == 0) {
//             if (!path.isEmpty()) {
//                 ans.add(path);
//                 return;
//             }
//         }
//         for (int i = 1; i <= s.length(); i++) {
//             if (isPalindrome(s.substring(0, i + 1))) {
//                 List<String> copy = new LinkedList<>(path);
//                 copy.add(s.substring(0, i + 1));
//                 dfs(s.substring(i + 1), copy);
//             }
//         }
//     }
                
//     public boolean isPalindrome(String s) {
//         int start = 0;
//         int end = s.length() - 1;
//         while (start < end) {
//             if (s.charAt(start) != s.charAt(end)) {
//                 return false;
//             }
//             start++;
//             end--;
//         }
//         return true;
//     }
//     public static void main(String[] args) {
//         PalindromePartitioning p = new PalindromePartitioning();
//         String s = "aab";
//         List<List<String>> result = p.partition(s);
//         System.out.println(result);

//     }
// }











// import java.util.ArrayList;
// import java.util.LinkedList;
// import java.util.List;

// public class PalindromePartitioning {
//     List<List<String>> ans = new ArrayList<>();
    
//     public List<List<String>> partition(String s) {
//         dfs(s, new LinkedList<>());
//         return ans;
//     }
    
//     public void dfs(String s, List<String> path) {
//         if (s.length() == 0) {
//             ans.add(new ArrayList<>(path)); // Add a copy of the current path to the result
//             return;
//         }
//         for (int i = 0; i < s.length(); i++) {
//             String prefix = s.substring(0, i + 1); // Take the prefix
//             if (isPalindrome(prefix)) {
//                 path.add(prefix); // Add the prefix to the path
//                 dfs(s.substring(i + 1), path); // Explore further with the remaining string
//                 path.remove(path.size() - 1); // Backtrack by removing the last added element
//             }
//         }
//     }
                
//     public boolean isPalindrome(String s) {
//         int start = 0;
//         int end = s.length() - 1;
//         while (start < end) {
//             if (s.charAt(start) != s.charAt(end)) {
//                 return false;
//             }
//             start++;
//             end--;
//         }
//         return true;
//     }

//     public static void main(String[] args) {
//         PalindromePartitioning p = new PalindromePartitioning();
//         String s = "aab";
//         List<List<String>> result = p.partition(s);
//         System.out.println(result); // Expected output: [[a, a, b], [aa, b]]
//     }
// }















import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    List<List<String>> ans;

    public List<List<String>> partition(String s) {
        int len = s.length();
        ans = new ArrayList<>();
        int[][] dp = new int[len][len]; // dp[i][j] == 1 means substring s[i...j] is a palindrome
        recur(new ArrayList<>(), 0, s, dp);
        return ans;
    }

    public void recur(List<String> curr, int i, String s, int[][] dp) {
        if (i == s.length()) {
            ans.add(new ArrayList<>(curr)); // Add a copy of the current list to the result
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (dp[i][j] == 1 || isPalindrome(s, i, j, dp)) {
                dp[i][j] = 1; // Mark this substring as a palindrome
                curr.add(s.substring(i, j + 1)); // Add the current palindrome to the list
                recur(curr, j + 1, s, dp); // Recur for the next part of the string
                curr.remove(curr.size() - 1); // Backtrack by removing the last added palindrome
            }
        }
    }

    public boolean isPalindrome(String s, int start, int end, int[][] dp) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning p = new PalindromePartitioning();
        String s = "aab";
        List<List<String>> result = p.partition(s);
        System.out.println(result); // Expected output: [[a, a, b], [aa, b]]

        // Test case with a longer string
        String s2 = "a";
        List<List<String>> result2 = p.partition(s2);
        System.out.println(result2); // Expected output: [[a]]

        // Test case with a string containing duplicate characters
        String s3 = "racecar";
        List<List<String>> result3 = p.partition(s3);
        System.out.println(result3); // Expected output: [[r, a, c, e, c, a, r]]
        
    }
}
