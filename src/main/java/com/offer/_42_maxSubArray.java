/**
 * // 42. 连续子数组的最大和
 * // 难度：简单
 * // 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * //
 * // 要求时间复杂度为O(n)。
 * //
 * // 示例1:
 * // 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * // 输出: 6
 * // 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * //
 * // 提示：
 * // 1 <= arr.length <= 10^5
 * // -100 <= arr[i] <= 100
 * // 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/
 */

package com.offer;

class Solution_42 {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) return Integer.MIN_VALUE;
        if (len == 1) return nums[0];
        int[] dp = new int[len];    // dp[i]表示以第i个数结尾的最大字数和
        dp[0] = nums[0];    // 边界条件，输入的数组长度为1
        int maxSum = dp[0];     // 最大连续子数组的和
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);     // 分2种情况：只包含当前数字或者将当前数组拼接到子数组后面
            if (dp[i] > maxSum)
                maxSum = dp[i];
        }

        return maxSum;
    }
}

public class _42_maxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Solution_42 solution = new Solution_42();
        int ans = solution.maxSubArray(nums);
        System.out.println(ans);
    }
}
