/**
 * 55. 跳跃游戏
 *
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/24 11:11
 */
public class LeetCode55 {
    public boolean canJump(int[] nums) {
        int maxApproach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxApproach) {
                return false;
            }
            // 取最远
            maxApproach = Math.max(maxApproach, i + nums[i]);
            if (maxApproach > nums.length - 1) {
                return true;
            }
        }
        return true;
    }
}
