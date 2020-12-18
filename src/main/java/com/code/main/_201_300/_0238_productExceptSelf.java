/**
 * // 238. 除自身以外数组的乘积
 * // 难度：中等
 * // 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * //
 * // 示例:
 * // 输入: [1,2,3,4]
 * // 输出: [24,12,8,6]
 * //  
 * // 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 * //
 * // 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * //
 * // 进阶：
 * // 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 */

package com.code.main._201_300;

class Solution_0238 {
    public int[] productExceptSelf(int[] nums) {
        // 动态规划：将数组的乘积按矩阵拆分为上下两部分。对角线都是1。
        // 下半部分的乘积用dp数组维护，上半部分只需要一个变量即可
        // 由于输出数组不视为额外空间，按照题目要求，这种方法的空间复杂度为O(1)
        int len = nums.length;  // 输入数组的长度
        int[] dp = new int[len];    // 下半部分的递推数组
        for (int i = 0; i < len; i++) { // 初始化数组
            dp[i] = 1;
        }
        // 递推下三角(左侧乘积)
        for (int i = 1; i < len; i++) {
            dp[i] = dp[i - 1] * nums[i - 1];
        }
        // 组合上三角的乘积(右侧乘积)
        int product = 1;
        for (int i = len - 1; i >= 0; i--) {
            dp[i] = dp[i] * product;   // 组合上三角和下三角的乘积
            product *= nums[i];     // 更新上三角的累计乘积
        }
        return dp;
    }
}

public class _0238_productExceptSelf {
    public static void main(String[] args) {
        // [1,2,3,4]
//        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] nums = {1, 2, 3, 4};
        Solution_0238 solution = new Solution_0238();
        int[] ans = solution.productExceptSelf(nums);
        for (int num : ans) {
            System.out.println(num);
        }
    }
}
