#include <bits/stdc++.h>
using namespace std;

// Trie Node Definition
class TrieNode
{
public:
    bool isWord;
    TrieNode *children[26];

    TrieNode()
    {
        isWord = false;
        for (int i = 0; i < 26; i++)
        {
            children[i] = nullptr;
        }
    }
};

// Function to add a word to the Trie
void addWord(TrieNode &root, const string &word)
{
    TrieNode *cur = &root;
    for (char ch : word)
    {
        int idx = ch - 'a';
        if (cur->children[idx] == nullptr)
        {
            cur->children[idx] = new TrieNode();
        }
        cur = cur->children[idx];
    }
    cur->isWord = true;
}

// Function to get words from the Trie
void getWords(TrieNode &root, const string &prefix, vector<string> &res, int &k)
{
    if (k == 0)
        return;

    if (root.isWord)
    {
        k--;
        res.push_back(prefix);
        if (k == 0)
            return;
    }

    for (int i = 0; i < 26; i++)
    {
        if (root.children[i] != nullptr)
        {
            getWords(*root.children[i], prefix + (char)('a' + i), res, k);
        }
    }
}

int main()
{
    int k = 2;
    vector<string> words = {"i", "love", "leetcode", "i", "love", "coding"};
    int n = words.size();

    unordered_map<string, int> freqMap;
    for (const string &word : words)
    {
        freqMap[word]++;
    }

    vector<string> res;
    TrieNode trie;
    vector<TrieNode> bucket(n + 1, TrieNode());

    for (auto &p : freqMap)
    {
        addWord(bucket[p.second], p.first);
    }

    for (int i = n; i >= 0 && k > 0; i--)
    {
        getWords(bucket[i], "", res, k);
    }

    for (const string &word : res)
    {
        cout << word << " ";
    }

    return 0;
}
