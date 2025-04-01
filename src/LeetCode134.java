/**
 * LeetCode ：134.加油站
 *
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/25 13:40
 */
public class LeetCode134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalSum = 0;
        int currentSum = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            totalSum = totalSum + gas[i] - cost[i];
            currentSum = currentSum + gas[i] - cost[i];
            if (currentSum < 0) {
                start = i + 1;
                currentSum = 0;
            }
        }
        if (totalSum < 0) {
            return -1;
        } else {
            return start;
        }
    }
}
