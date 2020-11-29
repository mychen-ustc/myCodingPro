/**
 * // 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * //
 * // 示例 1:
 * //
 * // 输入: 2.00000, 10
 * // 输出: 1024.00000
 * // 示例 2:
 * //
 * // 输入: 2.10000, 3
 * // 输出: 9.26100
 * // 示例 3:
 * //
 * // 输入: 2.00000, -2
 * // 输出: 0.25000
 * // 解释: 2-2 = 1/2^2 = 1/4 = 0.25
 * // 说明:
 * //
 * // -100.0 < x < 100.0
 * // n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1] 。
 */

package com.code.other;

class Solution_0050 {
    public double quickMul(double x, long N) {
        if (N == 0) {   // 边界条件
            return 1.0;
        }
        double y = quickMul(x, N / 2);  // 先计算x^(n/2)
        return N % 2 == 0 ? y * y : y * y * x;  // n如果为奇数，需要再乘一个x
    }

    public double myPow(double x, int n) {
        long N = n;     // 为了避免-1 * -2*32溢出
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }
}

public class _0050_myPow {
    public static void main(String[] args) {
        Solution_0050 solution = new Solution_0050();
        double pow = solution.myPow(2.00000, -2);
        System.out.println(pow);
    }
}
