import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode：94.中序遍历
 *
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/13 17:24
 */
public class LeetCode94 {
    public void traversal(TreeNode current, List<Integer> result) {
        if (current == null) {
            return;
        }
        // 右
        traversal(current.left, result);
        // 中
        result.add(current.val);
        // 左
        traversal(current.right, result);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }
}
