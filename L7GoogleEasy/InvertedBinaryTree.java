

// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;

//     TreeNode(int val) {
//         this.val = val;
//         this.left = null;
//         this.right = null;
//     }
// }

// public class InvertBinaryTree {
//     public TreeNode invertTree(TreeNode root) {
//         if (root == null) {
//             return root;
//         }
//         TreeNode temp;

//         // Swapping left and right child
//         temp = root.left;
//         root.left = root.right;
//         root.right = temp;

//         // Recursively inverting left and right child
//         invertTree(root.left);
//         invertTree(root.right);

//         return root;
//     }


//     public void inOrderTraversal(TreeNode root) {
//         if (root != null) {
//             inOrderTraversal(root.left);
//             System.out.print(root.val + " ");
//             inOrderTraversal(root.right);
//         }
//     }

//     // Constructs a sample binary tree:
//     //       4
//     //     /   \
//     //    2     7
//     //   / \   / \
//     //  1   3 6   9

//     public static void main(String[] args) {
//         TreeNode root = new TreeNode(4);
//         root.left = new TreeNode(2);
//         root.right = new TreeNode(7);
//         root.left.left = new TreeNode(1);
//         root.left.right = new TreeNode(3);
//         root.right.left = new TreeNode(6);
//         root.right.right = new TreeNode(9);

//         InvertBinaryTree tree = new InvertBinaryTree();

//         System.out.println("Original tree (in-order):");
//         tree.inOrderTraversal(root);

//         tree.invertTree(root);

//         System.out.println("\nInverted tree (in-order):");
//         tree.inOrderTraversal(root);

//         // Invert the tree again to get the original structure
//         tree.invertTree(root);
//         System.out.println("\nOriginal tree (in-order):");
//         tree.inOrderTraversal(root);


//     }
// }


//         // Calls invertTree to invert the tree
//         // . The resulting tree will look like
//             //       4
//             //     /   \
//             //    7     2
//             //   / \   / \
//             //  9   6 3   1




    
















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

public class InvertedBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        // Swapping left and right child
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively inverting left and right child
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        // In-order traversal
        printTree(root.left);
        System.out.print(root.val + " ");
        printTree(root.right);
    }

    public static void main(String[] args) {
        // Test case 1
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(9);

        InvertedBinaryTree sol = new InvertedBinaryTree();

        System.out.println("Test case 1:");
        System.out.println("Previous Tree:");
        printTree(root1);

        TreeNode ans1 = sol.invertTree(root1);

        System.out.println("\nInverted Tree:");
        printTree(ans1);
    }
}
