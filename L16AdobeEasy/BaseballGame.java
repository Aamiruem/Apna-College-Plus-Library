
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    public int calPoints(List<String> ops) {
        List<Integer> ans = new ArrayList<>();

        for (String op : ops) {
            if (op.equals("C")) {
                if (!ans.isEmpty()) {
                    ans.remove(ans.size() - 1);  // Remove last valid score
                }
            } else if (op.equals("D")) {
                if (!ans.isEmpty()) {
                    ans.add(2 * ans.get(ans.size() - 1));  // Double last score
                }
            } else if (op.equals("+")) {
                if (ans.size() >= 2) {
                    int a = ans.get(ans.size() - 1);
                    int b = ans.get(ans.size() - 2);
                    ans.add(a + b);  // Sum of last two scores
                }
            } else {
                ans.add(Integer.valueOf(op));  // Convert string to integer
            }
        }

        int sum = 0;
        for (int score : ans) {
            sum += score;  // Calculate total score
        }

        return sum;
    }

    public static void main(String[] args) {
        BaseballGame game = new BaseballGame();
        List<String> ops = new ArrayList<>();
        ops.add("5");
        ops.add("2");
        ops.add("C");
        ops.add("D");
        ops.add("+");

        System.out.println("Final Score: " + game.calPoints(ops));
    }
}
