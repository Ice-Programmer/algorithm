import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode：77.组合
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/19 10:31
 */
public class LeetCode77 {

    List<Integer> path = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    private void backtracing(int n, int k, int startIndex) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            backtracing(n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        backtracing(n, k, 1);
        return result;
    }
}
