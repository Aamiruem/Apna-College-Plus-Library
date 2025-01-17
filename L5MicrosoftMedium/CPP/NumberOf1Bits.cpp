#include <iostream>
using namespace std;

class NumberOf1Bits
{
public:
    // Method to count the number of 1 bits in an integer
    int hammingWeight(int n)
    {
        int count = 0; // Initialize the count of 1 bits
        while (n != 0)
        {
            count += n & 1; // Check the least significant bit
            n >>= 1;        // Right shift to process the next bit
        }
        return count;
    }
};

int main()
{
    NumberOf1Bits obj;
    int n = 11;                                              // Binary representation: 1011
    cout << "Number of 1 bits: " << obj.hammingWeight(n) << endl; // Output: 3
    return 0;
}
