/**
 * LeetCode：112. 路径总和
 *
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/17 10:28
 */
public class LeetCode112 {
    private boolean traversal(TreeNode root, int targetSum) {
        boolean isChildNode = root.left == null && root.right == null;
        if (isChildNode && targetSum == 0) {
            return true;
        }
        if (isChildNode && targetSum != 0) {
            return false;
        }
        // 左
        if (root.left != null) {
            targetSum = targetSum - root.left.val;
            if (traversal(root.left, targetSum)) {
                return true;
            }
            targetSum += root.left.val;
        }
        if (root.right != null) {
            targetSum = targetSum - root.right.val;
            if (traversal(root.right, targetSum)) {
                return true;
            }
            targetSum += root.right.val;
        }
        return false;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return traversal(root, targetSum - root.val);
    }
}
