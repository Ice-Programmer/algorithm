import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode：530.二叉搜索树的最小绝对差
 *
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/18 10:15
 */
public class LeetCode530 {
    int result = Integer.MAX_VALUE;
    TreeNode preNode = null;

    private void traversal(TreeNode current) {
        if (current == null) {
            return;
        }
        // 左
        traversal(current.left);
        // 中
        if (preNode != null) {
            result = Math.min(result, Math.abs(current.val - preNode.val));
        }
        preNode = current;
        // 右
        traversal(current.right);
    }

    public int getMinimumDifference(TreeNode root) {
        traversal(root);
        return result;
    }
}
