#include <string>
#include <iostream>
using namespace std;

class Solution
{
public:
    string toLowerCase(string s)
    {
        for (int i = 0; i < s.size(); i++)
        {
            if (s[i] >= 'A' && s[i] <= 'Z')
            {
                s[i] = s[i] + 32; // Convert to lowercase
            }
        }
        return s;
    }
};

int main()
{
    string input = "Hello, World!";
    Solution solution;
    string result = solution.toLowerCase(input);
    cout << "Lowercased string: " << result << endl;
    return 0;
}







// Explanation of Each Line
// 1. #include <string>
// This line includes the C++ Standard Library's string header, which provides the std::string class and related functions for working with strings.

// 2. #include <iostream>
// This line includes the C++ Standard Library's iostream header, which provides input/output functionality, such as cout for printing to the console.

// 3. using namespace std;
// This line brings the std namespace into scope, so you don't need to prefix standard library types and functions with std:: (e.g., std::string becomes string).

// 4. class Solution {
// This defines a class named Solution. Classes in C++ are used to encapsulate data and functions that operate on that data.

// 5. public:
// This keyword specifies that the following members of the class (functions or variables) are accessible from outside the class.

// 6. string toLowerCase(string s) {
// This defines a public member function named toLowerCase that takes a string as input and returns a string. The purpose of this function is to convert the input string to lowercase.

// 7. for (int i = 0; i < s.size(); i++) {
// This starts a for loop that iterates over each character in the string s. The loop variable i is initialized to 0, and the loop continues as long as i is less than the size of the string (s.size()).

// 8. if (s[i] >= 'A' && s[i] <= 'Z') {
// This if statement checks if the current character s[i] is an uppercase letter. In ASCII, uppercase letters A to Z have values from 65 to 90.

// 9. s[i] = s[i] + 32;
// If the character is uppercase, this line converts it to lowercase by adding 32 to its ASCII value. In ASCII, the difference between uppercase and lowercase letters is 32 (e.g., A is 65, and a is 97).

// 10. }
// This closes the if block.

// 11. }
// This closes the for loop.

// 12. return s;
// This returns the modified string s (now in lowercase) as the result of the toLowerCase function.

// 13. };
// This closes the Solution class definition.

// 14. int main() {
// This defines the main function, which is the entry point of the program.

// 15. string input = "Hello, World!";
// This declares a string variable named input and initializes it with the value "Hello, World!".

// 16. Solution solution;
// This creates an instance of the Solution class named solution.

// 17. string result = solution.toLowerCase(input);
// This calls the toLowerCase function on the solution object, passing the input string as an argument. The result (the lowercase string) is stored in the result variable.

// 18. cout << "Lowercased string: " << result << endl;
// This prints the string "Lowercased string: " followed by the value of result (the lowercase string) to the console. The endl inserts a newline character.

// 19. return 0;
// This indicates that the program has executed successfully and returns 0 to the operating system.

// 20. }
// This closes the main function.

// Output
// For the input string "Hello, World!", the output will be:

// Copy
// Lowercased string: hello, world!
// Key Fixes in the Code
// Fixed the loop variable name from 1 to i.

// Fixed the string size access from s.size) to s.size().

// Fixed the array access from s(1] to s[i].

// Fixed the return statement placement.

// Fixed the main function to properly call the toLowerCase method and print the result.

