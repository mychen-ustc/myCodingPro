/**
 * // 221. 最大正方形
 * // 难度：中等
 * // 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * //
 * // 示例 1：
 * // 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * // 输出：4
 * //
 * // 示例 2：
 * // 输入：matrix = [["0","1"],["1","0"]]
 * // 输出：1
 * //
 * // 示例 3：
 * // 输入：matrix = [["0"]]
 * // 输出：0
 * //
 * // 提示：
 * // m == matrix.length
 * // n == matrix[i].length
 * // 1 <= m, n <= 300
 * // matrix[i][j] 为 '0' 或 '1'
 */

package com.code.main._201_300;

class Solution_0221 {
    public int maximalSquare(char[][] matrix) {
        // 动态规划, dp[i][j]代表以matrix[i][j]为右下角的最大正方形的边长
        // 如果matrix[i][j]=0，则dp[i][j]=0,否则由左、上、左上三个状态转移
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];     // 将dp[0][...]，dp[...][0]留空，用0填充，减少边界判断
        int maxLen = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '0') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return maxLen * maxLen;
    }
}

public class _0221_maximalSquare {
    public static void main(String[] args) {
//        [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '1'}};
        Solution_0221 solution = new Solution_0221();
        int ans = solution.maximalSquare(matrix);
        System.out.println(ans);
    }
}
