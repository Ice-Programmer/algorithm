import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode：39.组合总和
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/19 12:28
 */
public class LeetCode39 {

    private void backtrack(int target, int[] candidates, int startIndex, List<Integer> path, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            // 剪枝操作
            if (candidates[i] > target) {
                return;
            }
            path.add(candidates[i]);
            backtrack(target - candidates[i], candidates, i, path, result);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(target, candidates, 0, path, result);
        return result;
    }
}
