
// import java.util.*;

// public class MaximumProfitJobScheduling {

//     public static void main(String[] args) {
//         int[] start = {1, 2, 3, 4, 6};
//         int[] end = {3, 5, 10, 6, 9};
//         int[] profit = {20, 20, 100, 70, 60};

//         int n = profit.length;
//         int[][] jobs = new int[n][3];

//         for (int i = 0; i < n; i++) {
//             jobs[i] = new int[]{start[i], end[i], profit[i]};
//         }

//         // Sort jobs by end time
//         Arrays.sort(jobs, Comparator.comparingInt(a -> a[1]));

//         int[] dp = new int[n];
//         dp[0] = jobs[0][2];

//         for (int i = 1; i < n; i++) {
//             int s = 0, e = i - 1, ans = -1;

//             // Binary search for the last non-overlapping job
//             while (s <= e) {
//                 int mid = (s + e) / 2;
//                 if (jobs[mid][1] <= jobs[i][0]) {
//                     ans = mid;
//                     s = mid + 1;
//                 } else {
//                     e = mid - 1;
//                 }
//             }

//             // Choose max between including the current job or not
//             if (ans == -1) {
//                 dp[i] = Math.max(dp[i - 1], jobs[i][2]);
//             } else {
//                 dp[i] = Math.max(dp[i - 1], jobs[i][2] + dp[ans]);
//             }
//         }

//         System.out.println(dp[n - 1]); // Maximum profit
//     }
// }











import java.util.*;

public class MaximumProfitJobScheduling {

    public static void main(String[] args) {
        int[] start = {1, 2, 3, 4, 6};
        int[] end = {3, 5, 10, 6, 9};
        int[] profit = {20, 20, 100, 70, 60};
        int n = profit.length;

        List<List<Integer>> jobs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> job = new ArrayList<>();
            job.add(start[i]);
            job.add(end[i]);
            job.add(profit[i]);
            jobs.add(job);
        }

        // Sort jobs by end time
        jobs.sort(Comparator.comparingInt(a -> a.get(1)));

        int[] dp = new int[n];
        dp[0] = jobs.get(0).get(2);

        for (int i = 1; i < n; i++) {
            int s = 0, e = i - 1, ans = -1;

            // Binary search for the last non-overlapping job
            while (s <= e) {
                int mid = (s + e) / 2;
                if (jobs.get(mid).get(1) <= jobs.get(i).get(0)) {
                    ans = mid;
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }

            // Choose max between including the current job or not
            if (ans == -1) {
                dp[i] = Math.max(dp[i - 1], jobs.get(i).get(2));
            } else {
                dp[i] = Math.max(dp[i - 1], jobs.get(i).get(2) + dp[ans]);
            }
        }

        System.out.println(dp[n - 1]); // Maximum profit
    }
}
