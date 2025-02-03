
import java.util.Scanner;

public class BeautifulArrangements {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] vis = new int[n + 1];
            
            // Initialize the visited array properly
            for (int i = 0; i < n + 1; i++) {
                vis[i] = 0;
            }
            
            int ans = backtrack(vis, 1, n);
            System.out.println(ans);
        }
    }

    public static int backtrack(int[] vis, int i, int n) {
        if (i > n) {
            return 1;  // Base case: If all positions are filled, count as 1 valid arrangement
        }
        int cnt = 0;
        for (int x = 1; x <= n; x++) {
            if (vis[x] == 0 && (x % i == 0 || i % x == 0)) {  // Check valid placement
                vis[x] = 1;
                cnt += backtrack(vis, i + 1, n);
                vis[x] = 0;  // Backtrack
            }
        }
        return cnt;
    }
}
