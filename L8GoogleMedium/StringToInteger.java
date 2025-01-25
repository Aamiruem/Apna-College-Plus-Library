// public class StringToInteger {
//     public int myAtoi(String s) {
//         int i = 0;
//         int sign = 1;
//         long ans = 0;
//         while (i < s.length() && s.charAt(i) == ' ') {
//             i++;
//         }
//         if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
//             sign = s.charAt(i) == '+' ? 1 : -1;
//             i++;
//         }
//         while (i < s.length() && Character.isDigit(s.charAt(i))) {
//             int digit = s.charAt(i) - '0';
//             if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
//                 return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
//             }
//             ans = ans * 10 + digit;
//             i++;
//         }
//         return (int) ans * sign;
//     }
//     public static void main(String[] args) {
//         StringToInteger sti = new StringToInteger();
//         System.out.println(sti.myAtoi("42")); // Output: 42
//     }
// }





public class StringToInteger {
    public int myAtoi(String s) {
        int i = 0, ans = 0, sign = 1;
        // Skip leading whitespaces
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        // Check if the string is empty after removing spaces
        if (i == s.length()) return 0;

        // Handle optional sign
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }

        // Convert digits to integer
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // Check for overflow
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            ans = ans * 10 + digit;
            i++;
        }

        return ans * sign;
    }

    public static void main(String[] args) {
        StringToInteger obj = new StringToInteger();

        // Test cases
        System.out.println("Number of distinct ways to integer : " + obj.myAtoi("42")); // Output: 42
        System.out.println(obj.myAtoi("   -42")); // Output: -42
        System.out.println(obj.myAtoi("4193 with words")); // Output: 4193
        System.out.println(obj.myAtoi("words and 987")); // Output: 0
        System.out.println(obj.myAtoi("-91283472332")); // Output: -2147483648
    }
}
