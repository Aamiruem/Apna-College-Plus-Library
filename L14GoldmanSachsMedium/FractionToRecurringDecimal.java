
import java.util.*;

public class FractionToRecurringDecimal {

    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0"; // If numerator is 0, result is 0
        }
        StringBuilder result = new StringBuilder();

        // Determine the sign of the result
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }

        // Convert numerator and denominator to long to handle overflow
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // Compute the integer part of the result
        result.append(num / den);
        long remainder = num % den;

        if (remainder == 0) {
            return result.toString(); // If no remainder, return the integer result
        }

        // Otherwise, process the fractional part
        result.append(".");
        Map<Long, Integer> remainderMap = new HashMap<>(); // Store remainder positions

        while (remainder != 0) {
            if (remainderMap.containsKey(remainder)) {
                // If remainder repeats, insert parentheses at the start of repetition
                result.insert(remainderMap.get(remainder), "(");
                result.append(")");
                break;
            }

            // Store the position of this remainder
            remainderMap.put(remainder, result.length());

            // Multiply remainder by 10 and append next digit
            remainder *= 10;
            result.append(remainder / den);
            remainder %= den;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1, 2));   // Output: "0.5"
        System.out.println(fractionToDecimal(2, 3));   // Output: "0.(6)"
        System.out.println(fractionToDecimal(4, 333)); // Output: "0.(012)"
        System.out.println(fractionToDecimal(-50, 8)); // Output: "-6.25"
    }
}
