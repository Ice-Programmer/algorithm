/**
 * 45. 跳跃游戏 II
 *
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/24 11:08
 */
public class LeetCode45 {
    public int jump(int[] nums) {
        int maxApproach = 0;
        int jumps = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxApproach = Math.max(maxApproach, i + nums[i]);
            if (i == end) {
                jumps++;
                end = maxApproach;
                if (end >= nums.length - 1) {
                    break;
                }
            }
        }
        return jumps;
    }
}
