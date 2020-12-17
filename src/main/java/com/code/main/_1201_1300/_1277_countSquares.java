/**
 * // 1277. 统计全为 1 的正方形子矩阵
 * // 难度：中等
 * // 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
 * //
 * // 示例 1：
 * // 输入：matrix =
 * // [
 * //   [0,1,1,1],
 * //   [1,1,1,1],
 * //   [0,1,1,1]
 * // ]
 * // 输出：15
 * // 解释：
 * // 边长为 1 的正方形有 10 个。
 * // 边长为 2 的正方形有 4 个。
 * // 边长为 3 的正方形有 1 个。
 * // 正方形的总数 = 10 + 4 + 1 = 15.
 * //
 * // 示例 2：
 * // 输入：matrix =
 * // [
 * // [1,0,1],
 * // [1,1,0],
 * // [1,1,0]
 * // ]
 * // 输出：7
 * // 解释：
 * // 边长为 1 的正方形有 6 个。
 * // 边长为 2 的正方形有 1 个。
 * // 正方形的总数 = 6 + 1 = 7.
 * //
 * // 提示：
 * // 1 <= arr.length <= 300
 * // 1 <= arr[0].length <= 300
 * // 0 <= arr[i][j] <= 1
 */

package com.code.main._1201_1300;

class Solution_1277 {
    public int countSquares(int[][] matrix) {
        // 动态规划，类似于题221，先统计每个位置为右下角能够成的最大正方形边长，然后统计正方形个数
        // 为了避免重复统计，对于dp[i][j]=k，只计算以这个位置构成的边长为1~k的正方形个数，即k个
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];     // 将dp[0][...]，dp[...][0]留空，用0填充，减少边界判断

        int count = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                    count += dp[i][j];
                }
            }
        }
        return count;
    }
}

public class _1277_countSquares {
    public static void main(String[] args) {
        // [[0,1,1,1],[1,1,1,1],[0,1,1,1]]
        int[][] matrix = {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}};
        Solution_1277 solution = new Solution_1277();
        int ans = solution.countSquares(matrix);
        System.out.println(ans);
    }
}
