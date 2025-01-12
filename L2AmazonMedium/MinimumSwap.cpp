#include <iostream>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;

int minSwapsToPalindrome(string s)
{
    int n = s.length();
    int swaps = 0;

    // Check if it's possible to rearrange the string into a palindrome
    int oddCount = 0;

    vector<int> freq(26, 0);
    for (char c : s){
        freq[c - 'a']++;
    }
    for (int count : freq)
    {
        if (count % 2 != 0)
            oddCount++;
    }
    if (oddCount > 1)
        return -1; // Not possible to rearrange into a palindrome

    // Two-pointer approach to count swaps
    int left = 0, right = n - 1;

    while (left < right)
    {
        if (s[left] == s[right])
        {
            left++;
            right--;
        }
        else
        {
            int k = right;

            while (k > left && s[k] != s[left])
                k--;

            if (k == left)
            {
                // No match found, swap adjacent
                swap(s[left], s[left + 1]);
                swaps++;
            }
            else
            {
                // Match found, bring it to the correct position
                while (k < right)

                {
                    swap(s[k], s[k + 1]);
                    swaps++;
                    k++;
                }
                left++;
                right--;
            }
        }
    }

    return swaps;
}

int main()
{
    string s;
    cin >> s;
    int result = minSwapsToPalindrome(s);
    if (result == -1)
    {
        cout << "Not possible to rearrange into a palindrome" << endl;
    }
    else
    {
        cout << result << endl;
    }
    return 0;
}
