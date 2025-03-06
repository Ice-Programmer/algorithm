/**
 * LeetCode:151.翻转字符串里的单词
 *
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/6 15:00
 */
public class LeetCode151 {

    public String reverseWords(String s) {
        String[] strings = s.trim().split("\\s+");
        int start = 0;
        int end = strings.length - 1;
        while (start < end) {
            String temp = strings[start];
            strings[start] = strings[end];
            strings[end] = temp;
            start++;
            end--;
        }
        return String.join(" ", strings);
    }
}
