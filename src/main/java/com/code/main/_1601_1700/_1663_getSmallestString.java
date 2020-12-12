/**
 * // 1663. 具有给定数值的最小字符串
 * // 难度：中等
 * // 小写字符 的 数值 是它在字母表中的位置（从 1 开始），因此 a 的数值为 1 ，b 的数值为 2 ，c 的数值为 3 ，以此类推。
 * //
 * // 字符串由若干小写字符组成，字符串的数值 为各字符的数值之和。例如，字符串 "abe" 的数值等于 1 + 2 + 5 = 8 。
 * //
 * // 给你两个整数 n 和 k 。返回 长度 等于 n 且 数值 等于 k 的 字典序最小 的字符串。
 * //
 * // 注意，如果字符串 x 在字典排序中位于 y 之前，就认为 x 字典序比 y 小，有以下两种情况：
 * //
 * // x 是 y 的一个前缀；
 * // 如果 i 是 x[i] != y[i] 的第一个位置，且 x[i] 在字母表中的位置比 y[i] 靠前。
 * //  
 * // 示例 1：
 * // 输入：n = 3, k = 27
 * // 输出："aay"
 * // 解释：字符串的数值为 1 + 1 + 25 = 27，它是数值满足要求且长度等于 3 字典序最小的字符串。
 * //
 * // 示例 2：
 * // 输入：n = 5, k = 73
 * // 输出："aaszz"
 * //  
 * // 提示：
 * // 1 <= n <= 105
 * // n <= k <= 26 * n
 */

package com.code.main._1601_1700;

class Solution_1663 {
    public String getSmallestString(int n, int k) {
        // 从后往前，尽量选择最大的字符
        char[] res = new char[n];
        int remain = k;     // 当前距离目标数值还剩下多少额度
        int used = 0;   // 已经选用了几个字符
        for (int i = 0; i < n; i++) {
            int quota = remain - (n - used) + 1;    // 最多能够选择的配额，为了保证字符串能填满n，留出 k - used -1 的额度
            int choose = Math.min(quota, 26);   // 选择一个字符：不能超过额度或者26
            res[n - i - 1] = (char) (choose - 1 + 'a');
            remain -= choose;
            used++;
        }
        return new String(res);
    }
}

public class _1663_getSmallestString {
    public static void main(String[] args) {
        // 3 27
        Solution_1663 solution = new Solution_1663();
        String ans = solution.getSmallestString(3, 27);
        System.out.println(ans);
    }
}
