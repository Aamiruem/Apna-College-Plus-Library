#include <iostream>
#include <string>

using namespace std;

class Solution
{
public:
    int lengthOfLastWord(string s)
    {
        int length = 0;
        int i = s.size() - 1;

        // Trim trailing spaces
        while (i >= 0 && s[i] == ' ')
        {
            i--;
        }

        // Count characters until the next space or start of the string
        while (i >= 0 && s[i] != ' ')
        {
            length++;
            i--;
        }

        return length;
    }
};

int main()
{
    Solution solution;

    // Example test cases
    cout << solution.lengthOfLastWord("Hello World") << endl;                // Output: 5
    cout << solution.lengthOfLastWord("  fly me   to   the moon  ") << endl; // Output: 4
    cout << solution.lengthOfLastWord("luffy is still joyboy") << endl;      // Output: 6
    cout << solution.lengthOfLastWord("a") << endl;                          // Output: 1

    return 0;
}
