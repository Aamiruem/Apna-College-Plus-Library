// #include <iostream> // Added for cout
// #include <vector>
// #include <unordered_map>
// #include <string>

//    using namespace std;

//    class Solution
//    {
//    public:
//        int equalPairs(vector<vector<int> > &grid)
//        {
//            int n = grid.size(); // Get the size of the grid (number of rows/columns)

//            // Step 1: Create a hash map to store the frequency of each row as a string key
//            unordered_map<string, int> row_counts;
//            for (auto &row : grid) // Iterate through each row in the grid
//            {
//                string key;         // Create a string key to represent the row
//                for (int num : row) // Iterate through each number in the row
//                {
//                    key += to_string(num) + ","; // Append the number to the key, separated by commas
//                }
//                row_counts[key]++; // Increment the count for this row key in the hash map
//            }

//            // Step 2: Create a hash map to store the frequency of each column as a string key
//            unordered_map<string, int> col_counts;
//            for (int j = 0; j < n; ++j) // Iterate through each column index
//            {
//                string key;                 // Create a string key to represent the column
//                for (int i = 0; i < n; ++i) // Iterate through each row index to build the column
//                {
//                    key += to_string(grid[i][j]) + ","; // Append the number to the key, separated by commas
//                }
//                col_counts[key]++; // Increment the count for this column key in the hash map
//            }

//            // Step 3: Calculate the number of equal row-column pairs
//            int result = 0;
//            for (auto &[key, count] : row_counts) // Iterate through each row key and its count
//            {
//                if (col_counts.find(key) != col_counts.end()) // Check if the column hash map has the same key
//                {
//                    result += count * col_counts[key]; // Multiply the counts and add to the result
//                }
//            }
//            return result; // Return the total number of equal row-column pairs
//        }
//    };

//    int main()
//    {
//        // Example grid
//        vector<vector<int> > grid = {
//            {1, 2, 3},
//            {4, 5, 6},
//            {2, 5, 5}};

//        Solution solution;                                                                 // Create an instance of the Solution class
//        cout << "Number of equal row-column pairs: " << solution.equalPairs(grid) << endl; // Call the function and print the result

//        return 0; // Corrected return statement
//    }











#include <iostream>
#include <vector>

using namespace std;

// Function to compute the transpose of a matrix
vector<vector<int> > transpose(vector<vector<int> > &matrix)
{
    int rows = matrix.size();
    int cols = matrix[0].size();
    vector<vector<int> > result(cols, vector<int>(rows));

    for (int i = 0; i < cols; i++)
    {
        for (int j = 0; j < rows; j++)
        {
            result[i][j] = matrix[j][i]; // Corrected indexing
        }
    }
    return result;
}

// Function to count equal row-column pairs
int equalPairs(vector<vector<int> > &grid)
{
    int n = grid.size();
    vector<vector<int> > g = transpose(grid);
    int count = 0;

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if (grid[i] == g[j])
            { // Corrected comparison
                count++;
            }
        }
    }
    return count;
}

// Main function to test the program
int main()
{
    vector<vector<int> > grid = {
        {1, 2, 3},
        {4, 5, 6},
        {2, 5, 5}};

    cout << "Number of equal row-column pairs: " << equalPairs(grid) << endl;

    return 0;
}
