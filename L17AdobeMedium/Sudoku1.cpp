// #include <iostream>
// #include <unordered_set>
// #include <vector>

// using namespace std;

// class Solution
// {
// public:
//     bool isValidSudoku(vector<vector<char> > &board)
//     {
//         unordered_set<string> seen;

//         for (int i = 0; i < 9; i++)
//         {
//             for (int j = 0; j < 9; j++)
//             {
//                 char num = board[i][j];
//                 if (num != '.')
//                 {
//                     // Create unique keys for rows, columns, and subgrids
//                     string rowKey = "row" + to_string(i) + num;
//                     string colKey = "col" + to_string(j) + num;
//                     string subgridKey = "subgrid" + to_string(i / 3) + to_string(j / 3) + num;

//                     // If any of the keys already exist, the board is invalid
//                     if (seen.find(rowKey) != seen.end() || seen.find(colKey) != seen.end() || seen.find(subgridKey) != seen.end())
//                     {
//                         return false;
//                     }

//                     // Otherwise, add the keys to the set
//                     seen.insert(rowKey);
//                     seen.insert(colKey);
//                     seen.insert(subgridKey);
//                 }
//             }
//         }

//         return true;
//     }
// };

// int main()
// {
//     Solution solution;
//     vector<vector<char> > board = {
//         {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
//         {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//         {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//         {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//         {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//         {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//         {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//         {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//         {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

//     cout << "Is the Sudoku valid? " << (solution.isValidSudoku(board) ? "Yes" : "No") << endl;
//     return 0;
// }

#include <iostream>
#include <vector>
#include <set>
using namespace std;

class Solution
{
public:
    bool isValidSudoku(vector<vector<char> > &board)
    {
        set<char> sf[3][3];
        for (int i = 0; i < 9; i++)
        {
            set<char> vf, hf;
            for (int j = 0; j < 9; j++)
            {
                if (board[i][j] != '.' && (hf.find(board[i][j]) != hf.end() || vf.find(board[j][i]) != vf.end() || sf[i / 3][j / 3].find(board[i][j]) != sf[i / 3][j / 3].end()))
                {
                    return false;
                }
                if (board[i][j] != '.')
                {
                    hf.insert(board[i][j]);
                    sf[i / 3][j / 3].insert(board[i][j]);
                }
                if (board[j][i] != '.')
                {
                    vf.insert(board[j][i]);
                }
            }
        }
        return true;
    }
};

int main()
{
    Solution solution;
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

    bool isValid = solution.isValidSudoku(board);
    cout << "Is the Sudoku board valid? " << (isValid ? "Yes" : "No") << endl;

    return 0;
}
