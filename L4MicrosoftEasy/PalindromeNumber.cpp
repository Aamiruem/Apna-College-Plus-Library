#include <iostream>
#include <vector>
#include <string>
using namespace std;

class PalindromeNumber
{
public:
    bool isPalindrome(int x)
    {
        if (x < 0)
        {
            return false;
        }
        int rev = 0;
        int temp = x;
        while (temp != 0)
        {
            int digit = temp % 10;
            rev = rev * 10 + digit;
            temp = temp / 10;
        }
        return x == rev;
    }
};

int main()
{
    PalindromeNumber p;
    int x = 121;
    cout << boolalpha << p.isPalindrome(x) << endl;
    return 0;
}
