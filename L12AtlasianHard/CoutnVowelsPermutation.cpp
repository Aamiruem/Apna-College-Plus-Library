#include <bits/stdc++.h>
using namespace std;

int main()
{
    const int MOD = 1e9 + 7;
    int n = 5; // Change this value to compute for different lengths

    long aCount = 1; // 'a' can follow 'e', 'i', 'u'
    long eCount = 1; // 'e' can follow 'a', 'i'
    long iCount = 1; // 'i' can follow 'e', 'o'
    long oCount = 1; // 'o' can follow 'i'
    long uCount = 1; // 'u' can follow 'i', 'o'

    for (int i = 2; i <= n; i++)
    {
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
    cout << ans << endl;

    return 0;
}
