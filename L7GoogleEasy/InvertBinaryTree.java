

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode temp;

        // Swapping left and right child
        temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively inverting left and right child
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }


    public void inOrderTraversal(TreeNode root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.val + " ");
            inOrderTraversal(root.right);
        }
    }

    // Constructs a sample binary tree:
    //       4
    //     /   \
    //    2     7
    //   / \   / \
    //  1   3 6   9

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        InvertBinaryTree tree = new InvertBinaryTree();

        System.out.println("Original tree (in-order):");
        tree.inOrderTraversal(root);

        tree.invertTree(root);

        System.out.println("\nInverted tree (in-order):");
        tree.inOrderTraversal(root);

        // Invert the tree again to get the original structure
        tree.invertTree(root);
        System.out.println("\nOriginal tree (in-order):");
        tree.inOrderTraversal(root);

        
    }
}


        
        

        // Calls invertTree to invert the tree
        // . The resulting tree will look like
            //       4
            //     /   \
            //    7     2
            //   / \   / \
            //  9   6 3   1




    
