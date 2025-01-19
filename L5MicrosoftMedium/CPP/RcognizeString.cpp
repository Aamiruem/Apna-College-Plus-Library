#include <iostream>
#include <vector>
#include <queue>
#include <string>
#include <algorithm>

using namespace std;

class Solution
{
public:
    string reorganizeString(string s)
    {
        vector<int> charCounts(26, 0);

        // Count the frequency of each character
        for (char c : s)
        {
            charCounts[c - 'a']++;
        }

        // Max heap to store characters and their frequencies
        priority_queue<pair<int, char> > pq;

        // Add all characters with non-zero frequencies to the priority queue
        for (int i = 0; i < 26; i++)
        {
            if (charCounts[i] > 0)
            {
                pq.push({charCounts[i], i + 'a'});
            }
        }

        string str;

        // Initialize with the most frequent character
        auto block = pq.top();
        pq.pop();
        str += block.second;
        block.first--;

        while (!pq.empty())
        {
            auto next = pq.top();
            pq.pop();
            str += next.second;
            next.first--;

            // Re-add the previous block if it still has remaining frequency
            if (block.first > 0)
            {
                pq.push(block);
            }

            // Update the block to the current character
            block = next;
        }

        // If the last character still has remaining frequency, it's invalid
        if (block.first > 0)
        {
            return "";
        }

        return str;
    }
};

int main()
{
    Solution solution;
    cout << solution.reorganizeString("aab") << endl;  // Output: "aba"
    cout << solution.reorganizeString("aaab") << endl; // Output: ""
    return 0;
}
