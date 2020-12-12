/**
 * // 53. 最大子序和
 * // 难度：简单
 * // 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * //
 * // 示例:
 * //
 * // 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * // 输出: 6
 * // 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * // 进阶:
 * //
 * // 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * //
 * // 思路:
 * // 将求n个数的数组的最大子段和，转换为分别求第1个、第2个，...，第n个数字结尾的最大子段和，然后从这n个结果中找出最大的，即为结果
 * // 第i个状态有2种情况：即只包含nums[i]或者跟前面i-1个数的最大子段和拼接
 * // 当dp[i-1] > 0时，dp[i] = dp[i-1]+nums[i]
 * // 当dp[i-1] < 0时，dp[i] = nums[i]
 */

package com.code.subject._09_dynamic_program;

class Solution_0053 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;   // 边界条件
        if (n == 1) return nums[0];     // 边界条件
        // dp[0]表示n=0时的值,dp[i]表示以第i个元素结尾的最大子序和，并不表示长度为i的数组的最大子序和，最大值需要比较dp[0]~d[n]求得
        int[] dp = new int[n + 1];
        dp[1] = nums[0];
        int max = nums[0];    // max不能初始化为0，而是应该初始化为最小整数或者数组第一个元素
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(nums[i - 1], dp[i - 1] + nums[i - 1]);     // 递推公式
            if (max <= dp[i])
                max = dp[i];
        }
        return max;
    }
}

public class _0053_maxSubArray {
    public static void main(String[] args) {
//        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums = {-2, -1};
        Solution_0053 solution = new Solution_0053();
        int max = solution.maxSubArray(nums);
        System.out.println(max);
    }
}
