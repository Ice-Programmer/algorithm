/**
 * LeetCode 209 长度最小的子数组
 *
 * @author <a href="https://github.com/IceProgramer">chenjiahan</a>
 * @create 2025/2/28 13:43
 */
public class LeetCode209 {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int end = 0; end < nums.length; end++) {
            sum = sum + nums[end];
            while (sum >= target) {
                int length = end - start + 1;
                result = Math.min(result, length);
                sum = sum - nums[start];
                start++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
