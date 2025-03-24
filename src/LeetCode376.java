import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode：376.摆动序列
 *
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/22 12:04
 */
public class LeetCode376 {
    public int wiggleMaxLength(int[] nums) {
        int count = 1;
        int preDiff = 0;
        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if (diff > 0 && preDiff <= 0 || diff < 0 && preDiff >= 0) {
                count++;
                preDiff = diff;
            }
        }
        return count;
    }

}
