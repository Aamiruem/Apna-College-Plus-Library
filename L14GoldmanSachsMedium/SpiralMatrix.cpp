// #include <iostream>
// #include <vector>
// using namespace std;

// void printSpiralMatrix(int n)
// {
//     vector<vector<int> > matrix(n, vector<int>(n));
//     int value = 1, top = 0, bottom = n - 1, left = 0, right = n - 1;

//     while (value <= n * n)
//     {
//         for (int i = left; i <= right; i++)
//             matrix[top][i] = value++;
//         top++;
//         for (int i = top; i <= bottom; i++)
//             matrix[i][right] = value++;
//         right--;
//         for (int i = right; i >= left; i--)
//             matrix[bottom][i] = value++;
//         bottom--;
//         for (int i = bottom; i >= top; i--)
//             matrix[i][left] = value++;
//         left++;
//     }

//     // Print the matrix
//     for (const auto &row : matrix)
//     {
//         for (int num : row)
//             cout << num << "\t";
//         cout << endl;
//     }
// }

// int main()
// {
//     int n;
//     cout << "Enter matrix size (n): ";
//     cin >> n;
//     printSpiralMatrix(n);
//     return 0;
// }

#include <iostream>
#include <vector>
using namespace std;

void printSpiralMatrix(int n)
{
    // Create an n x n matrix initialized with zeros
    vector<vector<int> > matrix(n, vector<int>(n));
    int value = 1; // Counter to fill the matrix

    // Define boundaries of the matrix
    int top = 0, bottom = n - 1, left = 0, right = n - 1;

    // Fill the matrix in a spiral order
    while (value <= n * n)
    {
        // Fill top row (left to right)
        for (int i = left; i <= right; i++)
            matrix[top][i] = value++;
        top++; // Move the top boundary down

        // Fill right column (top to bottom)
        for (int i = top; i <= bottom; i++)
            matrix[i][right] = value++;
        right--; // Move the right boundary left

        // Fill bottom row (right to left)
        for (int i = right; i >= left; i--)
            matrix[bottom][i] = value++;
        bottom--; // Move the bottom boundary up

        // Fill left column (bottom to top)
        for (int i = bottom; i >= top; i--)
            matrix[i][left] = value++;
        left++; // Move the left boundary right
    }

    // Print the generated spiral matrix
    for (const auto &row : matrix)
    {
        for (int num : row)
            cout << num << "\t";
        cout << endl;
    }
}

int main()
{
    int n = 4;            // Fixed matrix size
    printSpiralMatrix(n); // Call function to generate and print matrix
    return 0;
}
