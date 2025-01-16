#include <iostream>
#include <string>

class DefangingIPAddress
{
public:
    static std::string defangIPAddress(const std::string &address)
    {
        std::string result;
        for (char ch : address)
        {
            if (ch == '.')
            {
                result += "[.]";
            }
            else
            {
                result += ch;
            }
        }
        return result;
    }
};

int main()
{
    std::string address = "1.1.1.1";
    std::cout << DefangingIPAddress::defangIPAddress(address) << std::endl; // Output: "1[.]1[.]1[.]1"
    return 0;
}
