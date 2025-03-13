/**
 * 二叉树结构
 *
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/13 16:59
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode leftNode, TreeNode rightNode) {
        this.val = val;
        this.left = leftNode;
        this.right = rightNode;
    }
}
