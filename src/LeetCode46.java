import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode：46.全排列
 *
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/21 10:54
 */
public class LeetCode46 {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    boolean[] used;

    private void backtrace(int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backtrace(nums);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        backtrace(nums);
        return result;
    }
}
