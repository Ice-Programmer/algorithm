import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode：257. 二叉树的所有路径
 *
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/16 20:56
 */
public class LeetCode257 {
    public String generatePath(List<Integer> path) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < path.size() - 1; i++) {
            stringBuffer.append(path.get(i)).append("->");
        }
        return stringBuffer.append(path.get(path.size() - 1)).toString();
    }
    public void traversal(TreeNode current, List<Integer> path, List<String> resultList) {
        path.add(current.val);
        // 中
        if (current.left == null && current.right == null) {
            resultList.add(generatePath(path));
        }
        // 左
        if (current.left != null) {
            traversal(current.left, path, resultList);
            path.remove(path.size() - 1);
        }
        // 右
        if (current.right != null) {
            traversal(current.right, path, resultList);
            path.remove(path.size() - 1);
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        List<String> result = new ArrayList<>();
        traversal(root, path, result);
        return result;
    }
}
