#include <iostream>
#include <vector>
#include <algorithm> // Include this for reverse

using namespace std;

class RotateImageMatrix
{
public:
    void rotate(vector<vector<int> > &board)
    {
        int n = board.size();

        // Transpose the matrix
        for (int i = 0; i < n; i++)
        {
            for (int j = i; j < n; j++)
            {
                swap(board[i][j], board[j][i]);
            }
        }

        // Reverse each row
        for (int i = 0; i < n; i++)
        {
            reverse(board[i].begin(), board[i].end());
        }
    }

    void printMatrix(const vector<vector<int> > &matrix)
    {
        for (const auto &row : matrix)
        {
            for (int val : row)
            {
                cout << val << " ";
            }
            cout << endl;
        }
    }
};

int main()
{
    RotateImageMatrix obj;

    // Test case 1: 4x4 matrix
    vector<vector<int> > board = {
        {5, 1, 9, 11},
        {2, 4, 8, 10},
        {13, 3, 6, 7},
        {15, 14, 12, 16}};

    cout << "Original Matrix:" << endl;
    obj.printMatrix(board);
    cout << endl;

    obj.rotate(board);

    cout << "Rotated Matrix:" << endl;
    obj.printMatrix(board);

    // Test case 2: 3x3 matrix
    vector<vector<int> > board3x3 = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}};

    cout << "\nOriginal 3x3 Matrix:" << endl;
    obj.printMatrix(board3x3);
    cout << endl;

    obj.rotate(board3x3);

    cout << "Rotated 3x3 Matrix:" << endl;
    obj.printMatrix(board3x3);

    return 0;
}
