#include <iostream>
#include <vector>
#include <string>
#include <unordered_map>
#include <climits>
using namespace std;

class Solution
{
public:
    vector<string> findRestaurant(vector<string> &list1, vector<string> &list2)
    {
        vector<string> res;
        unordered_map<string, int> m;
        int minSum = INT_MAX;

        // Store the index of each restaurant in list1 in a hashmap
        for (int i = 0; i < list1.size(); i++)
        {
            m[list1[i]] = i;
        }

        // Check each restaurant in list2
        for (int i = 0; i < list2.size(); i++)
        {
            if (m.count(list2[i]) != 0)
            {                              // If the restaurant is also in list1
                int sum = m[list2[i]] + i; // Calculate the index sum
                if (sum < minSum)
                {
                    minSum = sum;
                    res.clear();
                    res.push_back(list2[i]);
                }
                else if (sum == minSum)
                {
                    res.push_back(list2[i]);
                }
            }
        }
        return res;
    }
};

int main()
{
    vector<string> list1 = {"Shanghai", "Tokyo", "Paris", "Rome"};
    vector<string> list2 = {"London", "Tokyo", "Sydney", "Rome"};

    Solution solution;
    vector<string> result = solution.findRestaurant(list1, list2);

    // Print the result
    cout << "Common restaurants with smallest index sum: ";
    for (const string &restaurant : result)
    {
        cout << restaurant << " ";
    }
    cout << endl;

    return 0;
}

// Explanation :
// #include <iostream>: This includes the input-output stream library for using cout.

// #include <vector>: This includes the vector library for using vector.

// #include <string>: This includes the string library for using string.

// #include <unordered_map>: This includes the unordered map library for using unordered_map.

// #include <climits>: This includes the limits library to use INT_MAX for representing the maximum integer value.

//     using namespace std;: This line allows you to use the standard namespace, so you don't have to prefix std:: before standard library functions and objects.

// Class Solution:

// class Solution
// {: This defines a class named Solution.

// public:: This specifies that the following members (functions, variables) of the class are accessible from outside the class.

// Method findRestaurant:

// vector<string> findRestaurant(vector<string>& list1, vector<string>& list2)
//     {: This defines a method findRestaurant that takes two string vectors list1 and list2 by reference and returns a vector of strings.

// vector<string> res;: This declares a vector res to store the result.

// unordered_map<string, int> m;: This declares an unordered map m to map restaurant names to their indices in list1.

// int minSum = INT_MAX;: This initializes minSum to the maximum integer value to keep track of the minimum index sum.

// for (int i = 0; i < list1.size(); i++)
//         {
//             m[list1[i]] = i;
//         }: This loop stores the index of each restaurant in list1 in the map m.

// for (int i = 0; i < list2.size(); i++)
//         {: This loop iterates through each restaurant in list2.

// if (m.count(list2[i]) != 0)
//             {: This checks if the restaurant in list2 is also in list1.

// int sum = m[list2[i]] + i;: This calculates the index sum of the restaurant.

// if (sum < minSum)
//                 {
//                     minSum = sum;
//                     res.clear();
//                     res.push_back(list2[i]);
//                 }: If the index sum is smaller than minSum, update minSum, clear the result vector, and add the restaurant to it.

// else if (sum == minSum)
//                 {
//                     res.push_back(list2[i]);
//                 }: If the index sum is equal to minSum, add the restaurant to the result vector.

// return res;: This returns the result vector.

// Main Function:

// int main()
//                 {: This is the main function where the program execution starts.

// vector<string> list1 = {"Shanghai", "Tokyo", "Paris", "Rome"};: This initializes list1 with some restaurant names.

// vector<string> list2 = {"London", "Tokyo", "Sydney", "Rome"};: This initializes list2 with some restaurant names.

// Solution solution;: This creates an object of the Solution class.

// vector<string> result = solution.findRestaurant(list1, list2);: This calls the findRestaurant method and stores the result.

// cout << "Common restaurants with smallest index sum: ";: This prints a message to the console.

// for (const string& restaurant : result)
//                     {
//                         cout << restaurant << " ";
//                     }: This loops through the result vector and prints each restaurant name.

// cout << endl;: This prints a newline character.

// return 0;: This indicates that the program ended successfully.
//                 }: This closes the main function block.
