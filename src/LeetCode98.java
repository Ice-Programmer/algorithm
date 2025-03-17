import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode：98.验证二叉搜索树
 *
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/17 12:46
 */
public class LeetCode98 {
    long maxValue = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 左
        boolean left = isValidBST(root.left);
        // 中
        if (root.val > maxValue) {
            maxValue = root.val;
        } else {
            return false;
        }
        // 右
        boolean right = isValidBST(root.right);
        return left && right;
    }
}
