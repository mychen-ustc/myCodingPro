/**
 * // 300. 最长上升子序列
 * // 难度：中等
 * // 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * //
 * // 示例:
 * //
 * // 输入: [10,9,2,5,3,7,101,18]
 * // 输出: 4
 * // 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * // 说明:
 * //
 * // 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * // 你算法的时间复杂度应该为 O(n2) 。
 * // 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 * //
 * // 思路：
 * // 方法一：动态规划
 * // 思路与算法
 * // 定义 dp[i]dp[i] 为考虑前 ii 个元素，以第 ii 个数字结尾的最长上升子序列的长度，注意 \textit{nums}[i]nums[i] 必须被选取。
 * //
 * // 我们从小到大计算 dp[]dp[] 数组的值，在计算 dp[i]dp[i] 之前，我们已经计算出 dp[0 \ldots i-1]dp[0…i−1] 的值，则状态转移方程为：
 * //
 * // dp[i] = \text{max}(dp[j]) + 1, \text{其中} \, 0 \leq j < i \, \text{且} \, \textit{num}[j]<\textit{num}[i]
 * // dp[i]=max(dp[j])+1,其中0≤j<i且num[j]<num[i]
 * //
 * // 即考虑往 dp[0 \ldots i-1]dp[0…i−1] 中最长的上升子序列后面再加一个 \textit{nums}[i]nums[i]。由于 dp[j]dp[j] 代表 \textit{nums}[0 \ldots j]nums[0…j] 中以 \textit{nums}[j]nums[j] 结尾的最长上升子序列，所以如果能从 dp[j]dp[j] 这个状态转移过来，那么 \textit{nums}[i]nums[i] 必然要大于 \textit{nums}[j]nums[j]，才能将 \textit{nums}[i]nums[i] 放在 \textit{nums}[j]nums[j] 后面以形成更长的上升子序列。
 * //
 * // 最后，整个数组的最长上升子序列即所有 dp[i]dp[i] 中的最大值。
 * //
 * // \text{LIS}_{\textit{length}}= \text{max}(dp[i]), \text{其中} \, 0\leq i < n
 * // LIS
 * // length
 * // ​
 * //  =max(dp[i]),其中0≤i<n
 */

package com.code.subject._09_dynamic_program;

class Solution_0300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;    // 数组的长度
        if (n == 0) return 0;   // 边界条件
        if (n == 1) return 1; // 边界条件
        int[] dp = new int[n];  // dp[i-1]表示以nums[i-1]结尾的最长上升子序列，要寻找前面那一部分子序列（用j遍历前面的子序列）
        dp[0] = 1;    // 边界条件:初始化dp[0]
        int maxLen = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;  // 初始化dp[i]
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {    // 状态转移的前提，nums[i]要比前面的子序列的最大值还大
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(dp[i], maxLen);
        }

        return maxLen;
    }
}

public class _0300_lengthOfLIS {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        Solution_0300 solution = new Solution_0300();
        int maxLen = solution.lengthOfLIS(nums);
        System.out.println(maxLen);
    }
}
