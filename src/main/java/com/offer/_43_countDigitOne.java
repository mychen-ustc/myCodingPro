/**
 * // 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * //
 * // 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 * //
 * // 示例 1：
 * // 输入：n = 12
 * // 输出：5
 * //
 * // 示例 2：
 * // 输入：n = 13
 * // 输出：6
 * //
 * // 限制：
 * // 1 <= n < 2^31
 * // 注意：本题与主站 233 题相同：https://leetcode-cn.com/problems/number-of-digit-one/
 */

package com.offer;

class Solution_43 {
    public int countDigitOne(int n) {
        int ans = 0;
        // 定义变量的初值
        int digit = 1;
        int low = 0, cur = n % 10, high = n / 10;   // 分别表示低位、当前位、高位的数值
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                ans += high * digit;
            } else if (cur == 1) {
                ans += (high * digit + low + 1);
            } else {
                ans += (high + 1) * digit;
            }
            // 更新变量，在数字轴上看，只往高位平移
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return ans;
    }
}

public class _43_countDigitOne {
    public static void main(String[] args) {
        Solution_43 solution = new Solution_43();
        int ans = solution.countDigitOne(100);
        System.out.println(ans);
    }
}
