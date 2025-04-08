/**
 * LeetCode:42.接雨水
 *
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/4/2 14:01
 */
public class LeetCode42 {
    public int trap(int[] height) {
        int n = height.length;
        int[] rh = new int[n]; // 存储每个柱子右边的最大高度（包括自己）

        // 从右到左计算 rh
        for (int i = n - 1; i > 0; i--) {
            rh[i - 1] = Math.max(rh[i], height[i]);
        }

        int lh = 0; // 动态维护左边的最大高度
        int sum = 0; // 总雨水量

        // 从左到右计算雨水量
        for (int i = 0; i < n; i++) {
            sum += Math.max(Math.min(lh, rh[i]) - height[i], 0);
            lh = Math.max(lh, height[i]); // 更新左边的最大高度
        }

        return sum;
    }
}
