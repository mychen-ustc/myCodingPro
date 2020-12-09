/**
 * // 59 - I. 滑动窗口的最大值
 * // 难度：简单
 * // 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * //
 * // 示例:
 * // 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * // 输出: [3,3,5,5,6,7]
 * // 解释:
 * //
 * // 滑动窗口的位置                最大值
 * // ---------------               -----
 * // [1  3  -1] -3  5  3  6  7       3
 * // 1 [3  -1  -3] 5  3  6  7       3
 * // 1  3 [-1  -3  5] 3  6  7       5
 * // 1  3  -1 [-3  5  3] 6  7       5
 * // 1  3  -1  -3 [5  3  6] 7       6
 * // 1  3  -1  -3  5 [3  6  7]      7
 * //
 * // 提示：
 * // 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 * // 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/
 */

package com.offer;

class Solution_59_I {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0)
            return new int[0];
        int len = nums.length;
        int[] ans = new int[len - k + 1];
        for (int i = 0; i < len - k + 1; i++) { // 遍历滑动窗口
            int j = i;
            int max = nums[j];
            while (j < i + k) {
                if (nums[j] > max)
                    max = nums[j];
                j++;
            }
            ans[i] = max;
        }
        return ans;
    }
}

public class _59_I_maxSlidingWindow {
    public static void main(String[] args) {
        // [1,3,-1,-3,5,3,6,7]
        // 3
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        Solution_59_I solution = new Solution_59_I();
        int[] ans = solution.maxSlidingWindow(nums, k);
        for (int num : ans)
            System.out.println(num);
    }
}
