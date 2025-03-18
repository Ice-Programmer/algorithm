/**
 * LeetCode：701.二叉搜索树中的插入操作
 *
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/18 11:51
 */
public class LeetCode701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode insertNode = new TreeNode(val);
        if (root == null) {
            return insertNode;
        }

        TreeNode current = root;
        TreeNode pre = null;
        while (current != null) {
            pre = current;
            if (val > current.val) {
                current = current.right;
            } else if (val < current.val) {
                current = current.left;
            }
        }

        if (val > pre.val) {
            pre.right = insertNode;
        } else {
            pre.left = insertNode;
        }
        return root;
    }
}
