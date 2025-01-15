
// public class RaceCar {

//     public static int raceCar(int target) {
//         int[] dp = new int[target + 1];

//         for (int i = 1; i <= target; i++) {
//             dp[i] = Integer.MAX_VALUE;
//             int n = 1;
//             while ((1 << n) - 1 < i) {
//                 n++;
//             }

//             // Case 1: Exact match with (2^n - 1)
//             if ((1 << n) - 1 == i) {
//                 dp[i] = n;
//                 continue;
//             }

//             // Case 2: Overshoot and reverse
//             dp[i] = Math.min(dp[i], n + 1 + dp[(1 << n) - 1 - i]);

//             // Case 3: Undershoot and reverse
//             for (int m = 0; m < n - 1; m++) {
//                 dp[i] = Math.min(dp[i], n + m + 1 + dp[i - ((1 << (n - 1)) - (1 << m))]);
//             }
//         }

//         return dp[target];
//     }

//     public static void main(String[] args) {
//         int target = 3;
//         System.out.println(raceCar(target)); // Output: 2
//     }
// }













public class RaceCar {

    public static int racecar(int target) {
        int[] dp = new int[target + 1];

        for (int i = 1; i <= target; i++) {
            dp[i] = Integer.MAX_VALUE;
            int n = 1;
            while (Math.pow(2, n) - 1 < i) {
                n++;
            }

            // Case 1: Exact match with (2^n - 1)
            if (Math.pow(2, n) - 1 == i) {
                dp[i] = n;
                continue;
            }

            // Case 2: Overshoot and reverse
            dp[i] = Math.min(dp[i], n + 1 + dp[(int)(Math.pow(2, n) - 1 - i)]);

            // Case 3: Undershoot and reverse
            for (int m = 0; m < n - 1; m++) {
                dp[i] = Math.min(dp[i], n + m + 1 + dp[i - (int)(Math.pow(2, n - 1) - Math.pow(2, m))]);
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        int target = 3;
        System.out.println(racecar(target)); // Output: 2
    }
}
