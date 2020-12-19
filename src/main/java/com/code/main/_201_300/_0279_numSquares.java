/**
 * // 279. 完全平方数
 * // 难度：中等
 * // 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * //
 * // 示例 1:
 * // 输入: n = 12
 * // 输出: 3
 * // 解释: 12 = 4 + 4 + 4.
 * //
 * // 示例 2:
 * // 输入: n = 13
 * // 输出: 2
 * // 解释: 13 = 4 + 9.
 */

package com.code.main._201_300;

import java.util.Arrays;

class Solution_0279 {
    public int numSquares(int n) {
        // 思路1: 动态规划，递推计算从1~n的最小平方数个数
        // 有更优的数学解法，但是不容易想，做到动态规划就可以了
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);     // 初始化数组
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int sqrt = (int) Math.sqrt(i);  // 开根号
            for (int j = 1; j <= sqrt; j++) {   // 遍历不超过sqrt的平方数进行
                int idx = i - j * j;
                dp[i] = Math.min(dp[i], dp[idx] + 1);
            }
        }
        return dp[n];
    }
}

public class _0279_numSquares {
    public static void main(String[] args) {
        Solution_0279 solution = new Solution_0279();
        int ans = solution.numSquares(12);
        System.out.println(ans);
    }
}
