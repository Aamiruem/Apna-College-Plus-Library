// #include <iostream>
// #include <string>

// using namespace std;
// class NumberSubstring
// {
// public:
//     int numSub(string s)
//     {
//         int mod = 1000000007;
//         long count = 0;
//         long ans = 0;
//         for (int i = 0; i < s.size(); i++)
//         {
//             if (s[i] == '1')
//             {
//                 count++;
//             }
//             else
//             {
//                 long add = (count * (count + 1)) / 2;
//                 add = add % mod;
//                 ans = (ans + add) % mod;
//                 count = 0;
//             }
//         }
//         long add = (count * (count + 1)) / 2;
//         add = add % mod;
//         ans = (ans + add) % mod;
//         return (int)ans;
//     }
//     void test()
//     {
//         string s = "0110111";
//         cout << numSub(s) << endl;
//     }
// };




#include <iostream>
#include <string>

using namespace std;

class NumberSubstring
{
public:
    int numSub(string s)
    {
        const int MOD = 1000000007; // Modulo value
        long count = 0, totalSubstrings = 0;

        for (char c : s)
        {
            if (c == '1')
            {
                count++; // Count consecutive '1's
            }
            else
            {
                totalSubstrings = (totalSubstrings + calculateSum(count)) % MOD;
                count = 0; // Reset count when a '0' is encountered
            }
        }

        // Add substrings from the last block of '1's
        totalSubstrings = (totalSubstrings + calculateSum(count)) % MOD;

        return static_cast<int>(totalSubstrings);
    }

    void test()
    {
        string s = "0110111";
        cout << "Number of substrings of '1': " << numSub(s) << endl;
    }

private:
    // Helper function to calculate the sum of substrings for a block of '1's
    long calculateSum(long count)
    {
        return (count * (count + 1) / 2) % 1000000007;
    }
};

int main()
{
    NumberSubstring ns;
    ns.test();
    return 0;
}
