#include <iostream>
#include <string>
#include <climits>

using namespace std;

class StringToInteger
{
public:
    int myAtoi(string s)
    {
        int i = 0, ans = 0, sign = 1;

        // Skip leading whitespaces
        while (i < s.length() && s[i] == ' ')
        {
            i++;
        }

        // Check if the string is empty after removing spaces
        if (i == s.length())
            return 0;

        // Handle optional sign
        if (s[i] == '-')
        {
            sign = -1;
            i++;
        }
        else if (s[i] == '+')
        {
            i++;
        }

        // Convert digits to integer
        while (i < s.length() && isdigit(s[i]))
        {
            int digit = s[i] - '0';

            // Check for overflow
            if (ans > INT_MAX / 10 || (ans == INT_MAX / 10 && digit > INT_MAX % 10))
            {
                return sign == 1 ? INT_MAX : INT_MIN;
            }

            ans = ans * 10 + digit;
            i++;
        }

        return ans * sign;
    }
};

int main()
{
    StringToInteger obj;

    // Test cases
    cout << obj.myAtoi("42") << endl;              // Output: 42
    cout << obj.myAtoi("   -42") << endl;          // Output: -42
    cout << obj.myAtoi("4193 with words") << endl; // Output: 4193
    cout << obj.myAtoi("words and 987") << endl;   // Output: 0
    cout << obj.myAtoi("-91283472332") << endl;    // Output: -2147483648

    return 0;
}
