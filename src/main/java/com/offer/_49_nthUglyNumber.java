/**
 * // 49. 丑数
 * // 难度：中等
 * // 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * //
 * // 示例:
 * // 输入: n = 10
 * // 输出: 12
 * // 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * //
 * // 说明:  
 * // 1 是丑数。
 * // n 不超过1690。
 * // 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/
 */

package com.offer;

class Solution_49 {
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;    // 分别记录2/3/5取了多少次
        int[] dp = new int[n];  // dp[i]表示第i个丑数
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2;
            int n3 = dp[b] * 3;
            int n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (dp[i] == n2)
                a++;
            if (dp[i] == n3)
                b++;
            if (dp[i] == n5)
                c++;
        }
        return dp[n - 1];
    }
}

public class _49_nthUglyNumber {
    public static void main(String[] args) {
        Solution_49 solution = new Solution_49();
        int ans = solution.nthUglyNumber(100);
        System.out.println(ans);
    }
}
