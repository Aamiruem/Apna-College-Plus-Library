#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution
{
public:
    int maximumBags(vector<int> &c, vector<int> &r, int add)
    {
        vector<int> diff;
        int count = 0;
        int n = r.size();

        // Calculate the difference between current capacity and required capacity for each bag
        for (int i = 0; i < n; i++)
        {
            diff.push_back(c[i] - r[i]);
        }

        // Sort the differences to process the smallest first (optimal for maximizing bags filled)
        sort(diff.begin(), diff.end());

        // Try to fill the bags that have the smallest difference first
        for (int i = 0; i < n; i++)
        {
            if (diff[i] <= add)
            {
                add -= diff[i]; // Subtract the used capacity
                count++;        // Count this bag as filled
            }
        }

        return count;
    }
};

int main()
{
    Solution solution;
    vector<int> c = {13, 5, 7}; // Current capacities
    vector<int> r = {1, 2, 3};  // Required capacities
    int add = 5;                // Additional capacity we can add

    int result = solution.maximumBags(c, r, add);
    cout << "Maximum number of bags that can be filled: " << result << endl;

    return 0;
}
