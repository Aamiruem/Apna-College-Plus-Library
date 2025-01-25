#include <iostream>
#include <unordered_set>
#include <vector>

class LongestConsecutiveSequence
{
public:
    int longestConsecutive(const std::vector<int> &nums)
    {
        std::unordered_set<int> set(nums.begin(), nums.end());
        int longest = 0;

        for (int num : nums)
        {
            if (set.find(num - 1) == set.end())
            {
                int current = num;
                int count = 1;

                while (set.find(current + 1) != set.end())
                {
                    current++;
                    count++;
                }
                longest = std::max(longest, count);
            }
        }
        return longest;
    }
};

int main()
{
    LongestConsecutiveSequence s;

    std::vector<int> nums1 = {100, 4, 200, 1, 3, 2};
    int expected1 = 4;
    int actual1 = s.longestConsecutive(nums1);
    std::cout << "Length of the longest consecutive sequence: " << actual1 << std::endl;
    if (actual1 == expected1)
    {
        std::cout << "Test case 1 passed!" << std::endl;
    }
    else
    {
        std::cout << "Test case 1 failed!" << std::endl;
    }
    std::cout << std::endl;

    std::vector<int> nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
    int expected2 = 9;
    int actual2 = s.longestConsecutive(nums2);
    std::cout << "Length of the longest consecutive sequence: " << actual2 << std::endl;
    if (actual2 == expected2)
    {
        std::cout << "Test case 2 passed!" << std::endl;
    }
    else
    {
        std::cout << "Test case 2 failed!" << std::endl;
    }
    std::cout << std::endl;

    std::vector<int> nums3 = {1, 2, 0, 1};
    int expected3 = 3;
    int actual3 = s.longestConsecutive(nums3);
    std::cout << "Length of the longest consecutive sequence: " << actual3 << std::endl;
    if (actual3 == expected3)
    {
        std::cout << "Test case 3 passed!" << std::endl;
    }
    else
    {
        std::cout << "Test case 3 failed!" << std::endl;
    }
    std::cout << std::endl;

    return 0;
}
