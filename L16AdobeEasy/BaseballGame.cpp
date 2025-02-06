#include <iostream>
#include <vector>
#include <string>

using namespace std;

class Solution
{
public:
    int calPoints(vector<string> &ops)
    {
        vector<int> ans;

        for (int i = 0; i < ops.size(); i++)
        {
            if (ops[i] == "C")
            {
                if (!ans.empty())
                    ans.pop_back(); // Remove last valid score
            }
            else if (ops[i] == "D")
            {
                if (!ans.empty())
                    ans.push_back(2 * ans.back()); // Double last score
            }
            else if (ops[i] == "+")
            {
                if (ans.size() >= 2)
                {
                    int a = ans[ans.size() - 1];
                    int b = ans[ans.size() - 2];
                    ans.push_back(a + b); // Sum of last two scores
                }
            }
            else
            {
                ans.push_back(stoi(ops[i])); // Convert string to int and add to list
            }
        }

        int sum = 0;
        for (int i = 0; i < ans.size(); i++)
        {
            sum += ans[i]; // Sum all valid scores
        }

        return sum;
    }
};

int main()
{
    Solution sol;
    vector<string> ops = {"5", "2", "C", "D", "+"}; // Example test case
    cout << "Final Score: " << sol.calPoints(ops) << endl;
    return 0;
}
