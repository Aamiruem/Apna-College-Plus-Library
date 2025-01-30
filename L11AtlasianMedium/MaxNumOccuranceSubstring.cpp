#include <bits/stdc++.h>
using namespace std;

int main()
{
    string s = "aababcaab";
    int maxuniq = 2;
    int minsize = 3;
    int maxsize = 4;
    int n = s.size();

    unordered_map<char, int> freq;
    unordered_map<string, int> substr_count;

    for (int i = 0; i < minsize; i++)
    {
        freq[s[i]]++;
    }

    string temp = s.substr(0, minsize);
    if (freq.size() <= maxuniq)
    {
        substr_count[temp]++;
    }

    int ans = 1;
    for (int i = minsize; i < n; i++)
    {
        char c = s[i];
        char remove = s[i - minsize];

        if (freq[remove] == 1)
        {
            freq.erase(remove);
        }
        else
        {
            freq[remove]--;
        }

        freq[c]++;

        if (freq.size() <= maxuniq)
        {
            temp = s.substr(i - minsize + 1, minsize);
            substr_count[temp]++;
            ans = max(ans, substr_count[temp]);
        }
    }

    cout << ans << endl;
    return 0;
}
