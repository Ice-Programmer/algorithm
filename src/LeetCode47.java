import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode：47. 全排列 II
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/21 11:22
 */
public class LeetCode47 {

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
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            path.add(nums[i]);
            backtrace(nums);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }


    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrace(nums);
        return result;
    }
}
