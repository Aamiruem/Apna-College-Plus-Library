#include <iostream>
#include <vector>
#include <string>
#include <unordered_map>
#include <algorithm>

using namespace std;

class ShortestSuperstring
{
public:
    string shortestSuperstring(vector<string> &words)
    {
        unordered_map<string, string> memo;
        int unusedWords = 0;

        // Mark all words as unused using a bitmask
        for (int i = 0; i < words.size(); i++)
        {
            unusedWords |= 1 << i;
        }

        // Call the recursive function to find the shortest superstring
        return shortestSuperstring(words, "", unusedWords, memo);
    }

private:
    string shortestSuperstring(vector<string> &words, const string &startWord, int unused, unordered_map<string, string> &memo)
    {
        if (unused == 0)
        { // Base case: all words have been used
            return startWord;
        }

        // Create a unique key for the current start word and unused words combination
        string key = startWord + "|" + to_string(unused);

        // If the result for this combination has already been calculated, return it
        if (memo.find(key) != memo.end())
        {
            return memo[key];
        }

        string shortest;

        // Try to append each unused word to the start word
        for (int i = 0; i < words.size(); i++)
        {
            if (!isConsumed(unused, i))
            { // If the i-th word has not been used yet

                // Get the shortest superstring starting from the ith word
                string superstring = shortestSuperstring(words, words[i], consume(unused, i), memo);

                // Append the shortest superstring to the start word
                string appended = overlapAppend(startWord, superstring);

                // Keep the shortest
                if (shortest.empty() || appended.length() < shortest.length())
                {
                    shortest = appended;
                }
            }
        }

        // Cache the result for this combination
        memo[key] = shortest;
        return shortest;
    }

    // Check if a word is already consumed using the bitmask
    bool isConsumed(int unused, int index)
    {
        return (unused & (1 << index)) == 0;
    }

    // Consume a word by updating the bitmask
    int consume(int unused, int index)
    {
        return unused & ~(1 << index);
    }

    // Append two strings with maximum overlap
    string overlapAppend(const string &a, const string &b)
    {
        int maxOverlap = 0;
        for (int i = 1; i <= min(a.length(), b.length()); i++)
        {
            if (a.substr(a.length() - i) == b.substr(0, i))
            {
                maxOverlap = i;
            }
        }
        return a + b.substr(maxOverlap);
    }
};

int main()
{
    ShortestSuperstring solver;

    // Test Case 1
    vector<string> words1 = {"cat", "dog", "bird", "elephant"};
    cout << "[cat, dog, bird, elephant] => " << solver.shortestSuperstring(words1) << endl;

    // Test Case 2
    vector<string> words2 = {"abc", "def", "ghi", "jkl"};
    cout << "[abc, def, ghi, jkl] => " << solver.shortestSuperstring(words2) << endl;

    // Test Case 3
    vector<string> words3 = {"abc", "bcd", "cde", "def"};
    cout << "[abc, bcd, cde, def] => " << solver.shortestSuperstring(words3) << endl;

    return 0;
}
