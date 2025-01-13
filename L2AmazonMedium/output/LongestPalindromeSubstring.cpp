#include <iostream>
#include <string>
using namespace std;

void longestPalSubstr(const string &s)
{
    int start = 0, end = 0;

    for (int i = 0; i < s.length(); i++)
    {
        // Odd-length palindrome
        int l = i, r = i;
        while (l >= 0 && r < s.length() && s[l] == s[r])
        {
            if (r - l + 1 > end - start)
            {
                start = l;
                end = r + 1;
            }
            l--;
            r++;
        }

        // Even-length palindrome
        l = i;
        r = i + 1;
        while (l >= 0 && r < s.length() && s[l] == s[r])
        {
            if (r - l + 1 > end - start)
            {
                start = l;
                end = r + 1;
            }
            l--;
            r++;
        }
    }

    // Print the longest palindromic substring
    cout << "Longest Palindromic Substring: " << s.substr(start, end - start) << endl;
}

int main()
{
    string s = "babad";
    longestPalSubstr(s);
    return 0;
}
