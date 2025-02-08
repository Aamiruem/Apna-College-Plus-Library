#include <iostream>
#include <vector>
#include <set>
using namespace std;

class Solution
{
public:
    bool isValidSudoku(vector<vector<char> > &board)
    {
        // Three sets to track rows, columns, and subgrids
        set<char> vf[9];    // To track the numbers in each column
        set<char> hf[9];    // To track the numbers in each row
        set<char> sf[3][3]; // To track the numbers in each 3x3 subgrid

        // Loop through each cell in the board
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                char num = board[i][j];

                if (num != '.')
                {
                    // Check if the number is already present in the row, column, or subgrid
                    if (hf[i].find(num) != hf[i].end() || vf[j].find(num) != vf[j].end() || sf[i / 3][j / 3].find(num) != sf[i / 3][j / 3].end())
                    {
                        return false; // If found, return false
                    }

                    // Insert the number into the respective row, column, and subgrid sets
                    hf[i].insert(num);
                    vf[j].insert(num);
                    sf[i / 3][j / 3].insert(num);
                }
            }
        }

        return true; // If no duplicates are found, the Sudoku is valid
    }
};

int main()
{
    Solution solution;

    // Define a sample Sudoku board
    vector<vector<char> > board = {
        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

    cout << "Is the Sudoku valid? " << (solution.isValidSudoku(board) ? "Yes" : "No") << endl;
    return 0;
}
