/**
 * // 14- II. 剪绳子 II
 * // 难度：中等
 * // 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * //
 * // 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
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
 * //
 * // 提示：
 * // 2 <= n <= 1000
 * //
 * // 思路：动态规划，时间性能比较差，只击败5%
 */

package com.offer;

import java.math.BigInteger;

class Solution_14_II_2 {
    public int cuttingRope(int n) {
        if (n < 2)
            return 0;
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        /*
        d[i]表示长度为i的绳子剪完后各段乘积的最大值, 最终目标是dp[n]
        dp[i]可以看成是长度为i-k的绳子的最大值和长度为k的绳子的最大值的乘积, 子问题最优, 所以dp[i]也是最优
        状态转移方程: dp[i] = max(dp[i], dp[i-k]*dp[k])
        */
        //下面的初始值不同于上面的特殊情况, 上面是必须剪一刀, 下面的三个初始值不用再减了
        BigInteger[] dp = new BigInteger[n + 1];
        dp[1] = new BigInteger("1");//内循环中会用到这个值
        dp[2] = new BigInteger("2");
        dp[3] = new BigInteger("3");
        for (int i = 4; i <= n; i++) {
            //初始化dp[i]
            dp[i] = new BigInteger("0");
            //长度为i的绳子有i-1个剪切位置; 不论i是奇数还是偶数, 只考虑前i/2个剪切位置即可, 后面的剪切位置是重复的
            for (int j = 1; j <= i / 2; j++) {
                //因为j和i-j都小于i, 所以这是自底向上的计算方式
                dp[i] = dp[i].max(dp[j].multiply(dp[i - j]));
            }
        }
        return dp[n].mod(new BigInteger("1000000007")).intValue();
    }
}

public class _14_II_cuttingRope_2 {
    public static void main(String[] args) {
        Solution_14_II_2 solution = new Solution_14_II_2();
        int ans = solution.cuttingRope(1000);
        System.out.println(ans);
    }
}
