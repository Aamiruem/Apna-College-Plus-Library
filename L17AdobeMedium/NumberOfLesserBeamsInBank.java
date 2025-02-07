
import java.util.*;

public class NumberOfLesserBeamsInBank {

    public int numberOfBeams(List<String> bank) {
        List<Integer> ans = new ArrayList<>();

        for (String row : bank) {
            int c = (int) row.chars().filter(ch -> ch == '1').count();
            if (c != 0) {
                ans.add(c);
            }
        }

        int sum = 0;
        if (ans.size() <= 1) {
            return 0;
        }

        for (int i = 0; i < ans.size() - 1; i++) { // Fixed loop condition
            sum += ans.get(i) * ans.get(i + 1); // Fixed incorrect index usage
        }

        return sum; // Moved return statement outside the loop
    }

    public static void main(String[] args) {
        List<String> bank = Arrays.asList(
                "00110",
                "10110",
                "01110",
                "11110"
        );

        NumberOfLesserBeamsInBank solution = new NumberOfLesserBeamsInBank();
        int result = solution.numberOfBeams(bank);

        System.out.println("Number of beams: " + result);
    }
}
