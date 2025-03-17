import java.util.Arrays;

/**
 * LeetCode：106.从中序与后序遍历序列构造二叉树
 *
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/17 10:50
 */
public class LeetCode106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) return null;

        int rootVal = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootVal);

        if (postorder.length == 1) return root;

        // 找到中序分割点
        int index = 0;
        for (; index < inorder.length; index++) {
            if (inorder[index] == rootVal) break;
        }

        // 切割中序数组
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, index);
        int[] rightInorder = Arrays.copyOfRange(inorder, index + 1, inorder.length);

        // 移除后序数组的最后一个元素（根节点）
        int[] newPostorder = Arrays.copyOf(postorder, postorder.length - 1);

        // 切割后序数组
        int[] leftPostorder = Arrays.copyOfRange(newPostorder, 0, leftInorder.length);
        int[] rightPostorder = Arrays.copyOfRange(newPostorder, leftInorder.length, newPostorder.length);

        // 递归构建子树
        root.left = buildTree(leftInorder, leftPostorder);
        root.right = buildTree(rightInorder, rightPostorder);

        return root;
    }
}
