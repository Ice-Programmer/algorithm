/**
 * LeetCode：236. 二叉树的最近公共祖先
 *
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/18 11:15
 */
public class LeetCode236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        // 当前节点是 p 或 q，直接返回
        if (root == p || root == q) return root;

        // 递归左子树和右子树
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 左右子树均找到 p 或 q，当前节点是 LCA
        if (left != null && right != null) return root;
        // 否则返回非空的一侧结果
        return left != null ? left : right;
    }
}
