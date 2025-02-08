#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

class Solution
{
public:
    bool checkIfCanBreak(string s1, string s2)
    {
        int n = s1.size();

        // Step 1: Sort both strings
        sort(s1.begin(), s1.end());
        sort(s2.begin(), s2.end());

        bool s1CanBreakS2 = true;
        bool s2CanBreakS1 = true;

        // Step 2: Compare character by character
        for (int i = 0; i < n; i++)
        {
            if (s1[i] < s2[i])
            {
                s1CanBreakS2 = false;
            }
            if (s2[i] < s1[i])
            {
                s2CanBreakS1 = false;
            }
        }

        // Step 3: Return true if either condition is met
        return s1CanBreakS2 || s2CanBreakS1;
    }
};

int main()
{
    Solution solution;

    // Example input
    string s1, s2;
    cout << "Enter first string: ";
    cin >> s1;
    cout << "Enter second string: ";
    cin >> s2;

    bool result = solution.checkIfCanBreak(s1, s2);

    if (result)
    {
        cout << "One string can break the other." << endl;
    }
    else
    {
        cout << "Neither string can break the other." << endl;
    }

    return 0;
}
