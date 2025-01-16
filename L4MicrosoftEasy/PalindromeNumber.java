
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int rev = 0;
        int temp = x;
        while (temp != 0) {
            int digit = temp % 10;
            rev = rev * 10 + digit;
            temp = temp / 10;
        }
        // if (rev == x) {
        //     return true;
        // }
        // else {
        //     return false;
        // }
        return x == rev;
    }
    public static void main(String[] args) {
        PalindromeNumber p = new PalindromeNumber();
        int x = 121;
        System.out.println(p.isPalindrome(x));
    }
}
