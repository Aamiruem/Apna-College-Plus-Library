#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

class Solution
{
public:
    string reverseStr(string s, int k)
    {
        int n = s.length();
        for (int i = 0; i < n; i += 2 * k)
        {
            int left = i;
            int right = min(i + k - 1, n - 1); // Ensure we don't go out of bounds
            reverse(s, left, right);
        }
        return s;
    }

private:
    void reverse(string &s, int left, int right)
    {
        while (left < right)
        {
            swap(s[left], s[right]);
            left++;
            right--;
        }
    }
};

int main()
{
    Solution solution;
    string s = "abcdefg";
    int k = 2;
    cout<<"Reversed string: " << solution.reverseStr(s, k) << endl; // Output: "bacdfeg"
    return 0;
}
