import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode:40.组合总和II
 *
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/19 15:15
 */
public class LeetCode40 {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    private void backtrace(int[] candidates, int target, int startIndex) {
        if (target == 0) {

            result.add(new ArrayList<>(path));

            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            // **剪枝：跳过重复元素**

            if (candidates[i] > target) {
                return;
            }
            path.add(candidates[i]);
            backtrace(candidates, target - candidates[i], i + 1);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrace(candidates, target, 0);
        return result;
    }

}
