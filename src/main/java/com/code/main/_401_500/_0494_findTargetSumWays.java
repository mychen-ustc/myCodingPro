/**
 * // 494. 目标和
 * // 难度：中等
 * // 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。
 * //
 * 对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * //
 * // 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 * //
 * // 示例：
 * // 输入：nums: [1, 1, 1, 1, 1], S: 3
 * // 输出：5
 * // 解释：
 * // -1+1+1+1+1 = 3
 * // +1-1+1+1+1 = 3
 * // +1+1-1+1+1 = 3
 * // +1+1+1-1+1 = 3
 * // +1+1+1+1-1 = 3
 * //
 * // 一共有5种方法让最终目标和为3。
 * //
 * // 提示：
 * // 数组非空，且长度不会超过 20 。
 * // 初始的数组的和不会超过 1000 。
 * // 保证返回的最终结果能被 32 位整数存下。
 */

package com.code.main._401_500;

class Solution_0494 {
    // 解法1: 枚举，穷尽所有情况 时间O(2^N), 空间O(N)
//    int count = 0;
//
//    public int findTargetSumWays(int[] nums, int S) {
//        recur(nums, S, 0, 0);
//        return count;
//    }
//
//    // 递归寻找解数量
//    public void recur(int[] nums, int S, int sum, int index) {
//        if (index == nums.length) {
//            if (sum == S)
//                count++;
//        } else {
//            recur(nums, S, sum + nums[index], index + 1);   // 当前符号为+
//            recur(nums, S, sum - nums[index], index + 1);    // 当前符号为-
//        }
//    }

    // 解法2: 动态规划 dp[i][j]表示前i个元素，组成和为j的方案数.
    // dp表需要对负数做处理: 由于数组索引不能为负数，将第二维都抬升1000
//    public int findTargetSumWays(int[] nums, int S) {
//        int bias = 1000;
//        int[][] dp = new int[nums.length][2001];    // 数组之和最大为1000,第二维用2001个位置即可
//        dp[0][nums[0] + bias] += 1;     // 初始化
//        dp[0][-nums[0] + bias] += 1;    // 初始化
//        for (int i = 1; i < nums.length; i++) {     // 遍历数组每个索引，递推第一维
//            for (int sum = -bias; sum <= bias; sum++) {     // 遍历每个和，递推求构成每个数组和的方法数
//                if (dp[i - 1][sum + bias] > 0) {
//                    dp[i][sum + nums[i] + bias] += dp[i - 1][sum + bias];
//                    dp[i][sum - nums[i] + bias] += dp[i - 1][sum + bias];
//                }
//            }
//        }
//        return S > bias ? 0 : dp[nums.length - 1][S + bias];
//    }

    // 解法2plus: 动态规划+空间优化
    public int findTargetSumWays(int[] nums, int S) {
        int[] dp = new int[2001];
        int bias = 1000;
        dp[nums[0] + bias] = 1;
        dp[-nums[0] + bias] += 1;
        for (int i = 1; i < nums.length; i++) {
            int[] next = new int[2001];
            for (int sum = -bias; sum <= bias; sum++) {
                if (dp[sum + bias] > 0) {
                    next[sum + nums[i] + bias] += dp[sum + bias];
                    next[sum - nums[i] + bias] += dp[sum + bias];
                }
            }
            dp = next;
        }
        return S > bias ? 0 : dp[S + bias];
    }
}

public class _0494_findTargetSumWays {
    public static void main(String[] args) {
        // [1,1,1,1,1] 3
        Solution_0494 solution = new Solution_0494();
        System.out.println(solution.findTargetSumWays(new int[]{1, 1}, 0));
        System.out.println(solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));

    }
}
