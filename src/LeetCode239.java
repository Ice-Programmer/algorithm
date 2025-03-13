import java.util.Deque;
import java.util.LinkedList;

/**
 * LeetCode：239. 滑动窗口最大值
 *
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/13 14:49
 */
public class LeetCode239 {
    static Deque<Integer> deque = new LinkedList<>();

    private void pop(int val) {
        if (!deque.isEmpty() && deque.peekFirst() == val) {
            deque.poll();
        }
    }

    private void push(int val) {
        while (!deque.isEmpty() && deque.getLast() < val) {
            deque.removeLast();
        }
        deque.add(val);
    }

    private int getMaxValue() {
        return deque.peek();
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        // 放入前k - 1个元素
        for (int i = 0; i < k - 1; i++) {
            push(nums[i]);
        }
        // 滑动窗口
        for (int i = 0; i < nums.length - k + 1; i++) {
            // 添加元素
            push(nums[i + k - 1]);
            // 获取最大
            result[i] = getMaxValue();
            // 去除元素
            pop(nums[i]);
        }
        return result;
    }

}
