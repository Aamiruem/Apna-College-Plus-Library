
import java.util.LinkedList;
import java.util.Queue;
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

public class InvertBinaryTrees {

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

    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        @SuppressWarnings("Convert2Diamond")
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                System.out.print(curr.val + " ");
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(9);
        InvertBinaryTrees sol = new InvertBinaryTrees();
        System.out.println("Test case1: ");
        System.out.println("Previous Tree: ");
        printTree(root1);
        TreeNode ans1 = sol.invertTree(root1);
        System.out.println("Inverted Tree: ");
        printTree(ans1);


        //Test case 2
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        InvertBinaryTrees sol2 = new InvertBinaryTrees();
        System.out.println("Test case2: ");
        System.out.println("Previous Tree: ");
        printTree(root2);
        TreeNode ans2 = sol2.invertTree(root2);
        System.out.println("Inverted Tree: ");
        printTree(ans2);
    }
}
