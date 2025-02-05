#include <iostream>
#include <string>
using namespace std;

string lastSubstring(string s)
{
    int n = s.length();
    int i = 0, j = 1, k = 0;

    // Compare substrings starting at i and j
    while (j + k < n)
    {
        if (s[i + k] == s[j + k])
        {
            k++; // Continue comparing next characters
        }
        else if (s[i + k] < s[j + k])
        {
            // Found a lexicographically larger substring, move i forward
            i = j;
            j = i + 1;
            k = 0; // Reset k since we start a new comparison
        }
        else
        {
            // j's substring is smaller, move j forward
            j = j + k + 1;
            k = 0;
        }
    }
    return s.substr(i);
}

int main()
{
    string s = "abab";
    cout << lastSubstring(s) << endl; // Output: "bab"
    return 0;
}
