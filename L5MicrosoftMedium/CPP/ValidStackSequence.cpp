
#include <iostream>
#include <stack>
#include <vector>

using namespace std;

class Solution
{
public:
    bool validateStackSequences(vector<int> &pushed, vector<int> &popped)
    {
        stack<int> stack;
        int n = pushed.size();
        int j = 0;

        for (int i = 0; i < n; i++)
        {
            stack.push(pushed[i]); // Push the current element onto the stack

            // Pop elements from the stack if they match the popped sequence
            while (!stack.empty() && stack.top() == popped[j])
            {
                stack.pop();
                j++;
            }
        }

        // If the stack is empty and all elements are matched, return true
        return stack.empty() && j == n;
    }
};

int main()
{
    Solution solution;
    vector<int> pushed = {1, 2, 3, 4, 5};
    vector<int> popped = {4, 5, 3, 2, 1};
    cout << solution.validateStackSequences(pushed, popped) << endl; // Output: 1 (true)

    vector<int> pushed2 = {1, 2, 3, 4, 5};
    vector<int> popped2 = {4, 3, 5, 1, 2};
    cout << solution.validateStackSequences(pushed2, popped2) << endl; // Output: 0 (false)

    return 0;
}
