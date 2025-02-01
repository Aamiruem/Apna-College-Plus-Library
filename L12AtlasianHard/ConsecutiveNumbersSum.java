
public class ConsecutiveNumbersSum {

    public static int consecutiveNumbersSum(int n) {
        int count = 0;
        for (int k = 1; k * (k - 1) / 2 < n; k++) {
            if ((n - k * (k - 1) / 2) % k == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 9; // Example input
        System.out.println("Ways to express " + n + " as a sum of consecutive numbers: " + consecutiveNumbersSum(n));
    }
}
