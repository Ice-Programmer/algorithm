/**
 * LeetCode：617.合并二叉树
 *
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/17 12:16
 */
public class LeetCode617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode root = new TreeNode();
        // 中
        root.val = root1.val + root2.val;
        // 左
        root.left = mergeTrees(root1.left, root2.left);
        // 右
        root.right = mergeTrees(root1.right, root2.right);

        return root;
    }
}
