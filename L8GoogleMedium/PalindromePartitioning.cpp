#include <iostream>
#include <vector>
#include <string>
using namespace std;

class PalindromePartitioning
{
public:
    vector<vector<string> > partition(string s)
    {
        int len = s.length();
        vector<vector<string> > ans;
        vector<vector<int> > dp(len, vector<int>(len, 0)); // dp[i][j] == 1 means substring s[i...j] is a palindrome
        vector<string> curr;
        recur(curr, 0, s, dp, ans);
        return ans;
    }

private:
    void recur(vector<string> &curr, int i, const string &s, vector<vector<int> > &dp, vector<vector<string> > &ans)
    {
        if (i == s.length())
        {
            ans.push_back(curr); // Add the current list to the result
            return;
        }
        for (int j = i; j < s.length(); j++)
        {
            if (dp[i][j] == 1 || isPalindrome(s, i, j, dp))
            {
                dp[i][j] = 1;                           // Mark this substring as a palindrome
                curr.push_back(s.substr(i, j - i + 1)); // Add the current palindrome to the list
                recur(curr, j + 1, s, dp, ans);         // Recur for the next part of the string
                curr.pop_back();                        // Backtrack by removing the last added palindrome
            }
        }
    }

    bool isPalindrome(const string &s, int start, int end, vector<vector<int> > &dp)
    {
        while (start < end)
        {
            if (s[start] != s[end])
            {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
};

int main()
{
    PalindromePartitioning p;
    string s = "aab";
    vector<vector<string> > result = p.partition(s);

    // Print the result
    for (const auto &partition : result)
    {
        cout << "[";
        for (const auto &str : partition)
        {
            cout << "\"" << str << "\"";
            if (&str != &partition.back())
                cout << ", ";
        }
        cout << "]\n";
    }

    return 0;
}
