#include <iostream>
#include <vector>
using namespace std;

// Helper function to calculate unique paths using recursion and memoization
int solve(int i, int j, int m, int n, vector<vector<int> > &memo)
{
    if (i >= m || j >= n)
        return 0; // Out of bounds
    if (i == m - 1 && j == n - 1)
        return 1; // Reached the destination
    if (memo[i][j] != -1)
        return memo[i][j]; // Return memoized result

    // Calculate unique paths from the current cell
    memo[i][j] = solve(i + 1, j, m, n, memo) + solve(i, j + 1, m, n, memo);
    return memo[i][j];
}

// Function to initialize memoization table and start solving
int uniquePaths(int m, int n)
{
    vector<vector<int> > memo(m, vector<int>(n, -1)); // Initialize memoization table with -1
    return solve(0, 0, m, n, memo);
}

int main()
{
    int m = 3, n = 2;
    cout << uniquePaths(m, n) << endl; // Output: 3
    return 0;
}
