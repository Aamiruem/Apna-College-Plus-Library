
import java.util.ArrayList;
import java.util.List;

public class RobToBank {

    public static List<Integer> goodDaysToRobBank(int[] security, int time) {
        int size = security.length;
        int[] left = new int[size];  // Prefix for non-increasing sequence
        int[] right = new int[size]; // Prefix for non-decreasing sequence

        // Compute the `left` array
        for (int i = 1; i < size; i++) {
            if (security[i] <= security[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }

        // Compute the `right` array
        for (int i = size - 2; i >= 0; i--) {
            if (security[i] <= security[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }

        // Find all good days to rob the bank
        List<Integer> goodDays = new ArrayList<>();
        for (int i = time; i < size - time; i++) {
            if (left[i] >= time && right[i] >= time) {
                goodDays.add(i);
            }
        }

        return goodDays;
    }

    public static void main(String[] args) {
        int[] security = {5, 3, 3, 3, 5, 6, 2};
        int time = 2;
        List<Integer> goodDays = goodDaysToRobBank(security, time);
        System.out.println("Good days to rob the bank: " + goodDays);
    }
}
