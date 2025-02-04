#include <iostream>
using namespace std;

int main()
{
    // Predefined array (you can change this array as needed)
    int arr[] = {2, 5, 3, 4, 1};
    int n = sizeof(arr) / sizeof(arr[0]); // Number of elements in the array

    // Variables to count the number of elements smaller and larger than the current element
    int ls, lg, rs, rg;

    // Variable to store the final answer
    int ans = 0;

    // Iterate over each element in the array
    for (int j = 0; j < n; j++)
    {
        // Initialize counters for the current element
        ls = 0; // Count of elements smaller than arr[j] to the left of j
        lg = 0; // Count of elements larger than arr[j] to the left of j
        rs = 0; // Count of elements smaller than arr[j] to the right of j
        rg = 0; // Count of elements larger than arr[j] to the right of j

        // Iterate over the array to count the smaller and larger elements
        for (int i = 0; i < n; i++)
        {
            if (i < j)
            {
                // If the current index is to the left of j
                if (arr[i] < arr[j])
                    ls++;
                else if (arr[i] > arr[j])
                    lg++;
            }
            else if (i > j)
            {
                // If the current index is to the right of j
                if (arr[i] < arr[j])
                    rs++;
                else if (arr[i] > arr[j])
                    rg++;
            }
        }

        // Update the answer based on the counts
        ans += ls * rg + rs * lg;
    }

    // Print the final answer
    cout << ans << endl;

    return 0;
}
