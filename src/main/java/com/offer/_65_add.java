/**
 * // 65. 不用加减乘除做加法
 * // 难度：简单
 * // 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * //
 * // 示例:
 * // 输入: a = 1, b = 1
 * // 输出: 2
 * //
 * // 提示：
 * // a, b 均可能是负数或 0
 * // 结果不会溢出 32 位整数
 */

package com.offer;

class Solution_65 {
    public int add(int a, int b) {
        // 无进位和 与 异或运算 规律相同，进位 和 与运算 规律相同（并需左移一位）
        // s = a + b => s = n + c (n非进位和，c进位)
        while (b != 0) {     // 用b记录进位，进位为0时结束
            int c = (a & b) << 1;   // c=进位
            a ^= b;     // a记录非进位和
            b = c;  // b记录进位
        }
        return a;
    }
}

public class _65_add {
    public static void main(String[] args) {
        // 1 2
        Solution_65 solution = new Solution_65();
        int ans = solution.add(1, 3);
        System.out.println(ans);
    }
}
