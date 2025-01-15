#include <iostream>
#include <stack>
#include <string>
using namespace std;

int findMaxLen(string str)
{
    int n = str.length();
    stack<int> st;
    st.push(-1); // Initialize the stack with -1 to handle the base case
    int ans = 0;

    for (int i = 0; i < n; i++)
    {
        if (str[i] == '(')
        {
            st.push(i); // Push the index of '('
        }
        else
        {
            st.pop(); // Pop for ')'
            if (st.empty())
            {
                st.push(i); // Push current index as a base for future matches
            }
            else
            {
                ans = max(ans, i - st.top()); // Calculate the length
            }
        }
    }
    return ans;
}

int main()
{
    string str = ")()())";
    cout << findMaxLen(str) << endl; // Output: 4
    return 0;
}
