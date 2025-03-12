import java.util.Stack;

/**
 * LeetCode：150. 逆波兰表达式求值
 * 给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
 *
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/12 21:02
 */
public class LeetCode150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if ("+".equals(token)) {
                stack.push(stack.pop() + stack.pop());
                continue;
            }
            if ("-".equals(token)) {
                stack.push(-stack.pop() + stack.pop());
                continue;
            }
            if ("*".equals(token)) {
                stack.push(stack.pop() * stack.pop());
                continue;
            }
            if ("/".equals(token)) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
                continue;
            }
            stack.push(Integer.parseInt(token));
        }
        return stack.pop();
    }
}
