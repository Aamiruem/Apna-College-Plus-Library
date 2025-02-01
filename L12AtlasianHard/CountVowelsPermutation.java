
public class CountVowelsPermutation {

    public static void main(String[] args) {
        final int MOD = 1_000_000_007;
        int n = 5; // Change this value for different lengths

        long aCount = 1; // 'a' can follow 'e', 'i', 'u'
        long eCount = 1; // 'e' can follow 'a', 'i'
        long iCount = 1; // 'i' can follow 'e', 'o'
        long oCount = 1; // 'o' can follow 'i'
        long uCount = 1; // 'u' can follow 'i', 'o'

        for (int i = 2; i <= n; i++) {
            long aCountNew = (eCount + iCount + uCount) % MOD;
            long eCountNew = (aCount + iCount) % MOD;
            long iCountNew = (eCount + oCount) % MOD;
            long oCountNew = iCount % MOD;
            long uCountNew = (iCount + oCount) % MOD;

            aCount = aCountNew;
            eCount = eCountNew;
            iCount = iCountNew;
            oCount = oCountNew;
            uCount = uCountNew;
        }

        long ans = (aCount + eCount + iCount + oCount + uCount) % MOD;
        System.out.println(ans);
    }
}
