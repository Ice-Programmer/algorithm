import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode：15.三数之和
 *
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/5 20:35
 */
public class LeetCode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        // 1. 排序
        Arrays.sort(nums);
        // 2.遍历
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    while (right > left && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    List<Integer> result = new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right]));
                    resultList.add(result);
                    right--;
                    left++;
                }
            }
        }
        return resultList;
    }
}
