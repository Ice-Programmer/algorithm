import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode：78.子集
 *
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/20 11:18
 */
public class LeetCode78 {

    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> result = new ArrayList<>();

    private void backtrace(int[] nums, int startIndex) {
        result.add(new ArrayList<>(path));

        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backtrace(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        backtrace(nums, 0);
        return result;
    }
}
