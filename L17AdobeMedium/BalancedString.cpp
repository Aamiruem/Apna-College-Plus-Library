#include <iostream>
#include <string>

using namespace std;

class Solution
{
public:
    int minSwaps(string s)
    {
        int size = 0, imbalance = 0;

        for (char ch : s)
        {
            if (ch == '[')
            {
                size++; // Count open brackets
            }
            else
            {
                if (size > 0)
                {
                    size--; // Match a closing bracket with an open bracket
                }
                else
                {
                    imbalance++; // Unmatched closing bracket found
                }
            }
        }

        return (imbalance + 1) / 2; // Minimum swaps needed
    }
};

int main()
{
    Solution solution;
    string s = "]]][[[";
    int minSwaps = solution.minSwaps(s);

    cout << "Minimum Swaps: " << minSwaps << endl;

    return 0;
}
