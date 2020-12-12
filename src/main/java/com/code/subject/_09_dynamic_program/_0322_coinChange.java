/**
 * // 322. 零钱兑换
 * // 难度：中等
 * // 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * //
 * // 你可以认为每种硬币的数量是无限的。
 * //
 * // 示例 1：
 * //
 * // 输入：coins = [1, 2, 5], amount = 11
 * // 输出：3
 * // 解释：11 = 5 + 5 + 1
 * // 示例 2：
 * //
 * // 输入：coins = [2], amount = 3
 * // 输出：-1
 * // 示例 3：
 * //
 * // 输入：coins = [1], amount = 0
 * // 输出：0
 * // 示例 4：
 * //
 * // 输入：coins = [1], amount = 1
 * // 输出：1
 * // 示例 5：
 * //
 * // 输入：coins = [1], amount = 2
 * // 输出：2
 * //
 * // 提示：
 * // 1 <= coins.length <= 12
 * // 1 <= coins[i] <= 2^31 - 1
 * // 0 <= amount <= 10^4
 * //
 * // 思路:
 * // 数组dp[n]中存储的是金额1至金额n的最优解（最少使用的钞票数量）
 * // 在计算dp[i]时，dp[1],dp[1],...,dp[i-1]都是已知的
 * // 金额i可以由如下方式组成：假设金额为1,2,5,7,10
 * // 金额i-1的硬币组合和金额1的硬币组成
 * // 金额i-2的硬币组合和金额2的硬币组成
 * // 金额i-5的硬币组合和金额5的硬币组成
 * // ...
 * // 状态i可由i-1,i-2,i-5,...,等状态转移得到，即 dp[i] = min(dp[i-1], dp[i-2], dp[i-5],...) + 1
 */

package com.code.subject._09_dynamic_program;

class Solution_0322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];    // dp[i]表示组成金额i所需的最少硬币个数，数值初始化为-1, dp[0]留空
        for (int i = 1; i < dp.length; i++)
            dp[i] = -1;     // 初始化为-1
        for (int i = 0; i < coins.length; i++)
            if (coins[i] <= amount)
                dp[coins[i]] = 1;   // 跟硬币金额相等的数值，只需要1个硬币
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                int preAmount = i - coins[j];   // 目标金额减去当前硬币所得的金额
                if (preAmount <= 0 || dp[preAmount] <= 0)   // 金额为0或者组成金额的硬币数为-1，直接跳过
                    continue;
                // dp[i]=-1表示还没有搜索到解。如果组成金额preAmount的硬币数+1 < dp[i]，表明偶更优的方法，更新dp[i]
                if (dp[preAmount] + 1 < dp[i] || dp[i] == -1)
                    dp[i] = dp[preAmount] + 1;
            }
        }

        return dp[amount];
    }
}

public class _0322_coinChange {
    public static void main(String[] args) {
//        int[] coins = {1, 2, 5, 7, 10};
//        int amount = 14;
        int[] coins = {1};
        int amount = 0;
        Solution_0322 solution = new Solution_0322();
        int cnt = solution.coinChange(coins, amount);
        System.out.println(cnt);
    }
}
