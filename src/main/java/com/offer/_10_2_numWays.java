/**
 * // 10- II. 青蛙跳台阶问题
 * // 难度：简单
 * // 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * //
 * // 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * //
 * // 示例 1：
 * //
 * // 输入：n = 2
 * // 输出：2
 * // 示例 2：
 * //
 * // 输入：n = 7
 * // 输出：21
 * // 示例 3：
 * //
 * // 输入：n = 0
 * // 输出：1
 * //
 * // 提示：
 * // 0 <= n <= 100
 * // 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/
 * //
 * // 思路：动态规划
 * // 初始条件 f(0)=1,f(1)=1,f(2)=2
 * // 状态转移公式：f(i)=f(i-2)+f(i-1), i>=3
 */

package com.offer;

class Solution_10_2 {
    public int numWays(int n) {
        if (n == 0) return 1;   // 题目要求
        if (n == 1) return 1;
        if (n == 2) return 2;
        int fnMinus2 = 1, fnMinus1 = 2;     // 前2阶、前1阶的跳法数量
        int ans = 0;
        for (int i = 3; i <= n; i++) {
            ans = (fnMinus2 + fnMinus1) % 1000000007;   // 按题目要求取模
            fnMinus2 = fnMinus1;    // 往后递推
            fnMinus1 = ans;     // 往后递推
        }
        return ans;
    }
}

public class _10_2_numWays {
    public static void main(String[] args) {
        int n = 7;
        Solution_10_2 solution = new Solution_10_2();
        int ans = solution.numWays(n);
        System.out.println(ans);
    }
}
