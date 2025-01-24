#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Permutation
{
    vector<vector<int> > ans;

public:
    vector<vector<int> > permute(vector<int> &nums)
    {
        vector<int> path;
        helper(nums, path);
        return ans;
    }

    void helper(vector<int> &nums, vector<int> &path)
    {
        if (path.size() == nums.size())
        {
            ans.push_back(path);
            return;
        }
        for (int i = 0; i < nums.size(); i++)
        {
            if (nums[i] != -11)
            {
                int temp = nums[i];
                path.push_back(temp);
                nums[i] = -11;
                helper(nums, path);
                path.pop_back();
                nums[i] = temp;
            }
        }
    }
};

void runTestCase(vector<int> nums, vector<vector<int> > expected, Permutation &p, int testCaseNumber)
{
    vector<vector<int> > result = p.permute(nums);
    if (result == expected)
    {
        cout << "Test case " << testCaseNumber << " passed!" << endl;
    }
    else
    {
        cout << "Test case " << testCaseNumber << " failed!" << endl;
    }
}

int main()
{
    Permutation p;

    // Test case 1
    vector<int> nums1 = {1, 2, 3, 4};
    vector<vector<int> > expected1 = {
        {1, 2, 3, 4}, {1, 2, 4, 3}, {1, 3, 2, 4}, {1, 3, 4, 2}, {1, 4, 2, 3}, {1, 4, 3, 2}, {2, 1, 3, 4}, {2, 1, 4, 3}, {2, 3, 1, 4}, {2, 3, 4, 1}, {2, 4, 1, 3}, {2, 4, 3, 1}, {3, 1, 2, 4}, {3, 1, 4, 2}, {3, 2, 1, 4}, {3, 2, 4, 1}, {3, 4, 1, 2}, {3, 4, 2, 1}, {4, 1, 2, 3}, {4, 1, 3, 2}, {4, 2, 1, 3}, {4, 2, 3, 1}, {4, 3, 1, 2}, {4, 3, 2, 1}};
    runTestCase(nums1, expected1, p, 1);

    // Test case 2
    vector<int> nums2 = {1, 1, 2};
    vector<vector<int> > expected2 = {
        {1, 1, 2}, {1, 2, 1}, {2, 1, 1}};
    runTestCase(nums2, expected2, p, 2);

    // Test case 3
    vector<int> nums3 = {0, 1};
    vector<vector<int> > expected3 = {
        {0, 1}, {1, 0}};
    runTestCase(nums3, expected3, p, 3);

    // Test case 4
    vector<int> nums4 = {1};
    vector<vector<int> > expected4 = {
        {1}};
    runTestCase(nums4, expected4, p, 4);

    return 0;
}
