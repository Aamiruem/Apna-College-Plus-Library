#include <bits/stdc++.h>
using namespace std;

// Custom comparator for sorting by end time
bool cmp(vector<int> &a, vector<int> &b)
{
    return a[1] < b[1];
}

int main()
{
    vector<int> start = {1, 2, 3, 4, 6};
    vector<int> end = {3, 5, 10, 6, 9};
    vector<int> profit = {20, 20, 100, 70, 60};

    int n = profit.size();
    vector<vector<int> > finalJobs;

    for (int i = 0; i < n; i++)
    {
        finalJobs.push_back({start[i], end[i], profit[i]});
    }

    // Sort jobs by end time
    sort(finalJobs.begin(), finalJobs.end(), cmp);

    vector<int> dp(n);
    dp[0] = finalJobs[0][2];

    for (int i = 1; i < n; i++)
    {
        int s = 0, e = i - 1, ans = -1;

        // Binary search for the last non-overlapping job
        while (s <= e)
        {
            int mid = (s + e) / 2;
            if (finalJobs[mid][1] <= finalJobs[i][0])
            {
                ans = mid;
                s = mid + 1;
            }
            else
            {
                e = mid - 1;
            }
        }

        // Choose max between including the current job or not
        if (ans == -1)
        {
            dp[i] = max(dp[i - 1], finalJobs[i][2]);
        }
        else
        {
            dp[i] = max(dp[i - 1], finalJobs[i][2] + dp[ans]);
        }
    }

    cout <<"Maximum Profit: "<< dp[n - 1] << endl; // Maximum profit
    return 0;
}
