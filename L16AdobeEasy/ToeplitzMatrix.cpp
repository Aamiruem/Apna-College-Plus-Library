#include <iostream>
#include <vector>
using namespace std;

bool isToeplitzMatrix(vector<vector<int> > &matrix)
{
    int rows = matrix.size();
    int cols = matrix[0].size();

    for (int i = 1; i < rows; ++i)
    {
        for (int j = 1; j < cols; ++j)
        {
            // Compare current element with top-left diagonal element
            if (matrix[i][j] != matrix[i - 1][j - 1])
            {
                return false;
            }
        }
    }
    return true;
}

int main()
{
    vector<vector<int> > matrix = {
        {1, 2, 3, 4},
        {5, 1, 2, 3},
        {9, 5, 1, 2}};
    cout << "Is Toeplitz? " << isToeplitzMatrix(matrix) << endl; // Output: 1 (true)
    return 0;
}
