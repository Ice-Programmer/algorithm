import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * LeetCode：17.电话号码的字母组合
 *
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/19 11:54
 */
public class LeetCode17 {

    String[] letters = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    private String generateString(List<Character> path) {
        StringBuilder sb = new StringBuilder();
        for (char s : path) {
            sb.append(s);
        }
        return sb.toString();
    }

    private void backTracing(String digits, int index, List<Character> path, List<String> result) {
        if (path.size() == digits.length()) {
            result.add(generateString(path));
            return;
        }

        // 获取当前数字对应的字母
        String letter = letters[digits.charAt(index) - '0'];

        for (int i = 0; i < letter.length(); i++) {
            path.add(letter.charAt(i));  // 选择
            backTracing(digits, index + 1, path, result); // 递归
            path.remove(path.size() - 1);  // 回溯
        }
    }

    public List<String> letterCombinations(String digits) {
        List<Character> path = new ArrayList<>();
        List<String> result = new ArrayList<>();

        if (digits.isEmpty()) return result; // 处理空输入

        backTracing(digits, 0, path, result);
        return result;
    }
}
