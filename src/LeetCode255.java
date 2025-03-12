import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode：225. 用队列实现栈
 *
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/12 20:12
 */
public class LeetCode255 {

    static Queue<Integer> QUEUE;

    public LeetCode255() {
        QUEUE = new LinkedList<>();
    }

    // 将元素 x 压入栈顶。
    public void push(int x) {
        QUEUE.offer(x);
        int size = QUEUE.size();
        // 移动除了 A 的其它数
        while (size-- > 1) {
            QUEUE.offer(QUEUE.poll());
        }
    }

    // 移除并返回栈顶元素。
    public int pop() {
        return QUEUE.poll();
    }

    // 返回栈顶元素。
    public int top() {
        return QUEUE.peek();
    }

    //  如果栈是空的，返回 true ；否则，返回 false
    public boolean empty() {
        return QUEUE.isEmpty();
    }
}
