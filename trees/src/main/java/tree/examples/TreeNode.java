package tree.examples;

public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this(val, null, null);
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + (left != null ? left.val : null) +
                ", right=" + (right != null ? right.val : null)  +
                '}';
    }
}

