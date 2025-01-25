
import java.util.ArrayList;

class TreeNode {

    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class KthSmallestInBST {

    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> lst = new ArrayList<>();
        inorder(root, lst);
        return lst.get(k - 1);
    }

    private void inorder(TreeNode root, ArrayList<Integer> lst) {
        if (root == null) {
            return;
        }
        inorder(root.left, lst);
        lst.add(root.val);
        inorder(root.right, lst);
    }

    public static void main(String[] args) {
        // Create the BST
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        KthSmallestInBST obj = new KthSmallestInBST();

        // Test cases
        System.out.println(obj.kthSmallest(root, 1)); // Output: 1
        System.out.println(obj.kthSmallest(root, 3)); // Output: 3
        System.out.println(obj.kthSmallest(root, 5)); // Output: 5
    }
}
