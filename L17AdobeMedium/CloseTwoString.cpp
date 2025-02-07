#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution
{
public:
    bool closeStrings(string s1, string s2)
    {
        // If the strings have different lengths, they can't be close
        if (s1.size() != s2.size())
        {
            return false;
        }

        vector<int> a(26, 0); // Frequency count for s1
        vector<int> b(26, 0); // Frequency count for s2

        // Count the frequencies of each character in s1 and s2
        for (int i = 0; i < s1.size(); i++)
        {
            a[s1[i] - 'a']++;
            b[s2[i] - 'a']++;
        }

        // If the sets of characters in s1 and s2 are not the same, return false
        for (int i = 0; i < 26; i++)
        {
            if ((a[i] == 0 && b[i] > 0) || (a[i] > 0 && b[i] == 0))
            {
                return false;
            }
        }

        // Sort the frequency vectors and check if they are equal
        sort(a.begin(), a.end());
        sort(b.begin(), b.end());

        return a == b; // If the sorted frequencies are equal, return true
    }
};

int main()
{
    Solution solution;

    // Example usage
    string s1 = "abc";
    string s2 = "bca";

    cout << "Are the strings close? " << (solution.closeStrings(s1, s2) ? "Yes" : "No") << endl;

    return 0;
}
