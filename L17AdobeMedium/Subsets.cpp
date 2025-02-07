#include <iostream>
#include <vector>

using namespace std;

class Solution
{
public:
    vector<vector<int> > subsets(vector<int> &nums)
    {
        vector<vector<int> > subs = {{}};

        for (int num : nums)
        {
            int n = subs.size();
            for (int i = 0; i < n; i++)
            {
                vector<int> temp = subs[i]; // Copy existing subset
                temp.push_back(num);        // Add current number
                subs.push_back(temp);       // Store new subset
            }
        }
        return subs;
    }
};

int main()
{
    Solution solution;
    vector<int> nums = {1, 2, 3};
    vector<vector<int> > subsets = solution.subsets(nums);

    cout << "Subsets:" << endl;
    for (const auto &subset : subsets)
    {
        cout << "[";
        for (size_t i = 0; i < subset.size(); i++)
        {
            cout << subset[i];
            if (i < subset.size() - 1)
                cout << ", ";
        }
        cout << "]" << endl;
    }

    return 0;
}
