#include <iostream>
#include <vector>
using namespace std;

void moveZeroes(vector<int> &nums)
{
    int index = 0; // Position to place the next non-zero element

    // Move non-zero elements to the front
    for (int num : nums)
    {
        if (num != 0)
        {
            nums[index++] = num;
        }
    }

    // Fill remaining positions with zeros
    while (index < nums.size())
    {
        nums[index++] = 0;
    }
}

int main()
{
    vector<int> arr = {0, 1, 0, 3, 12};
    moveZeroes(arr);

    for (int num : arr)
    {
        cout << num << " ";
    }
    // Output: 1 3 12 0 0
    return 0;
}
