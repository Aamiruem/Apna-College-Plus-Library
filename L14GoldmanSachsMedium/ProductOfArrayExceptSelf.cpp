#include <iostream>
#include <vector>
using namespace std;

vector<int> productExceptSelf(vector<int> &nums)
{
    int n = nums.size();
    vector<int> result(n, 1);

    // Step 1: Compute prefix product for each element
    for (int i = 1; i < n; i++)
    {
        result[i] = result[i - 1] * nums[i - 1];
    }

    // Step 2: Compute suffix product and multiply with prefix product
    int suffix = 1;
    for (int i = n - 1; i >= 0; i--)
    {
        result[i] *= suffix;
        suffix *= nums[i];
    }

    return result;
}

int main()
{
    vector<int> nums = {1, 2, 3, 4};
    vector<int> result = productExceptSelf(nums);

    // Print the result
    for (int num : result)
    {
        cout << num << " ";
    }
    cout << endl;
    return 0;
}

// Time Complexity : 𝑂(𝑛)
//O(n) → We make two passes through the array.Space Complexity : 𝑂(𝑛)
// O(n) → We use an additional array result[] to store the final product.

// Explanation :
//  For index 0, the product of all elements except nums[0] is 2 * 3 * 4 = 24. For index 1, the product of all elements except nums[1] is 1 * 3 * 4 = 12. For index 2, the product of all elements except nums[2] is 1 * 2 * 4 = 8. For index 3, the product of all elements except nums[3] is 1 * 2 * 3 = 6.
