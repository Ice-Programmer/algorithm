import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode：145.后序遍历
 *
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/13 17:19
 */
public class LeetCode145 {
    public void traversal(TreeNode current, List<Integer> result) {
        if (current == null) {
            return;
        }
        // 右
        traversal(current.left, result);
        // 左
        traversal(current.right, result);
        // 中
        result.add(current.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }
}
