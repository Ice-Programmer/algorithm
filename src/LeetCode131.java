import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode：131. 分割回文串
 *
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/20 10:16
 */
public class LeetCode131 {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> current, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(current)); // 找到一种有效分割
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                current.add(s.substring(start, end + 1)); // 添加当前回文子串
                backtrack(s, end + 1, current, result); // 处理剩余部分
                current.remove(current.size() - 1); // 回溯
            }
        }
    }

    // 直接判断子串是否为回文（也可以用动态规划优化）
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
