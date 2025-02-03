// #include<bits/stdc++.h>
// #include <iostream>
// #include <unordered_map>
// #include <string>
// using namespace std;

// string minWindow(string s, string t)
// {
//     if (s.empty() || t.empty() || s.size() < t.size())
//     {
//         return "";
//     }

//     unordered_map<char, int> tMap;
//     for (char c : t)
//     {
//         tMap[c]++;
//     }

//     int left = 0, right = 0, requiredChars = tMap.size();
//     unordered_map<char, int> windowMap;
//     int minLen = INT_MAX;
//     int minLeft = 0;

//     while (right < s.size())
//     {
//         char rightChar = s[right];
//         windowMap[rightChar]++;

//         while (windowMap.size() == requiredChars)
//         {
//             if (right - left + 1 < minLen)
//             {
//                 minLen = right - left + 1;
//                 minLeft = left;
//             }

//             char leftChar = s[left];
//             windowMap[leftChar]--;
//             if (windowMap[leftChar] == 0)
//             {
//                 windowMap.erase(leftChar);
//             }
//             left++;
//         }

//         right++;
//     }

//     return minLen == INT_MAX ? "" : s.substr(minLeft, minLen);
// }

// int main()
// {
//     string s = "ADOBECODEBANC";
//     string t = "ABC";
//     cout << "Minimum Window Substring: " << minWindow(s, t) << endl; // Output: "BANC"
//     return 0;
// }

#include <iostream>
#include <string>
#include <unordered_map>
#include <climits>

using namespace std;

string minWindow(string s, string t)
{
    if (s.empty() || t.empty() || s.length() < t.length())
    {
        return "";
    }

    // Frequency map for characters in t
    unordered_map<char, int> tMap;
    for (char c : t)
    {
        tMap[c]++;
    }

    // Sliding window
    int left = 0, right = 0;
    int requiredChars = tMap.size(); // Number of unique characters in t
    int formed = 0;                  // Number of unique characters formed in the current window
    unordered_map<char, int> windowMap;
    int minLen = INT_MAX;
    int minLeft = 0;

    while (right < s.length())
    {
        char rightChar = s[right];
        windowMap[rightChar]++;

        // If the frequency of the current character in the window matches the frequency in t, increment formed
        if (tMap.count(rightChar) && windowMap[rightChar] == tMap[rightChar])
        {
            formed++;
        }

        // If the current window has all the required characters, try to shrink it
        while (left <= right && formed == requiredChars)
        {
            // Update the minimum window
            if (right - left + 1 < minLen)
            {
                minLen = right - left + 1;
                minLeft = left;
            }

            // Shrink the window
            char leftChar = s[left];
            windowMap[leftChar]--;
            if (tMap.count(leftChar) && windowMap[leftChar] < tMap[leftChar])
            {
                formed--;
            }
            left++;
        }

        right++;
    }

    return minLen == INT_MAX ? "" : s.substr(minLeft, minLen);
}

int main()
{
    string s = "ADOBECODEBANC";
    string t = "ABC";
    cout << "Minimum Window Substring: " << minWindow(s, t) << endl; // Expected Output: "BANC"
    return 0;
}
