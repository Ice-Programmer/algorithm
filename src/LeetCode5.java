/**
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/4/8 10:11
 */
public class LeetCode5 {

    private int broadcastAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        int start = 0;
        int end = 0;

        for (int i = 0; i < n; i++) {
            // 获取奇数的长度
            int oddLength = broadcastAroundCenter(s, i, i + 1);
            // 获取偶数
            int evenLength = broadcastAroundCenter(s, i, i);

            int length = Math.max(oddLength, evenLength);

            if (length > end - start) {
                start = i - (length - 1) / 2;
                end = i + length / 2;
            }
        }
        return s.substring(start, end + 1);
    }
}
