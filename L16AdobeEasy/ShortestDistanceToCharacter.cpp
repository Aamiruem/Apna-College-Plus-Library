#include <iostream>
#include <vector>
#include <climits>
#include <algorithm>

using namespace std;

vector<int> shortestToChar(string s, char c)
{
    int n = s.length();
    vector<int> result(n, 0);
    int prev = INT_MIN / 2;

    // Left to right pass
    for (int i = 0; i < n; i++)
    {
        if (s[i] == c)
        {
            prev = i;
        }
        result[i] = i - prev;
    }

    // Right to left pass
    prev = INT_MAX / 2;
    for (int i = n - 1; i >= 0; i--)
    {
        if (s[i] == c)
        {
            prev = i;
        }
        result[i] = min(result[i], prev - i);
    }

    return result;
}

int main()
{
    string s = "loveleetcode";
    char c = 'e';
    vector<int> distances = shortestToChar(s, c);
    for (int dist : distances)
    {
        cout << dist << " ";
    }
    return 0;
}
