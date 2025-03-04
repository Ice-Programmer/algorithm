/**
 * @author <a href="https://github.com/IceProgramer">chenjiahan</a>
 * @create 2025/3/4 20:20
 */
public class LeetCode242 {
    public boolean isAnagram(String s, String t) {
        int[] array = new int[26];
        for (char c : s.toCharArray()) {
            array[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            array[c - 'a']--;
        }
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (array[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
