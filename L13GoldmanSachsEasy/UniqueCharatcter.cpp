#include <iostream>
#include <string>
using namespace std;

int main()
{
    string s;
    cin >> s;
    int arr[26] = {0};

    // Count character frequencies
    for (char ch : s)
    {
        if (ch >= 'a' && ch <= 'z')
        { // Ensure valid lowercase character
            arr[ch - 'a']++;
        }
    }

    // Find the first unique character
    int ans = -1;
    for (int i = 0; i < s.length(); i++)
    {
        if (s[i] >= 'a' && s[i] <= 'z' && arr[s[i] - 'a'] == 1)
        {
            ans = i;
            break;
        }
    }

    cout << ans << endl;
    return 0;
}
