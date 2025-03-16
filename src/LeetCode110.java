/**
 * LeetCode：110.平衡二叉树
 *
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/16 20:33
 */
public class LeetCode110 {
    private int getHeight(TreeNode current) {
        if (current == null) {
            return 0;
        }
        // 左
        int leftHeight = getHeight(current.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = getHeight(current.right);
        if (rightHeight == -1) {
            return -1;
        }
        int result = Math.abs(leftHeight - rightHeight);
        if (result > 1) {
            return -1;
        } else {
            return 1 + Math.max(leftHeight, rightHeight);
        }
    }

    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }
}
