#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <vector>

using namespace std;

class WildcardMatching
{
public:
    bool isMatch(string s, string p)
    {
        int m = s.length(), n = p.length();
        vector<vector<int> > dp(m + 1, vector<int>(n + 1, -1)); // DP table initialized to -1
        return help(s, p, 0, 0, dp);
    }

private:
    bool help(const string &s, const string &p, int i, int j, vector<vector<int> > &dp)
    {
        if (dp[i][j] != -1)
        {
            return dp[i][j] == 1;
        }

        // If both strings are fully processed
        if (i == s.length() && j == p.length())
        {
            dp[i][j] = 1;
            return true;
        }

        // If the pattern is fully processed but the string is not
        if (j == p.length())
        {
            dp[i][j] = 0;
            return false;
        }

        bool match = false;

        // Handle '*' in the pattern
        if (p[j] == '*')
        {
            match = (i < s.length() && help(s, p, i + 1, j, dp)) || help(s, p, i, j + 1, dp);
        }
        // Handle '?' or exact character match
        else if (i < s.length() && (p[j] == '?' || s[i] == p[j]))
        {
            match = help(s, p, i + 1, j + 1, dp);
        }

        dp[i][j] = match ? 1 : 0;
        return match;
    }
};

int main()
{
    WildcardMatching solution;

    // Test case 1: Matching string "aa" with pattern "a"
    string s1 = "aa";
    string p1 = "a";
    cout << "isMatch(\"" << s1 << "\", \"" << p1 << "\"): " << (solution.isMatch(s1, p1) ? "true" : "false") << endl;

    // Test case 2: Matching string "aa" with pattern "*"
    string s2 = "aa";
    string p2 = "*";
    cout << "isMatch(\"" << s2 << "\", \"" << p2 << "\"): " << (solution.isMatch(s2, p2) ? "true" : "false") << endl;

    // Test case 3: Matching string "cb" with pattern "?a"
    string s3 = "cb";
    string p3 = "?a";
    cout << "isMatch(\"" << s3 << "\", \"" << p3 << "\"): " << (solution.isMatch(s3, p3) ? "true" : "false") << endl;

    // Test case 4: Matching string "adceb" with pattern "*a*b"
    string s4 = "adceb";
    string p4 = "*a*b";
    cout << "isMatch(\"" << s4 << "\", \"" << p4 << "\"): " << (solution.isMatch(s4, p4) ? "true" : "false") << endl;

    return 0;
}
