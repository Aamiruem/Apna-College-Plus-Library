#include <bits/stdc++.h>
using namespace std;
int main()
{
    vector<pair<int, int> > logs(5);
    logs[0] = {0, 5};
    logs[1] = {1, 2};
    logs[2] = {0, 2};
    logs[3] = {0, 5};
    logs[4] = {1, 3};

    unordered_map<int, unordered_set<int> > track;
    for (auto log : logs)
    {
        track[log.first].insert(log.second);
    }

    int k = 5;
    vector<int> ans(k);
    for (auto &uam : track)
    {
        int uam_ans = uam.second.size();
        ans[uam_ans - 1]++;
    }

    for (int i = 0; i < k; ++i)
    {
        cout << ans[i] << " ";
    }
    return 0;
}
