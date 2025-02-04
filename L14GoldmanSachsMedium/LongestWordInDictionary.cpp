#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// Function to check if 'word' is a subsequence of 's'
bool isSubsequence(const string &s, const string &word)
{
    int i = 0, j = 0;
    while (i < s.length() && j < word.length())
    {
        if (s[i] == word[j])
        {
            j++; // Move to the next character in word
        }
        i++; // Always move in s
    }
    return j == word.length(); // If j reached word.length(), word is a subsequence
}

// Function to find the longest word in dictionary that is a subsequence of s
string findLongestWord(string s, vector<string> &dictionary)
{
    // Sort dictionary: first by length (descending), then lexicographically (ascending)
    sort(dictionary.begin(), dictionary.end(), [](const string &a, const string &b)
        { return (a.length() == b.length()) ? (a < b) : (a.length() > b.length()); });

    // Check each word in dictionary
    for (const string &word : dictionary)
    {
        if (isSubsequence(s, word))
        {                // If 'word' is a subsequence of 's'
            return word; // First valid word will be the longest due to sorting
        }
    }
    return ""; // No valid word found
}

int main()
{
    string s = "abpcplea"; // Input string
    vector<string> dictionary = {"ale", "apple", "monkey", "plea"};

    // Find and print the longest word
    cout << findLongestWord(s, dictionary) << endl;
    return 0;
}
