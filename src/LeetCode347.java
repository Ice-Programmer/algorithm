import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * LeetCode：347.前 K 个高频元素
 *
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/3/13 16:21
 */
public class LeetCode347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        // 统计所有词频
        for (int i = 0; i < nums.length; i++) {
            Integer value = hashMap.getOrDefault(nums[i], 0);
            hashMap.put(nums[i], value + 1);
        }

        PriorityQueue<int[]> priorityQueue =
                new PriorityQueue<>((pair1, pair2) -> pair1[1] - pair2[1]);

        // 将所有可能的词频放在小顶堆中
        for (Integer num : hashMap.keySet()) {
            priorityQueue.add(new int[]{num, hashMap.get(num)});
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = priorityQueue.poll()[0];
        }
        return result;
    }}
