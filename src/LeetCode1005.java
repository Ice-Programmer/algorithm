import java.util.Arrays;

/**
 * LeetCode：1005.K次取反后最大化的数组和
 *
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/24 11:12
 */
public class LeetCode1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        // 排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length && k > 0; i++) {
            if (nums[i] < 0) {
                nums[i] = -nums[i];
                k--;
            }
        }
        if (k % 2 == 1) {
            Arrays.sort(nums);
            nums[0] = -nums[0];
        }

        return Arrays.stream(nums).sum();
    }
}
