#include <iostream>
#include <string>
using namespace std;

class GreatestCommonDivisorOfString
{
public:
    string gcdOfStrings(string str1, string str2)
    {
        if (str1.length() < str2.length())
        {
            return gcdOfStrings(str2, str1);
        }
        else if (str1.substr(0, str2.length()) != str2)
        {
            return "";
        }
        else if (str2.empty())
        {
            return str1;
        }
        else
        {
            return gcdOfStrings(str1.substr(str2.length()), str2);
        }
    }
};

int main()
{
    GreatestCommonDivisorOfString g;
    cout << g.gcdOfStrings("ABCABC", "ABC") << endl;  // Output: "ABC"
    cout << g.gcdOfStrings("ABABAB", "ABAB") << endl; // Output: "AB"
    cout << g.gcdOfStrings("LEET", "CODE") << endl;   // Output: ""

    // Test with large strings
    string str1(100000, 'a');
    string str2(100000, 'b');
    cout << g.gcdOfStrings(str1, str2) << endl; // Output: ""

    return 0;
}
