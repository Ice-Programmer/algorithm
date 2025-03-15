/**
 * LeetCode：111.二叉树的最小深度
 *
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/15 13:37
 */
public class LeetCode111 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int minLeft = minDepth(root.left);
        int minRight = minDepth(root.right);
        if (root.left == null && root.right != null) {
            return 1 + minRight;
        } else if (root.left != null && root.right == null) {
            return 1 + minLeft;
        } else {
            return Math.min(minLeft, minRight) + 1;
        }
    }
}
