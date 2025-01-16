#include <iostream>
#include <vector>
using namespace std;

class SignOfProduct
{
public:
    int arraySignOfProduct(const std::vector<int> &nums)
    {
        int count = 0;
        for (int num : nums)
        {
            if (num == 0)
            {
                return 0;
            }
            else if (num < 0)
            {
                count++;
            }
        }
        return (count % 2 == 1) ? -1 : 1;
    }
};

int main()
{
    SignOfProduct sp;
    vector<int> nums = {1, 2, 3, 4, 5};
    cout << sp.arraySignOfProduct(nums) << endl;
    return 0;
}
