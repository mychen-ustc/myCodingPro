/**
 * // 1292. 元素和小于等于阈值的正方形的最大边长
 * // 难度：中等
 * // 给你一个大小为 m x n 的矩阵 mat 和一个整数阈值 threshold。
 * //
 * // 请你返回元素总和小于或等于阈值的正方形区域的最大边长；如果没有这样的正方形区域，则返回 0 。
 * //
 * // 示例 1：
 * // 输入：mat = [[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]], threshold = 4
 * // 输出：2
 * // 解释：总和小于 4 的正方形的最大边长为 2，如图所示。
 * //
 * // 示例 2：
 * // 输入：mat = [[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2]], threshold = 1
 * // 输出：0
 * //
 * // 示例 3：
 * // 输入：mat = [[1,1,1,1],[1,0,0,0],[1,0,0,0],[1,0,0,0]], threshold = 6
 * // 输出：3
 * //
 * // 示例 4：
 * // 输入：mat = [[18,70],[61,1],[25,85],[14,40],[11,96],[97,96],[63,45]], threshold = 40184
 * // 输出：2
 * //  
 * // 提示：
 * // 1 <= m, n <= 300
 * // m == mat.length
 * // n == mat[i].length
 * // 0 <= mat[i][j] <= 10000
 * // 0 <= threshold <= 10^5
 */

package com.code.main._1201_1300;

class Solution_1292 {
    public int maxSideLength(int[][] mat, int threshold) {
        // 解法1: 前缀和，穷举所有可能的边长
        int m = mat.length, n = mat[0].length;
        int[][] dp = new int[m + 1][n + 1];     // 前缀和矩阵：第一行和第一列都用0填充
        // part1: 求前缀和数组
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = mat[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];   // 递归求前缀和元素
            }
        }
        //
        int ans = 0;
        for (int k = 1; k <= Math.min(m, n); k++) {     // 遍历正方形边长 1~min(m,n)
            for (int i = 1; i <= m; i++) {  // 遍历矩阵的行
                for (int j = 1; j <= n; j++) {  // 遍历矩阵的列
                    if (i - k < 0 || j - k < 0)
                        continue;   // 不能构成正方形
                    int tmp = dp[i][j] - dp[i - k][j] - dp[i][j - k] + dp[i - k][j - k];    // 求以当前点为右下角的边长为k的矩阵的元素和
                    if (tmp <= threshold)
                        ans = Math.max(ans, k);
                }
            }
        }
        return ans;
    }
}

public class _1292_maxSideLength {
    public static void main(String[] args) {
        int[][] mat = {{1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}};
        int threshold = 4;
        Solution_1292 solution = new Solution_1292();
        int ans = solution.maxSideLength(mat, threshold);
        System.out.println(ans);
    }
}
