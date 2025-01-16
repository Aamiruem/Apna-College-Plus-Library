// public class ValidPalindrome {
//     public boolean isValidPalindrome(String s) {
//         int start = 0, last = s.length() - 1;
//         while (start <= last) {
//             if (s.charAt(start) != s.charAt(last)) {
//                 return false;
//             }
//             start++;
//             last--;
//         }
//         return true;
//     }
    
//     public static void main(String[] args) {
//         ValidPalindrome vp = new ValidPalindrome();
//         String s = "abcba";
//         System.out.println(vp.isValidPalindrome(s)); // Output: true
//     }
// }


public class ValidPalindrome {

    public boolean isValidPalindrome(String s) {
        int start = 0, last = s.length() - 1;
        while (start <= last) {
            // Skip non-alphanumeric characters
            while (start < last && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }
            while (start < last && !Character.isLetterOrDigit(s.charAt(last))) {
                last--;
            }
            // Compare characters (case-insensitive)
            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(last))) {
                return false;
            }
            start++;
            last--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        String s = "A man, a plan, a canal: Panama";
        System.out.println(vp.isValidPalindrome(s)); // Output: true
    }
}
