package Home_Work.leetcode_236;

import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LowestCommonAncestorOfABinaryTree01 {

    Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();
    Set<Integer> visited = new HashSet<Integer>();

//    //从根节点开始遍历整棵二叉树，用哈希表记录每个节点的父节点指针
//    public void dfs(TreeNode root) {
//        if (root.left != null) {
//            parent.put(root.left.val, root);
//            dfs(root.left);
//        }
//        if (root.right != null) {
//            parent.put(root.right.val, root);
//            dfs(root.right);
//        }
//    }
//
//    //们再从 q 节点开始不断往它的祖先移动，如果有祖先已经被访问过，即意味着这是 p 和 q 的深度最深的公共祖先，即 LCA 节点
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        dfs(root);
//        while (p != null) {
//            visited.add(p.val);
//            p = parent.get(p.val);
//        }
//        while (q != null) {
//            if (visited.contains(q.val)) {
//                return q;
//            }
//            q = parent.get(q.val);
//        }
//        return null;
//    }
}
