/**
 * // 47. 礼物的最大价值
 * // 难度：中等
 * // 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * //
 * // 示例 1:
 * //
 * // 输入:
 * // [
 * //   [1,3,1],
 * //   [1,5,1],
 * //   [4,2,1]
 * // ]
 * // 输出: 12
 * // 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 * //
 * // 提示：
 * // 0 < grid.length <= 200
 * // 0 < grid[0].length <= 200
 */

package com.offer;

class Solution_47 {
    public int maxValue(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        int[][] dp = new int[m][n];     // dp[[i][j]表示到达当前位置的最大礼物价值
        dp[0][0] = grid[0][0];  // 边界条件
        for (int i = 1; i < m; i++)
            dp[i][0] = dp[i - 1][0] + grid[i][0];   // 边界条件：初始化第一列
        for (int j = 1; j < n; j++)
            dp[0][j] = dp[0][j - 1] + grid[0][j];     // 边界条件：初始化第一行
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j] + grid[i][j], dp[i][j - 1] + grid[i][j]);  // 只能从上方或者左边转化而来
            }
        }
        return dp[m - 1][n - 1];
    }
}

public class _47_maxValue {
    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        Solution_47 solution = new Solution_47();
        int ans = solution.maxValue(grid);
        System.out.println(ans);
    }
}
