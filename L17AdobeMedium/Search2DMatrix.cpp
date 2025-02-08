#include <iostream>
#include <vector>
#include <string>

using namespace std;

class Search2DMatrix
{
public:
    string searchMatrix(vector<vector<int> > &matrix, int target)
    {
        if (matrix.empty() || matrix[0].empty())
        {
            return "Matrix is empty or null"; // Handle empty or null matrix
        }

        int rows = matrix.size();
        int cols = matrix[0].size();

        // Start from the top-right corner
        int row = 0;
        int col = cols - 1;

        while (row < rows && col >= 0)
        {
            if (matrix[row][col] == target)
            {
                // Target found, return its position
                return "Target found at index: [" + to_string(row) + ", " + to_string(col) + "]";
            }
            else if (matrix[row][col] < target)
            {
                // Move down if current value is smaller than the target
                row++;
            }
            else
            {
                // Move left if current value is larger than the target
                col--;
            }
        }

        return "Target not found"; // Return message if target isn't found
    }
};

int main()
{
    Search2DMatrix solution;
    vector<vector<int> > matrix = {
        {1, 4, 7, 11},
        {2, 5, 8, 12},
        {3, 6, 9, 16},
        {10, 13, 14, 17}};
    int target = 5;
    string result = solution.searchMatrix(matrix, target);
    cout << result << endl;

    return 0;
}
