package Home_Work.leetcode_98;

import utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class ValidateBinarySearchTree01 {

    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        double inorder = -Double.MAX_VALUE;

//        while (!stack.isEmpty() || root != null) {
//            while (root != null) {
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop();
//            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
//            if (root.val <= inorder) {
//                return false;
//            }
//            inorder = root.val;
//            root = root.right;
//        }
        return true;
    }

    public static void main(String[] args) {
        ValidateBinarySearchTree01 validateBinarySearchTree01 = new ValidateBinarySearchTree01();
//        validateBinarySearchTree01.isValidBST();
    }
}
