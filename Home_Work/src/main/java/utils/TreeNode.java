package utils;

public class TreeNode {
    int val;
    javax.swing.tree.TreeNode left;
    javax.swing.tree.TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, javax.swing.tree.TreeNode left, javax.swing.tree.TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
