import java.util.PriorityQueue;

/**
 * 215. 数组中的第K个最大元素
 *
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/14 21:49
 */
public class LeetCode215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            queue.add(num);
        }
        for (int i = 0; i < k - 1; i++) {
            queue.poll();
        }
        return queue.poll();
    }
}
