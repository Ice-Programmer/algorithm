/**
 * LeetCode：541. 反转字符串II
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/6 20:56
 */
public class LeetCode541 {
    public void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[end];
            chars[end] = chars[start];
            chars[start] = temp;
            start++;
            end--;
        }
    }

    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i += 2 * k) {
            if (i + k < ch.length) {
                reverse(ch, i, i + k - 1);
                continue;
            }
            reverse(ch, i, ch.length - 1);
        }

        return new String(ch);
    }
}
