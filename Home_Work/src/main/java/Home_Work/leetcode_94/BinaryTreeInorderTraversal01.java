package Home_Work.leetcode_94;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 */
public class BinaryTreeInorderTraversal01 {
    //定义结果集
    List<Integer> result =new ArrayList<Integer>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
    }

    public List<Integer> inorder(TreeNode root) {
        if (root == null) {
            return result;
        }
        inorder(root.left);
        result.add(root.val);
        inorder(root.right);
    }

    public static void main(String[] args) {
        BinaryTreeInorderTraversal01 binaryTreeInorderTraversal01 = new BinaryTreeInorderTraversal01();
        System.out.println(binaryTreeInorderTraversal01.inorderTraversal());
    }
}
