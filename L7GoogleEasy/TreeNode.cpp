#include <iostream>
#include <queue>
using namespace std;

class TreeNode
{
public:
    int val;
    TreeNode *left;
    TreeNode *right;

    TreeNode(int val)
    {
        this->val = val;
        this->left = nullptr;
        this->right = nullptr;
    }
};

class InvertBinaryTrees
{
public:
    TreeNode *invertTree(TreeNode *root)
    {
        if (root == nullptr)
        {
            return root;
        }

        // Swapping left and right child
        TreeNode *temp = root->left;
        root->left = root->right;
        root->right = temp;

        // Recursively inverting left and right child
        invertTree(root->left);
        invertTree(root->right);

        return root;
    }

    void printTree(TreeNode *root)
    {
        if (root == nullptr)
        {
            return;
        }

        queue<TreeNode *> q;
        q.push(root);

        while (!q.empty())
        {
            int size = q.size();
            for (int i = 0; i < size; ++i)
            {
                TreeNode *curr = q.front();
                q.pop();
                cout << curr->val << " ";
                if (curr->left != nullptr)
                {
                    q.push(curr->left);
                }
                if (curr->right != nullptr)
                {
                    q.push(curr->right);
                }
            }
            cout << endl;
        }
    }
};

int main()
{
    // Test case 1
    TreeNode *root1 = new TreeNode(4);
    root1->left = new TreeNode(2);
    root1->right = new TreeNode(7);
    root1->left->left = new TreeNode(1);
    root1->left->right = new TreeNode(3);
    root1->right->left = new TreeNode(6);
    root1->right->right = new TreeNode(9);

    InvertBinaryTrees sol;
    cout << "Test case 1: " << endl;
    cout << "Previous Tree: " << endl;
    sol.printTree(root1);
    TreeNode *ans1 = sol.invertTree(root1);
    cout << "Inverted Tree: " << endl;
    sol.printTree(ans1);

    // Test case 2
    TreeNode *root2 = new TreeNode(2);
    root2->left = new TreeNode(1);
    root2->right = new TreeNode(3);

    cout << "Test case 2: " << endl;
    cout << "Previous Tree: " << endl;
    sol.printTree(root2);
    TreeNode *ans2 = sol.invertTree(root2);
    cout << "Inverted Tree: " << endl;
    sol.printTree(ans2);

    return 0;
}
