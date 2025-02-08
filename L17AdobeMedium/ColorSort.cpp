#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    void sortColors(vector<int> &nums)
    {
        int low = 0;
        int mid = 0;
        int high = nums.size() - 1;

        while (mid <= high)
        {
            switch (nums[mid])
            {
            case 0:
                swap(nums[low++], nums[mid++]);
                break;
            case 1:
                mid++;
                break;
            case 2:
                swap(nums[high--], nums[mid]);
                break;
            }
        }
    }
};

int main()
{
    Solution solution;
    vector<int> nums = {2, 0, 2, 1, 1, 0}; // Example input
    solution.sortColors(nums);

    cout << "Sorted Colors: ";
    for (int num : nums)
    {
        cout << num << " ";
    }
    cout << endl;

    return 0;
}
