
import java.util.Scanner;

public class SumOfSquareNumbers {

    public static boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }

        long left = 0;
        long right = (long) Math.sqrt(c);

        while (left <= right) {
            long sum = left * left + right * right;

            if (sum == c) {
                return true;
            } else if (sum < c) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int c;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a number: ");
            c = scanner.nextInt();
        }

        if (judgeSquareSum(c)) {
            System.out.println("Yes, " + c + " can be expressed as the sum of two squares.");
        } else {
            System.out.println("No, " + c + " cannot be expressed as the sum of two squares.");
        }
    }
}
