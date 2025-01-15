#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>

using namespace std;

double findMedianSortedArrays(vector<int> &nums1, vector<int> &nums2)
{
    int N1 = nums1.size();
    int N2 = nums2.size();
    if (N1 > N2)
    {
        return findMedianSortedArrays(nums2, nums1); // Ensure nums1 is the smaller array
    }

    int low = 0, high = N1;
    while (low <= high)
    {
        int mid1 = (low + high) / 2;
        int mid2 = (N1 + N2 + 1) / 2 - mid1;

        int l1 = (mid1 == 0) ? INT_MIN : nums1[mid1 - 1];
        int r1 = (mid1 == N1) ? INT_MAX : nums1[mid1];
        int l2 = (mid2 == 0) ? INT_MIN : nums2[mid2 - 1];
        int r2 = (mid2 == N2) ? INT_MAX : nums2[mid2];

        if (l1 <= r2 && l2 <= r1)
        {
            if ((N1 + N2) % 2 == 0)
            {
                return (max(l1, l2) + min(r1, r2)) / 2.0;
            }
            else
            {
                return (double)max(l1, l2);
            }
        }
        else if (l1 > r2)
        {
            high = mid1 - 1;
        }
        else
        {
            low = mid1 + 1;
        }
    }
    return 0.0;
}

int main()
{
    vector<int> nums1 = {1, 3};
    vector<int> nums2 = {2, 5, 7};
    cout << findMedianSortedArrays(nums1, nums2) << endl; // Output: 3.0
    return 0;
}
