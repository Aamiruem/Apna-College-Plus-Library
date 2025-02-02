// #include <iostream>
// #include <vector>
// using namespace std;

// int findPivot(vector<int> &nums)
// {
//     int totalSum = 0, leftSum = 0;

//     // Calculate total sum of the array
//     for (int num : nums)
//     {
//         totalSum += num;
//     }

//     // Traverse the array and check for pivot index
//     for (int i = 0; i < nums.size(); i++)
//     {
//         if (leftSum == totalSum - leftSum - nums[i])
//         {
//             return i; // Pivot index found
//         }
//         leftSum += nums[i]; // Update left sum
//     }

//     return -1; // No pivot found
// }

// int main()
// {
//     int n;
//     cin >> n;
//     vector<int> arr(n);

//     for (int i = 0; i < n; i++)
//     {
//         cin >> arr[i];
//     }

//     cout << findPivot(arr) << endl;
//     return 0;
// }



// 5 
// 1 7 3 6 5 6

#include <iostream>
#include <vector>
using namespace std;

int findPivot(vector<int> &nums)
{
    int totalSum = 0, leftSum = 0;

    // Calculate total sum of the array
    for (int num : nums)
    {
        totalSum += num;
    }

    // Traverse the array and check for pivot index
    for (int i = 0; i < nums.size(); i++)
    {
        if (leftSum == totalSum - leftSum - nums[i])
        {
            return i; // Pivot index found
        }
        leftSum += nums[i]; // Update left sum
    }

    return -1; // No pivot found
}

int main()
{
    vector<int> arr = {1, 7, 3, 6, 5, 6}; // Hardcoded input
    cout << findPivot(arr) << endl;
    return 0;
}
