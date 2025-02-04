#include <iostream>
#include <unordered_map>
#include <string>
#include <cmath>

using namespace std;

string fractionToDecimal(int numerator, int denominator)
{
    if (numerator == 0)
        return "0"; // If numerator is 0, result is "0"

    string result;

    // Determine the sign of the result
    if ((numerator < 0) ^ (denominator < 0))
    {
        result += "-";
    }

    // Convert numerator and denominator to long long to handle overflow
    long long num = abs((long long)numerator);
    long long den = abs((long long)denominator);

    // Compute the integer part of the result
    result += to_string(num / den);
    long long remainder = num % den;

    if (remainder == 0)
    {
        return result; // If no remainder, return the integer result
    }

    // Otherwise, process the fractional part
    result += ".";
    unordered_map<long long, int> remainderMap; // Store remainder positions

    while (remainder != 0)
    {
        if (remainderMap.find(remainder) != remainderMap.end())
        {
            // If remainder repeats, insert parentheses at the start of repetition
            result.insert(remainderMap[remainder], "(");
            result += ")";
            break;
        }

        // Store the position of this remainder
        remainderMap[remainder] = result.size();

        // Multiply remainder by 10 and append next digit
        remainder *= 10;
        result += to_string(remainder / den);
        remainder %= den;
    }

    return result;
}

int main()
{
    cout << fractionToDecimal(1, 2) << endl;   // Output: "0.5"
    cout << fractionToDecimal(2, 3) << endl;   // Output: "0.(6)"
    cout << fractionToDecimal(4, 333) << endl; // Output: "0.(012)"
    cout << fractionToDecimal(-50, 8) << endl; // Output: "-6.25"
    return 0;
}
