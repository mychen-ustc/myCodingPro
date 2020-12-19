/**
 * // 309. 最佳买卖股票时机含冷冻期
 * // 难度：中等
 * // 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * //
 * // 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * //
 * // 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * // 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * //
 * // 示例:
 * // 输入: [1,2,3,0,2]
 * // 输出: 3
 * // 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 */

package com.code.main._301_400;

class Solution_0309 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        // 动态规划，记录当天结束后的最大收益
        // dp[i][j]: j=0 当天持有股票; j=1 当天不持有股票且处于冰冻期; j=2 当天不持有股票且不处于冰冻期
        // 由于只从前一天转移，可以只设置3个变量（不用一个二维数组）
        int n = prices.length;
        int[][] dp = new int[n][3]; // 第二维用于存储当天的3种状态
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);    // 1.前一天持有(当天不卖出) 2.前一天不持有非冰冻(当天买入)
            dp[i][1] = dp[i - 1][0] + prices[i];    // 只从1种情况转移 前一天持有当天卖出
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);    // 1.前一天不持有且冰冻(当天不买入) 2.前一天不持有且不冰冻(当天不买入)
        }
        return Math.max(dp[n - 1][1], dp[n - 1][2]);   // 最后一天不持有股票（持有则必然不是最大收益）
    }
}

public class _0309_maxProfit {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        Solution_0309 solution = new Solution_0309();
        int ans = solution.maxProfit(prices);
        System.out.println(ans);
    }
}
