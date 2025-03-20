import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode：90 子集 II
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/20 11:32
 */
public class LeetCode90 {

    List<Integer> path = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    private void backtrace(int[] nums, int startIndex) {
        result.add(new ArrayList<>(path));

        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            backtrace(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrace(nums, 0);
        return result;
    }
}
