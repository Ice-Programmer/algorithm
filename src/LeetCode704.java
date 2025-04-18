/**
 * LeetCode 704 二分查找
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * @author <a href="https://github.com/IceProgramer">chenjiahan</a>
 * @create 2025/2/27 20:02
 */
public class LeetCode704 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            if (target > nums[middle]) {
                left = middle + 1;
            }
            if (target < nums[middle]) {
                right = middle - 1;
            }
        }
        return -1;
    }
}
