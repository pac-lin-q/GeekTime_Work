package Home_Work.leetcode_226;

/**
 * 翻转一棵二叉树。
 * 示例：
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
public class InvertBinaryTree01 {

    public javax.swing.tree.TreeNode invertTree(javax.swing.tree.TreeNode root) {
        if (root == null) {
            return null;
        }
//        TreeNode left = invertTree(root.left);
//        TreeNode right = invertTree(root.right);
//        root.left=right;
//        root.right=left;
        return root;
    }

    public static void main(String[] args) {
        InvertBinaryTree01 invertBinaryTree01 = new InvertBinaryTree01();
//        System.out.println(invertBinaryTree01.invertTree();
    }
}
