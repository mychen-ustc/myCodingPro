/**
 * // 14- I. 剪绳子
 * // 难度：中等
 * // 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * //
 * // 示例 1：
 * //
 * // 输入: 2
 * // 输出: 1
 * // 解释: 2 = 1 + 1, 1 × 1 = 1
 * // 示例 2:
 * //
 * // 输入: 10
 * // 输出: 36
 * // 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * // 提示：
 * //
 * // 2 <= n <= 58
 * // 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/
 */

package com.offer;

class Solution_14_I {
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];    // dp[0]=d[1]=0
        for (int i = 2; i <= n; i++) {    // 遍历2~n构造dp表
            for (int j = 1; j < i; j++) {  // 拆分第一根绳子
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));  // 循环j的过程中，会不断求dp[i]的最大值
            }
        }
        return dp[n];
    }
}

public class _14_I_cuttingRope {
    public static void main(String[] args) {
        Solution_14_I solution = new Solution_14_I();
        int ans = solution.cuttingRope(8);
        System.out.println(ans);
    }

}
