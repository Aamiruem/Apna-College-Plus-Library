#include <bits/stdc++.h>
using namespace std;

int main()
{
    vector<int> temp = {1, -10, 7, 13, 6, 8};
    int n = temp.size();
    int k = 5;

    vector<int> v(n, 0);

    for (int i = 0; i < n; i++)
    {
        int val = (temp[i] % k + k) % k;
        if (val < n)
        {
            v[val]++;
        }
    }

    int ans = n;

    for (int i = 0; i < n; i++)
    {
        if (v[i] == 0)
        {
            ans = i;
            break;
        }
        else
        {
            v[i]--;
        }

        if (v[i] > 0 && i + k < n)
        {
            v[i + k] += v[i];
        }
    }

    cout << ans << endl;

    return 0;
}
