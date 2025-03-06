/**
 * LeetCode：344.反转字符串
 *
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/6 11:25
 */
public class LeetCode344 {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while(left < right) {
            char temp = s[right];
            s[right] = s[left];
            s[left] = temp;
            left++;
            right--;
        }
    }
}
