/**
 * // 152. 乘积最大子数组
 * // 难度：中等
 * // 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * //
 * // 示例 1:
 * // 输入: [2,3,-2,4]
 * // 输出: 6
 * // 解释: 子数组 [2,3] 有最大乘积 6。
 * //
 * // 示例 2:
 * // 输入: [-2,0,-1]
 * // 输出: 0
 * // 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */

package com.code.main._101_200;

class Solution_0152 {
    public int maxProduct(int[] nums) {
        // 动态规划：由于数字可能为正可能有负，需要记录前面的最大和最小值
        // dpMax[i]为以当前元素为最后一个元素的子数组的最大乘积,dpMIn[i]为以当前元素为最后一个元素的子数组的最小乘积
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        int[] dpMax = new int[len];     // 维护最大乘积
        int[] dpMin = new int[len];     // 维护最小乘积
        System.arraycopy(nums, 0, dpMax, 0, len);   // 初始化
        System.arraycopy(nums, 0, dpMin, 0, len);   // 初始化
        int maxProduct = dpMax[0];
        for (int i = 1; i < len; i++) {
            dpMax[i] = Math.max(dpMax[i - 1] * nums[i], Math.max(nums[i], dpMin[i - 1] * nums[i])); // 正的最大值
            dpMin[i] = Math.min(dpMin[i - 1] * nums[i], Math.min(nums[i], dpMax[i - 1] * nums[i])); // 负的最小值
            maxProduct = Math.max(maxProduct, dpMax[i]);
        }
        return maxProduct;
    }
}

public class _0152_maxProduct {
    public static void main(String[] args) {
        // [2,3,-2,4]
        int[] nums = {2, 3, -2, 4};
        Solution_0152 solution = new Solution_0152();
        int ans = solution.maxProduct(nums);
        System.out.println(ans);
    }
}
