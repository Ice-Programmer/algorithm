/**
 * @author <a href="https://github.com/Ice-Programmer">chenjiahan</a>
 * @create 2025/4/8 10:39
 */
public class LeetCode4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;

        // 合并后数组长度为奇数时，中位数是第 (total/2 + 1) 小的元素
        // 例如总长度 7，中位数是第 4 小的元素
        if (total % 2 == 1) {
            return findKth(nums1, 0, m, nums2, 0, n, total / 2 + 1);
        }
        // 偶数时，中位数是第 (total/2) 和 (total/2 + 1) 小元素的平均值
        // 例如总长度 8，中位数是第 4 和 5 小的元素的平均值
        else {
            double left = findKth(nums1, 0, m, nums2, 0, n, total / 2);
            double right = findKth(nums1, 0, m, nums2, 0, n, total / 2 + 1);
            return (left + right) / 2.0;
        }
    }

    /**
     * 递归函数：找到两个有序数组中第 k 小的元素
     * @param nums1 第一个数组
     * @param s1 nums1的起始索引（从哪个位置开始考虑）
     * @param len1 nums1的剩余可用长度（从s1开始的有效长度）
     * @param nums2 第二个数组
     * @param s2 nums2的起始索引
     * @param len2 nums2的剩余可用长度
     * @param k 要查找的第k小元素
     */
    private int findKth(int[] nums1, int s1, int len1, int[] nums2, int s2, int len2, int k) {
        // 确保 nums1 是较短的数组（减少后续条件判断）
        if (len1 > len2) {
            return findKth(nums2, s2, len2, nums1, s1, len1, k);
        }

        // 递归终止条件1：nums1的剩余长度为0，直接取nums2的第k小元素
        if (len1 == 0) {
            return nums2[s2 + k - 1]; // s2是起始位置，k是第k个元素
        }

        // 递归终止条件2：找第1小的元素，直接比较两个数组的当前起始元素
        if (k == 1) {
            return Math.min(nums1[s1], nums2[s2]);
        }

        // 核心分治逻辑：
        // 1. 分别在nums1和nums2中尝试取前k/2个元素（如果长度不足则取全部）
        int i = Math.min(len1, k / 2); // nums1取i个元素
        int j = Math.min(len2, k - i); // nums2取j个元素（使得i + j = k）

        // 2. 比较两个数组的第i和j个元素
        int a = nums1[s1 + i - 1]; // nums1的i-1位置（因为索引从0开始）
        int b = nums2[s2 + j - 1]; // nums2的j-1位置

        // 3. 排除不可能的部分
        if (a < b) {
            // 说明nums1的前i个元素一定不包含第k小元素，可以排除
            // 新问题：在nums1的剩余部分（s1+i开始，长度len1-i）和nums2中找第k-i小元素
            return findKth(nums1, s1 + i, len1 - i, nums2, s2, len2, k - i);
        } else {
            // 同理，排除nums2的前j个元素
            // 新问题：在nums1和nums2的剩余部分（s2+j开始，长度len2-j）中找第k-j小元素
            return findKth(nums1, s1, len1, nums2, s2 + j, len2 - j, k - j);
        }
    }
}
