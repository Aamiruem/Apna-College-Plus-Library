#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class NextPermutation
{
public:
    void setNextPermutation(vector<int> &nums)
    {
        int n = nums.size();
        int i = n - 2;

        // Find the first decreasing element from the end
        while (i >= 0 && nums[i] >= nums[i + 1])
        {
            i--;
        }

        if (i >= 0)
        { // If a valid index is found
            int j = n - 1;

            // Find the next greater element to swap with nums[i]
            while (j >= 0 && nums[i] >= nums[j])
            {
                j--;
            }

            swap(nums[i], nums[j]); // Swap the two elements
        }

        // Reverse the elements from i+1 to the end
        reverse(nums.begin() + i + 1, nums.end());

        // Print the result
        printArray(nums);
    }

private:
    void printArray(const vector<int> &nums)
    {
        cout << "[";
        for (size_t i = 0; i < nums.size(); i++)
        {
            cout << nums[i];
            if (i != nums.size() - 1)
            {
                cout << ", ";
            }
        }
        cout << "]" << endl;
    }
};

int main()
{
    NextPermutation np;
    vector<int> nums = {1, 5, 1};
    np.setNextPermutation(nums);
    return 0;
}
