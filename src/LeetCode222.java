/**
 * LeetCode：222.完全二叉树节点的数量
 *
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/16 20:09
 */
public class LeetCode222 {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int rightNum = countNodes(root.right);
        int leftNum = countNodes(root.left);
        return rightNum + leftNum + 1;
    }

}
