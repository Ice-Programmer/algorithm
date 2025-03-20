import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * LeetCode：491.递增子序列
 *
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/20 11:32
 */
public class LeetCode491 {

    List<Integer> path = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    private void backtrace(int[] nums, int startIndex) {
        if (path.size() >= 2) {
            result.add(new ArrayList<>(path));
        }

        Set<Integer> used = new HashSet<>(); // 用于去重，防止同一层重复选择相同元素

        for (int i = startIndex; i < nums.length; i++) {
            if (used.contains(nums[i])) {
                continue; // 同一层不能选相同的元素，避免重复子序列
            }

            if (path.isEmpty() || path.get(path.size() - 1) <= nums[i]) {
                used.add(nums[i]);
                path.add(nums[i]);
                backtrace(nums, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtrace(nums, 0);
        return result;
    }
}
