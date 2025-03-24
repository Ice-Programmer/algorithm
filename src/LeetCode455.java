import java.util.Arrays;

/**
 * LeetCode：455. 分发饼干
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/22 11:24
 */
public class LeetCode455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                i++;
            }
            j++;
        }
        return i;
    }
}
