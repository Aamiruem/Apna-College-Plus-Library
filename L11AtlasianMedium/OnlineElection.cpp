#include <bits/stdc++.h>
using namespace std;

class OnlineElection
{
    vector<pair<int, int> > v; // Stores (leader, time)

public:
    // Constructor
    OnlineElection(vector<int> &persons, vector<int> &times)
    {
        int leader = -1;
        int votes = 0;
        int n = times.size();
        unordered_map<int, int> ma; // Stores votes per candidate

        for (int i = 0; i < n; i++)
        {
            ma[persons[i]]++; // Increment vote count for the candidate
            int vote = ma[persons[i]];

            if (vote >= votes)
            { // If new vote count is greater or equal
                if (leader != persons[i])
                { // If new leader is different
                    leader = persons[i];
                    v.push_back({leader, times[i]});
                }
                votes = vote;
            }
        }
    }

    // Query function to find the leader at time t
    int query(int t)
    {
        int s = 0, e = v.size() - 1;
        int ans = -1;

        while (s <= e)
        {
            int mid = (s + e) / 2;
            if (v[mid].second <= t)
            {                       // If the stored time is <= query time
                ans = v[mid].first; // Update the answer
                s = mid + 1;        // Search in the right half
            }
            else
            {
                e = mid - 1; // Search in the left half
            }
        }
        return ans;
    }
};

int main()
{
    vector<int> persons = {0, 1, 1, 0, 0, 1, 0};
    vector<int> times = {0, 5, 10, 15, 20, 25, 30};

    OnlineElection obj(persons, times);

    // Example Queries
    cout << obj.query(3) << endl;  // Query at time 3
    cout << obj.query(17) << endl; // Query at time 17
    cout << obj.query(27) << endl; // Query at time 27
    cout << obj.query(37) << endl; // Query at time 37

    return 0;
}
