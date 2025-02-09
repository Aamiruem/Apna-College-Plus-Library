// #include <iostream>
// #include <vector>
// #include <algorithm>
// using namespace std;

// class Solution
// {
// public:
//     int minCut(string s)
//     {
//         int n = s.length();
//         // Create a DP array to store if s[i..j] is a palindrome
//         vector<vector<bool> > isPalindrome(n, vector<bool>(n, false));
//         // Create a DP array to store the minimum cuts
//         vector<int> cuts(n);

//         // Initialize the cuts array
//         for (int i = 0; i < n; i++)
//         {
//             cuts[i] = i; // Maximum cuts needed for s[0..i]
//         }

//         // Fill the isPalindrome table and update the cuts array
//         for (int j = 0; j < n; j++)
//         {
//             for (int i = 0; i <= j; i++)
//             {
//                 // Check if s[i..j] is a palindrome
//                 if (s[i] == s[j] && (j - i <= 2 || isPalindrome[i + 1][j - 1]))
//                 {
//                     isPalindrome[i][j] = true;
//                     // If s[i..j] is a palindrome, update the cuts array
//                     if (i == 0)
//                     {
//                         cuts[j] = 0; // No cut needed if s[0..j] is a palindrome
//                     }
//                     else
//                     {
//                         cuts[j] = min(cuts[j], cuts[i - 1] + 1);
//                     }
//                 }
//             }
//         }

//         return cuts[n - 1];
//     }
// };

// int main()
// {
//     Solution solution;
//     string s = "aabba";
//     cout << "Minimum cuts needed: " << solution.minCut(s) << endl; // Output: 1
//     return 0;
// }







#include <iostream>
#include <vector>
#include <climits>
using namespace std;

// Function to check if a substring is a palindrome
bool isPalindrome(int i, int j, string &s)
{
    while (i < j)
    {
        if (s[i] != s[j])
            return false;
        i++;
        j--;
    }
    return true;
}

class Solution
{
public:
    int minCut(string str)
    {
        int n = str.size();
        vector<int> dp(n + 1, 0); // DP array to store the minimum cuts
        dp[n] = 0;                // Base case: no cuts needed for an empty string

        // Fill the DP array from the end to the start
        for (int i = n - 1; i >= 0; i--)
        {
            int mini = INT_MAX;
            for (int k = i; k < n; k++)
            {
                if (isPalindrome(i, k, str))
                {
                    int x = 1 + dp[k + 1]; // Cut after the current palindrome
                    mini = min(mini, x);
                }
            }
            dp[i] = mini; // Store the minimum cuts for the current substring
        }

        return dp[0] - 1; // Subtract 1 because the last cut is not needed
    }
};

int main()
{
    Solution solution;
    string s = "aabba";
    cout << "Minimum cuts needed: " << solution.minCut(s) << endl; // Output: 1
    return 0;
}
