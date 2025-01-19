#include <iostream>
#include <unordered_map>
#include <string>
#include <algorithm>

using namespace std;

class LongestSubstringWithoutRepeatingCharacter
{
public:
    int lengthOfLongestSubstring(string s)
    {
        unordered_map<char, int> freq;
        int n = s.length();
        int i = 0, j = 0;
        int ans = 0;

        while (i < n)
        {
            char currentChar = s[i];
            freq[currentChar]++;

            while (freq[currentChar] > 1)
            {
                char startChar = s[j];
                freq[startChar]--;
                j++;
            }

            ans = max(ans, i - j + 1);
            i++;
        }

        return ans;
    }
};

int main()
{
    LongestSubstringWithoutRepeatingCharacter obj;
    cout << obj.lengthOfLongestSubstring("abcabcbb") << endl; // Output: 3
    cout << obj.lengthOfLongestSubstring("bbbbb") << endl;    // Output: 1
    cout << obj.lengthOfLongestSubstring("pwwkew") << endl;   // Output: 3
    cout << obj.lengthOfLongestSubstring("") << endl;         // Output: 0
    cout << obj.lengthOfLongestSubstring("abcdef") << endl;   // Output: 6
    return 0;
}
