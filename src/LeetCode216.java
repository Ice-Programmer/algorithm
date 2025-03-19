import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode：216.组合总和III
 *
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/19 11:40
 */
public class LeetCode216 {
    private void backTracing(int k, int n, int startIndex, List<Integer> path, List<List<Integer>> result) {
        if (path.size() == k) {
            int sum = path.stream().mapToInt(Integer::intValue).sum();
            if (sum == n) {
                result.add(new ArrayList<>(path));
            }
        }
        for (int i = startIndex; i <= 9; i++) {
            path.add(i);
            backTracing(k, n, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        backTracing(k, n, 1, path, result);
        return result;
    }
}
