#include <iostream>
#include <vector>
#include <string>
using namespace std;

class WordSearch
{
public:
    bool wordSearch(vector<vector<char> > &board, string word)
    {
        int rows = board.size();
        int cols = board[0].size();

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if (dfs(board, i, j, word))
                {
                    return true;
                }
            }
        }
        return false;
    }

private:
    bool dfs(vector<vector<char> > &board, int i, int j, string word)
    {
        if (word.empty())
        {
            return true; // All characters in the word are found
        }
        if (i < 0 || j < 0 || i >= board.size() || j >= board[0].size() || board[i][j] != word[0])
        {
            return false; // Out of bounds or character mismatch
        }

        // Temporarily mark the cell as visited
        char temp = board[i][j];
        board[i][j] = '.';

        // Check all four directions
        bool found = dfs(board, i + 1, j, word.substr(1)) ||
                     dfs(board, i - 1, j, word.substr(1)) ||
                     dfs(board, i, j + 1, word.substr(1)) ||
                     dfs(board, i, j - 1, word.substr(1));

        // Restore the original value
        board[i][j] = temp;

        return found;
    }
};

int main()
{
    vector<vector<char> > board = {
        {'A', 'B', 'C', 'E'},
        {'S', 'F', 'C', 'S'},
        {'A', 'D', 'E', 'E'}};

    string word = "SEE";
    WordSearch wordSearch;
    cout << (wordSearch.wordSearch(board, word) ? "true" : "false") << endl; // Expected output: true

    return 0;
}
