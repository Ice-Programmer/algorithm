/**
 * LeetCode：404.左叶子之和
 *
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/16 21:32
 */
public class LeetCode404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }
        // 左
        int leftNum = sumOfLeftLeaves(root.left);
        if (root.left != null && root.left.left == null && root.left.right == null) {
            leftNum = root.left.val;
        }
        // 右
        int rightNum = sumOfLeftLeaves(root.right);
        return leftNum + rightNum;
    }
}
