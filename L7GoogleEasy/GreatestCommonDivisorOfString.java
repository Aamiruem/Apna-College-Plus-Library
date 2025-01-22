// public class GreatestCommonDivisorOfString {
//     public String gcdOfStrings(String str1, String str2) {
//         if (str1.length() > str2.length()) {
//             return gcdOfStrings(str2, str1);
//         } else if (!str1.startsWith(str2)) {
//             return "";
//         } else if (str2.isEmpty()) {
//             return str1;
//         } else {
//             return gcdOfStrings(str1.substring(str2.length()), str2);
//         }
//     }
    
//     public static void main(String[] args) {
//         GreatestCommonDivisorOfString g = new GreatestCommonDivisorOfString();
//         System.out.println(g.gcdOfStrings("ABCABC", "ABC")); // Output: "ABC"
//         System.out.println(g.gcdOfStrings("ABABAB", "ABAB")); // Output: "AB"
//         System.out.println(g.gcdOfStrings("LEET", "CODE")); // Output: ""

//         // Test with large strings
//         String str1 = "a".repeat(100000);
//         String str2 = "b".repeat(100000);
//         System.out.println(g.gcdOfStrings(str1, str2));
//     }
// }











public class GreatestCommonDivisorOfString {

    public String gcdOfStrings(String str1, String str2) {
        if (!str1.startsWith(str2)) {
            return "";
        } else if (str2.isEmpty()) {
            return str1;
        } else {
            return gcdOfStrings(str2, str1.substring(str2.length()));
        }
    }

    public static void main(String[] args) {
        GreatestCommonDivisorOfString g = new GreatestCommonDivisorOfString();
        System.out.println(g.gcdOfStrings("ABCABC", "ABC")); // Output: "ABC"
        System.out.println(g.gcdOfStrings("ABABAB", "ABAB")); // Output: "AB"
        System.out.println(g.gcdOfStrings("LEET", "CODE")); // Output: ""

    }
}
