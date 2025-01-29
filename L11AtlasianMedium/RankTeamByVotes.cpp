#include <bits/stdc++.h>
using namespace std;

unordered_map<char, vector<int> > track;

// Custom comparator function to sort candidates based on their ranks
bool cmp(char a, char b)
{
    int n = track[a].size();
    for (int j = 0; j < n; j++)
    {
        if (track[a][j] > track[b][j])
            return true;
        else if (track[a][j] < track[b][j])
            return false;
    }
    return a < b; // If ranks are the same, sort lexicographically
}

int main()
{
    vector<string> votes = {"ABC", "ACB", "ABC", "ACB", "ACB"};
    int n = votes[0].size();

    // Initialize the tracking map with zeros
    for (char c : votes[0])
    {
        track[c] = vector<int>(n, 0);
    }

    // Count the votes for each position
    for (auto &vote : votes)
    {
        for (int j = 0; j < n; j++)
        {
            track[vote[j]][j]++;
        }
    }

    // Create a string containing all unique candidates
    string ans = votes[0];

    // Sort candidates based on the custom comparator
    sort(ans.begin(), ans.end(), cmp);

    // Print the result
    cout << ans << endl;

    return 0;
}
