public class SmallestMissingInteger {
    public static void main(String[] args) {
        int[] temp = {1, -10, 7, 13, 6, 8};
        int n = temp.length;
        int k = 5;

        int[] v = new int[n];

        // Compute frequency of (temp[i] % k + k) % k
        for (int i = 0; i < n; i++) {
            int val = (temp[i] % k + k) % k;
            if (val < n) {
                v[val]++;
            }
        }

        int ans = n;

        for (int i = 0; i < n; i++) {
            if (v[i] == 0) {
                ans = i;
                break;
            } else {
                v[i]--;
            }

            if (v[i] > 0 && i + k < n) {
                v[i + k] += v[i];
            }
        }

        System.out.println(ans);
    }
}
