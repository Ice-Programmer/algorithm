/**
 * LeetCode：235. 二叉搜索树的最近公共祖先
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/18 11:39
 */
public class LeetCode235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            TreeNode temp = p;
            p = q;
            q = temp;
        }

        while (root != null) {
            if (root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}
