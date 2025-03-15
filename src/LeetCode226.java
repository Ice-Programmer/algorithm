/**
 * LeetCode：226.翻转二叉树
 *
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/15 11:26
 */
public class LeetCode226 {

    private void swap(TreeNode current) {
        TreeNode temp = current.left;
        current.left = current.right;
        current.right = temp;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        swap(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
