import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode：144.前序遍历
 *
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/13 16:58
 */
public class LeetCode144 {
    public void traversal(TreeNode current, List<Integer> result) {
        if (current == null) {
            return;
        }
        result.add(current.val);
        traversal(current.left, result);
        traversal(current.right, result);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }
}
