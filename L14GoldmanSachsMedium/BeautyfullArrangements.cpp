#include <iostream>
#include <vector>
using namespace std;

int backtrack(vector<int> &vis, int i, int n)
{
    if (i > n)
        return 1; // Base case: If all positions are filled, count as 1 valid arrangement

    int cnt = 0;
    for (int x = 1; x <= n; x++)
    {
        if (vis[x] == 0 && (x % i == 0 || i % x == 0))
        { // Check valid placement
            vis[x] = 1;
            cnt += backtrack(vis, i + 1, n);
            vis[x] = 0; // Backtrack
        }
    }
    return cnt;
}

int countBeautifulArrangements(int n)
{
    vector<int> vis(n + 1, 0); // Initialize visited array
    return backtrack(vis, 1, n);
}

int main()
{
    int n;
    cin >> n;                                      // Read input
    cout << countBeautifulArrangements(n) << endl; // Print result
    return 0;
}
