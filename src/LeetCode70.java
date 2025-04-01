/**
 * LeetCode：70.爬楼梯
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/4/1 14:18
 */
public class LeetCode70 {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}
