#include <iostream>
#include <vector>
#include <string>
using namespace std;

class GenerateParentheses
{
public:
    vector<string> generateParenthesis(int n)
    {
        vector<string> ans;
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

private:
    void backtrack(vector<string> &ans, string current, int open, int close, int max)
    {
        if (current.length() == max * 2)
        {
            ans.push_back(current);
            return;
        }

        if (open < max)
        {
            backtrack(ans, current + "(", open + 1, close, max);
        }
        if (close < open)
        {
            backtrack(ans, current + ")", open, close + 1, max);
        }
    }
};

int main()
{
    GenerateParentheses gp;
    int n = 3;
    vector<string> result = gp.generateParenthesis(n);

    cout << "Generated Parentheses Combinations:" << endl;
    for (const string &s : result)
    {
        cout << s << endl;
    }

    return 0;
}
