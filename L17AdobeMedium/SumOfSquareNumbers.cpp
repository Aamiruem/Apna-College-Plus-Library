#include <iostream>
#include <cmath>

using namespace std;

class Solution
{
public:
    bool judgeSquareSum(int c)
    {
        if (c < 0)
            return false;

        long left = 0;
        long right = sqrt(c);

        while (left <= right)
        {
            long sum = left * left + right * right;

            if (sum == c)
            {
                return true;
            }
            else if (sum < c)
            {
                left++;
            }
            else
            {
                right--;
            }
        }

        return false;
    }
};

int main()
{
    Solution solution;
    int c;

    cout << "Enter a number: ";
    cin >> c;

    if (solution.judgeSquareSum(c))
    {
        cout << "Yes, " << c << " can be expressed as the sum of two squares." << endl;
    }
    else
    {
        cout << "No, " << c << " cannot be expressed as the sum of two squares." << endl;
    }

    return 0;
}
