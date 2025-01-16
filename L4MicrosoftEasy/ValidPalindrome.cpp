// #include <iostream>
// #include <string>

// class ValidPalindrome
// {
// public:
//     bool isValidPalindrome(const std::string &s)
//     {
//         int start = 0, last = s.length() - 1;
//         while (start <= last)
//         {
//             if (s[start] != s[last])
//             {
//                 return false;
//             }
//             start++;
//             last--;
//         }
//         return true;
//     }
// };

// int main()
// {
//     ValidPalindrome vp;
//     std::string s = "A man, a plan, a canal: Panama";
//     std::cout << std::boolalpha << vp.isValidPalindrome(s) << std::endl; 
//     return 0;
// }




#include <iostream>
#include <string>
#include <cctype>

class ValidPalindrome
{
public:
    bool isValidPalindrome(const std::string &s)
    {
        int start = 0, last = s.length() - 1;
        while (start <= last)
        {
            // Skip non-alphanumeric characters
            while (start < last && !std::isalnum(s[start]))
            {
                start++;
            }
            while (start < last && !std::isalnum(s[last]))
            {
                last--;
            }
            // Compare characters (case-insensitive)
            if (std::tolower(s[start]) != std::tolower(s[last]))
            {
                return false;
            }
            start++;
            last--;
        }
        return true;
    }
};

int main()
{
    ValidPalindrome vp;
    std::string s = "A man, a plan, a canal: Panama";
    std::cout << std::boolalpha << vp.isValidPalindrome(s) << std::endl; // Output: true
    return 0;
}
