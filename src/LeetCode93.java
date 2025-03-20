import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode：93.复原IP地址
 *
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/20 10:59
 */
public class LeetCode93 {

    List<String> result = new ArrayList<>();

    private String generateIpAddress(List<String> path) {
        StringBuilder sb = new StringBuilder();
        return String.join(".", path);
    }

    private boolean isIpAddress(String ipStr) {
        // 开头不能为 0
        if (ipStr.length() > 1 && ipStr.charAt(0) == '0') {
            return false;
        }
        int ip = Integer.parseInt(ipStr);
        return ip <= 255;
    }

    private void backtrace(String s, int startIndex, List<String> path) {
        if (path.size() == 4 && startIndex == s.length()) {
            result.add(generateIpAddress(path));
            return;
        }

        for (int end = startIndex; end < s.length(); end++) {
            // ip 不可能大于3位
            if (end - startIndex > 3) {
                return;
            }
            if (path.size() == 3 && s.length() - startIndex > 3) {
                return;
            }
            String current = s.substring(startIndex, end + 1);
            if (isIpAddress(current)) {
                path.add(current);
                backtrace(s, end + 1, path);
                path.remove(path.size() - 1);
            }
        }

    }
    public List<String> restoreIpAddresses(String s) {
        List<String> path = new ArrayList<>();
        backtrace(s, 0, path);
        return result;
    }
}
