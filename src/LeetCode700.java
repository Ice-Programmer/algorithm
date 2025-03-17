/**
 * LeetCode：700.二叉搜索树中的搜索
 *
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/17 12:39
 */
public class LeetCode700 {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode current = root;
        while (current != null) {
            if (val > current.val) {
                current = current.right;
                continue;
            }
            if (val < current.val) {
                current = current.left;
                continue;
            }
            return current;
        }
        return null;
    }
}
