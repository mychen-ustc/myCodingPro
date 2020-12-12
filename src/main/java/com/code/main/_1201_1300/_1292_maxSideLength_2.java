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

class Solution_1292_2 {
    int m, n;
    int[][] dp;

    public int maxSideLength(int[][] mat, int threshold) {
        // 解法2: 前缀和，二分法求可能的边长，此解法比解法1的整体耗时降低1个量级 (145ms vs 12ms)
        m = mat.length;
        n = mat[0].length;
        dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = mat[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }
        int l = 0, h = Math.min(m, n);
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (l == h || l + 1 == h) {
                break;
            }
            if (find(mid, threshold)) {
                l = mid;
            } else {
                h = mid - 1;
            }
        }
        if (find(h, threshold)) {
            return h;
        } else {
            return l;
        }
    }

    // 求解边长K能否找到满足要求的正方形
    public boolean find(int k, int threshold) {
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i - k < 0 || j - k < 0) {
                    continue;
                }
                if (dp[i][j] - dp[i - k][j] - dp[i][j - k] + dp[i - k][j - k] <= threshold) {
                    return true;
                }
            }
        }
        return false;
    }
}

public class _1292_maxSideLength_2 {
    public static void main(String[] args) {
        int[][] mat = {{1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}};
        int threshold = 4;
        Solution_1292_2 solution = new Solution_1292_2();
        int ans = solution.maxSideLength(mat, threshold);
        System.out.println(ans);
    }
}
