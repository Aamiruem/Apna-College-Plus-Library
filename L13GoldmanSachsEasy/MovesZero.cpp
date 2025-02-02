// #include <iostream>
// #include <vector>
// using namespace std;

// void moveZeroes(vector<int> &nums)
// {
//     int index = 0; // Position to place the next non-zero element

//     // Move non-zero elements to the front
//     for (int num : nums)
//     {
//         if (num != 0)
//         {
//             nums[index++] = num;
//         }
//     }

//     // Fill remaining positions with zeros
//     while (index < nums.size())
//     {
//         nums[index++] = 0;
//     }
// }

// int main()
// {
//     vector<int> arr = {0, 1, 0, 3, 12};
//     moveZeroes(arr);

//     for (int num : arr)
//     {
//         cout << num << " ";
//     }
//     // Output: 1 3 12 0 0
//     return 0;
// }




















#include <iostream>
#include <vector>
using namespace std;

void moveZeroesOptimized(vector<int> &nums)
{
    int j = 0; // Position of the next zero to be swapped

    for (int i = 0; i < nums.size(); i++)
    {
        if (nums[i] != 0)
        {
            swap(nums[i], nums[j++]);
        }
    }
}

int main()
{ 
    vector<int> arr = {0, 1, 0, 3, 12};
    moveZeroesOptimized(arr);
    for (int num : arr)
    {
        cout << num << " ";
    }
    // Output: 1 3 12 0 0
    return 0;
}

// ✅ Best for minimizing swaps
// ✅ Works in O(N) time, O(1) space

// Example Test Cases
// Input	Output
// [0,1,0,3,12]	[1,3,12,0,0]
// [0,0,1]	[1,0,0]
// [1,2,3,0,0,4]	[1,2,3,4,0,0]
