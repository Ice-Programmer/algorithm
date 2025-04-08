import java.util.Stack;

/**
 * LeetCode:739.每日温度
 *
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/4/2 18:39
 */
public class LeetCode739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        // 推入第一个元素
        stack.add(0);
        for (int i = 1; i < temperatures.length; i++) {
            // 当前元素大于栈中元素
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int pop = stack.pop();
                result[pop] = i - pop;
            }
            stack.add(i);
        }
        return result;
    }
}
