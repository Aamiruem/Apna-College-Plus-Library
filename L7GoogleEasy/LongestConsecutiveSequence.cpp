#include <iostream>
#include <unordered_set>
#include <vector>
using namespace std;

class LongestConsecutiveSequence
{
public:
    int longestConsecutive(vector<int> &nums)
    {
        unordered_set<int> set(nums.begin(), nums.end());
        int longest = 0;

        for (int num : nums)
        {
            // Check if it's the start of a sequence
            if (set.find(num - 1) == set.end())
            {
                int current = num;
                int count = 1;

                // Count the length of the sequence
                while (set.find(current + 1) != set.end())
                {
                    current++;
                    count++;
                }

                longest = max(longest, count);
            }
        }

        return longest;
    }
};

int main()
{
    LongestConsecutiveSequence lcs;

    // Test case 1
    vector<int> nums1 = {100, 4, 200, 1, 3, 2};
    cout << lcs.longestConsecutive(nums1) << endl; // Output: 4

    // Test case 2
    vector<int> nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
    cout << lcs.longestConsecutive(nums2) << endl; // Output: 9

    // Test case 3
    vector<int> nums3 = {-1, -2, -3};
    cout << lcs.longestConsecutive(nums3) << endl; // Output: 3

    return 0;
}
