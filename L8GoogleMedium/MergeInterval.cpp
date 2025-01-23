#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class MergeInterval
{
public:
    vector<vector<int> > merge(vector<vector<int> > &intervals)
    {
        // Sort intervals based on the start time
        sort(intervals.begin(), intervals.end(), [](const vector<int> &a, const vector<int> &b)
            { return a[0] < b[0]; });

        vector<vector<int> > ans;

        for (const auto &interval : intervals)
        {
            // If the result is empty or the current interval does not overlap with the last one
            if (ans.empty() || ans.back()[1] < interval[0])
            {
                ans.push_back(interval);
            }
            else
            {
                // Merge the intervals
                ans.back()[1] = max(ans.back()[1], interval[1]);
            }
        }

        return ans;
    }
};

int main()
{
    MergeInterval mi;
    vector<vector<int> > intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

    vector<vector<int> > result = mi.merge(intervals);

    cout << "Merged Intervals: ";
    for (const auto &interval : result)
    {
        cout << "[" << interval[0] << ", " << interval[1] << "] ";
    }
    cout << endl;

    return 0;
}
