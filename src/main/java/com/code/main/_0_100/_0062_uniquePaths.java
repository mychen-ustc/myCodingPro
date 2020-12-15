/**
 * // 62. 不同路径
 * // 难度：中等
 * // 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * //
 * // 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * //
 * // 问总共有多少条不同的路径？
 * //
 * // 示例 1：
 * // 输入：m = 3, n = 7
 * // 输出：28
 * //
 * // 示例 2：
 * // 输入：m = 3, n = 2
 * // 输出：3
 * // 解释：
 * // 从左上角开始，总共有 3 条路径可以到达右下角。
 * // 1. 向右 -> 向右 -> 向下
 * // 2. 向右 -> 向下 -> 向右
 * // 3. 向下 -> 向右 -> 向右
 * //
 * // 示例 3：
 * // 输入：m = 7, n = 3
 * // 输出：28
 * //
 * // 示例 4：
 * // 输入：m = 3, n = 3
 * // 输出：6
 * //
 * // 提示：
 * // 1 <= m, n <= 100
 * // 题目数据保证答案小于等于 2 * 109
 */

package com.code.main._0_100;

class Solution_0062 {
    public int uniquePaths(int m, int n) {
        // 按题目要求，不考虑路径数量溢出
        if (m == 0 || n == 0) return 0;     // 没有元素
        if (m == 1 || n == 1) return 1;     // 矩阵只有一行或一列
        // 动态规划 dp[i][j]为走到当前位置的路径数
        int[][] dp = new int[m][n];
        // 初始化第一行、第一列
        for (int j = 0; j < n; j++)
            dp[0][j] = 1;
        for (int i = 0; i < m; i++)
            dp[i][0] = 1;
        // 递推
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];     // 从上方或者左侧达到当前位置
            }
        }
        return dp[m - 1][n - 1];
    }
}

public class _0062_uniquePaths {
    public static void main(String[] args) {
        // 3 7
        Solution_0062 solution = new Solution_0062();
        int ans = solution.uniquePaths(1, 1);
        System.out.println(ans);
    }
}
