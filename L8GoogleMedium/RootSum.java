
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class RootSum {

    public int leafSum(TreeNode root) {
        return sumNodes(root, 0);
    }

    private int sumNodes(TreeNode root, int currSum) {
        if (root == null) {
            return 0;
        }
        currSum = currSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return currSum;
        }
        int leftSum = sumNodes(root.left, currSum);
        int rightSum = sumNodes(root.right, currSum);
        return leftSum + rightSum;
    }

    public static void main(String[] args) {
        RootSum rootSum = new RootSum();

        // Test case 1
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        System.out.println("Test case 1: Sum of Numbers: " + rootSum.leafSum(root)); // Expected: 1026

        // Test case 2
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        System.out.println("Test case 2: Sum of Numbers: " + rootSum.leafSum(root2)); // Expected: 25

        // Test case 3
        TreeNode root3 = new TreeNode(0);
        System.out.println("Test case 3: Sum of Numbers: " + rootSum.leafSum(root3)); // Expected: 0
    }
}
