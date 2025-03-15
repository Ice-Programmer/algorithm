import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode：101. 对称二叉树
 *
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/15 12:31
 */
public class LeetCode101 {
    private boolean compare(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode != null) {
            return false;
        } else if (leftNode != null && rightNode == null) {
            return false;
        } else if (leftNode == null && rightNode == null) {
            return true;
        } else if (leftNode.val != rightNode.val) {
            return false;
        }

        // 左
        boolean outside = compare(leftNode.left, rightNode.right);
        boolean inside = compare(leftNode.right, rightNode.left);
        return outside && inside;
    }


    public boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
    }
}
