#include <iostream>
#include <vector>

using namespace std;

class Solution
{
public:
    int removeElement(vector<int> &nums, int val)
    {
        int index = 0; // Pointer for placing non-val elements

        for (int num : nums)
        {
            if (num != val)
            {
                nums[index] = num;
                index++;
            }
        }
        return index; // New length of the array
    }
};

int main()
{
    Solution solution;

    // Example 1
    vector<int> nums1 = {10, 1, 2, 2, 3, 0, 4, 21};
    int val1 = 2;
    int newLength1 = solution.removeElement(nums1, val1);

    cout << "Output: " << newLength1 << ", nums = [";
    for (int i = 0; i < newLength1; i++)
    {
        cout << nums1[i] << (i < newLength1 - 1 ? ", " : "");
    }
    cout << "]" << endl;

    // Example 2
    vector<int> nums2 = {3, 2, 2, 3};
    int val2 = 3;
    int newLength2 = solution.removeElement(nums2, val2);

    cout << "Output: " << newLength2 << ", nums = [";
    for (int i = 0; i < newLength2; i++)
    {
        cout << nums2[i] << (i < newLength2 - 1 ? ", " : "");
    }
    cout << "]" << endl;

    return 0;
}
