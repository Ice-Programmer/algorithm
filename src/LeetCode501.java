import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * LeetCode：501.二叉搜索树中的众数
 *
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/18 10:40
 */
public class LeetCode501 {
    HashMap<Integer, Integer> map = new HashMap<>();

    private void traversal(TreeNode current) {
        if (current == null) {
            return;
        }
        // 左
        traversal(current.left);
        // 中
        map.put(current.val, map.getOrDefault(current.val, 0) + 1);
        // 右
        traversal(current.right);
    }

    public int[] findMode(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(root);
        PriorityQueue<int[]> queue = new PriorityQueue<>((b, a) -> a[1] - b[1]);
        for (Integer key : map.keySet()) {
            queue.add(new int[]{key, map.get(key)});
        }
        int[] node = queue.poll();
        result.add(node[0]);
        while (!queue.isEmpty() && queue.peek()[1] == node[1]) {
            result.add(queue.poll()[0]);
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        LeetCode501 leetcode501 = new LeetCode501();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        leetcode501.findMode(root);
    }
}
