/**
 * LeetCode：977.有序数组的平方
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 * @author <a href="https://github.com/IceProgramer">chenjiahan</a>
 * @create 2025/2/27 20:26
 */
public class LeetCode977 {
    // 使用双指针方法
    public int[] sortedSquares(int[] nums) {
        int k = nums.length - 1;
        int[] result = new int[nums.length];
        for (int left = 0, right = nums.length - 1; left <= right;) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                result[k] = nums[left] * nums[left];
                left++;
            } else {
                result[k] = nums[right] * nums[right];
                right--;
            }
            k--;
        }
        return result;
    }
}
