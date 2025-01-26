// #include <iostream>
// #include <vector>
// #include <stack>
// #include <algorithm>
// using namespace std;

// int largestRectangleArea(vector<int> &heights)
// {
//     int len = heights.size();
//     vector<int> left(len), right(len);

//     // Preprocessing nearest smaller to the left
//     left[0] = -1; // No smaller element to the left of the first element
//     for (int i = 1; i < len; i++)
//     {
//         int ind = i - 1;
//         while (ind >= 0 && heights[ind] >= heights[i])
//         {
//             ind = left[ind];
//         }
//         left[i] = ind;
//     }

//     // Preprocessing nearest smaller to the right
//     right[len - 1] = len; // No smaller element to the right of the last element
//     for (int i = len - 2; i >= 0; i--)
//     {
//         int ind = i + 1;
//         while (ind < len && heights[ind] >= heights[i])
//         {
//             ind = right[ind];
//         }
//         right[i] = ind;
//     }

//     // Calculate the maximum area
//     int maxArea = 0;
//     for (int i = 0; i < len; i++)
//     {
//         int width = right[i] - left[i] - 1; // Width of the rectangle
//         int area = heights[i] * width;      // Area of the rectangle
//         maxArea = max(maxArea, area);
//     }

//     return maxArea;
// }

// int main()
// {
//     vector<int> heights = {2, 1, 5, 6, 2, 3};
//     cout << "Largest Rectangle Area: " << largestRectangleArea(heights) << endl;
//     return 0;
// }




#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution17
{
public:
    int largestRectangleArea(vector<int> &heights)
    {
        int len = heights.size();
        vector<int> left(len), right(len);

        // Compute nearest smaller to the left
        left[0] = -1;
        for (int i = 1; i < len; i++)
        {
            int ind = i - 1;
            while (ind >= 0 && heights[ind] >= heights[i])
            {
                ind = left[ind];
            }
            left[i] = ind;
        }

        // Compute nearest smaller to the right
        right[len - 1] = len;
        for (int i = len - 2; i >= 0; i--)
        {
            int ind = i + 1;
            while (ind < len && heights[ind] >= heights[i])
            {
                ind = right[ind];
            }
            right[i] = ind;
        }

        // Calculate the maximum area
        int maxArea = 0;
        for (int i = 0; i < len; i++)
        {
            int width = right[i] - left[i] - 1;
            int area = heights[i] * width;
            maxArea = max(maxArea, area);
        }

        return maxArea;
    }
};

int main()
{
    Solution17 solution;

    vector<int> heights1 = {2, 1, 5, 6, 2, 3};
    cout << solution.largestRectangleArea(heights1) << endl; // Expected output: 10

    vector<int> heights2 = {1};
    cout << solution.largestRectangleArea(heights2) << endl; // Expected output: 1

    vector<int> heights3 = {1, 2, 3, 4, 5};
    cout << solution.largestRectangleArea(heights3) << endl; // Expected output: 9

    vector<int> heights4 = {5, 4, 3, 2, 1};
    cout << solution.largestRectangleArea(heights4) << endl; // Expected output: 9

    vector<int> heights5 = {1, 1, 1, 1, 1};
    cout << solution.largestRectangleArea(heights5) << endl; // Expected output: 5

    return 0;
}
