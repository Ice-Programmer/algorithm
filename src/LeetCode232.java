import java.awt.*;
import java.util.Stack;

/**
 * LeetCode：232.用栈实现队列
 *
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/11 19:02
 */
public class LeetCode232 {

    static Stack<Integer> STACK_IN;

    static Stack<Integer> STACK_OUT;

    public LeetCode232() {
        STACK_IN = new Stack<>();
        STACK_OUT = new Stack<>();
    }

    public void push(int x) {
        STACK_IN.push(x);
    }

    public int pop() {
        dumpStackIn();
        return STACK_OUT.pop();
    }

    public int peek() {
        dumpStackIn();
        return STACK_OUT.peek();
    }

    public boolean empty() {
        return STACK_IN.isEmpty() && STACK_OUT.isEmpty();
    }

    private void dumpStackIn() {
        if (!STACK_OUT.isEmpty()) {
            return;
        }
        while (!STACK_IN.isEmpty()) {
            STACK_OUT.push(STACK_IN.pop());
        }
    }
}