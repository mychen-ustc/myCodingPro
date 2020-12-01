/**
 * // 10- I. 斐波那契数列
 * // 难度：简单
 * // 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 * //
 * // F(0) = 0,   F(1) = 1
 * // F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * // 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * //
 * // 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * //
 * // 示例 1：
 * //
 * // 输入：n = 2
 * // 输出：1
 * // 示例 2：
 * //
 * // 输入：n = 5
 * // 输出：5
 * //
 * // 提示：
 * // 0 <= n <= 100
 */

package com.offer;

class Solution_10_1 {
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int nminus2 = 0;
        int nminus1 = 1;
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (nminus2 + nminus1) % 1000000007;     // 按题目要求将答案取模1e9+7
            nminus2 = nminus1;
            nminus1 = ans;
        }
        return ans;
    }
}

public class _10_1_fib {
    public static void main(String[] args) {
        int n = 50;
        Solution_10_1 solution = new Solution_10_1();
        int ans = solution.fib(n);
        System.out.println(ans);
    }
}
