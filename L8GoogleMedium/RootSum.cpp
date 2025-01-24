#include <iostream>
using namespace std;

struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;

    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

class RootSum
{
public:
    int leafSum(TreeNode *root)
    {
        return sumNodes(root, 0);
    }

private:
    int sumNodes(TreeNode *root, int currSum)
    {
        if (root == nullptr)
        {
            return 0;
        }
        currSum = currSum * 10 + root->val;
        if (root->left == nullptr && root->right == nullptr)
        {
            return currSum;
        }
        int leftSum = sumNodes(root->left, currSum);
        int rightSum = sumNodes(root->right, currSum);
        return leftSum + rightSum;
    }
};

int main()
{
    RootSum rootSum;

    // Test case 1
    TreeNode *root = new TreeNode(4);
    root->left = new TreeNode(9);
    root->right = new TreeNode(0);
    root->left->left = new TreeNode(5);
    root->left->right = new TreeNode(1);
    cout << "Test case 1: Sum of Numbers: " << rootSum.leafSum(root) << endl; // Expected: 1026

    // Test case 2
    TreeNode *root2 = new TreeNode(1);
    root2->left = new TreeNode(2);
    root2->right = new TreeNode(3);
    cout << "Test case 2: Sum of Numbers: " << rootSum.leafSum(root2) << endl; // Expected: 25

    // Test case 3
    TreeNode *root3 = new TreeNode(0);
    cout << "Test case 3: Sum of Numbers: " << rootSum.leafSum(root3) << endl; // Expected: 0

    return 0;
}
