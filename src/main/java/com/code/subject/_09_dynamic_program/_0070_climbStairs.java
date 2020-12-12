/**
 * // 70. 爬楼梯
 * // 难度：简单
 * // 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * //
 * // 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * //
 * // 注意：给定 n 是一个正整数。
 * //
 * // 示例 1：
 * //
 * // 输入： 2
 * // 输出： 2
 * // 解释： 有两种方法可以爬到楼顶。
 * // 1.  1 阶 + 1 阶
 * // 2.  2 阶
 * // 示例 2：
 * //
 * // 输入： 3
 * // 输出： 3
 * // 解释： 有三种方法可以爬到楼顶。
 * // 1.  1 阶 + 1 阶 + 1 阶
 * // 2.  1 阶 + 2 阶
 * // 3.  2 阶 + 1 阶
 * //
 * // 思路：
 * // 由于每次最多爬2级台阶，楼梯的第i阶，只可能从娄底第i-1阶或第i-2阶到达，所以第i阶有多少种爬法，只与第i-1阶，第i-2阶的爬法直接相关
 * // 动态规划的递推公式：f(n) = f(n-2) + f(n-1), f(0) = 0, f(1) = 1, f(2) = 2
 */

package com.code.subject._09_dynamic_program;

class Solution_0070 {
    public int climbStairs(int n) {
        /* 一般动态规划会顶一个dp数组，递推的计算数组中的值。 */

        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        // 用 fminus2 表示爬 x-2 级台阶的方法数, fminus1 表示爬 x-1 级台阶的方法数。分别初始化为2级，1级台阶的方法数量。
        // fn 表示 n 爬级台阶的方法数
        int fminus2 = 1, fminus1 = 2, fn = 0;
        for (int i = 3; i <= n; i++) {
            fn = fminus1 + fminus2;   // 递推公式 f(n) = f(n-2) + f(n-1)
            fminus2 = fminus1;  // 更新 f(n - 2)
            fminus1 = fn;   // 更新 f(n - 1)
        }
        return fn;
    }
}

public class _0070_climbStairs {
    public static void main(String[] args) {
        Solution_0070 solution = new Solution_0070();
        System.out.println(solution.climbStairs(0));
        System.out.println(solution.climbStairs(1));
        System.out.println(solution.climbStairs(2));
        System.out.println(solution.climbStairs(3));
        System.out.println(solution.climbStairs(4));
        System.out.println(solution.climbStairs(10));
        System.out.println(solution.climbStairs(44));
        System.out.println(solution.climbStairs(45));
        System.out.println(solution.climbStairs(46));

    }
}
