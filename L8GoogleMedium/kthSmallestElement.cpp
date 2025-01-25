#include <iostream>
#include <vector>

using namespace std;

struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;

    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

class KthSmallestInBST
{
public:
    int kthSmallest(TreeNode *root, int k)
    {
        vector<int> lst;
        inorder(root, lst);
        return lst[k - 1];
    }

private:
    void inorder(TreeNode *root, vector<int> &lst)
    {
        if (!root)
            return;
        inorder(root->left, lst);
        lst.push_back(root->val);
        inorder(root->right, lst);
    }
};

int main()
{
    // Create the BST
    TreeNode *root = new TreeNode(5);
    root->left = new TreeNode(3);
    root->right = new TreeNode(6);
    root->left->left = new TreeNode(2);
    root->left->right = new TreeNode(4);
    root->left->left->left = new TreeNode(1);

    KthSmallestInBST obj;

    // Test cases
    cout << obj.kthSmallest(root, 1) << endl; // Output: 1
    cout << obj.kthSmallest(root, 3) << endl; // Output: 3
    cout << obj.kthSmallest(root, 5) << endl; // Output: 5

    return 0;
}
