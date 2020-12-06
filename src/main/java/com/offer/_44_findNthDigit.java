/**
 * // 44. 数字序列中某一位的数字
 * // 难度：中等
 * // 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * //
 * // 请写一个函数，求任意第n位对应的数字。
 * //
 * // 示例 1：
 * // 输入：n = 3
 * // 输出：3
 * //
 * // 示例 2：
 * // 输入：n = 11
 * // 输出：0
 * //
 * // 限制：
 * // 0 <= n < 2^31
 * // 注意：本题与主站 400 题相同：https://leetcode-cn.com/problems/nth-digit/
 */

package com.offer;

class Solution_44 {
    public int findNthDigit(int n) {
        // 暴力计算，将所有数字拼接到字符串里面，然后找对应数字：问题是容易超出内存限制
//        if (n == 0) return 0;
//        StringBuffer buffer = new StringBuffer("0");   // 将每个数字拼接到buffer中
//        int cnt = 1;
//        int i = 1;
//        while (cnt <= n) {
//            buffer.append(i);
//            cnt = buffer.length();
//            i++;
//        }
//        return (buffer.charAt(n) - '0');

        /** 规律分析
         * https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/solution/mian-shi-ti-44-shu-zi-xu-lie-zhong-mou-yi-wei-de-6/
         */
        // 计算该数字由几位数字组成，由1位：digits = 1；2位：digits = 2...
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1 求数字在几位数的范围内，得到n/digits/start
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2 求目标数字是在哪个数中
        return String.valueOf(num).charAt((n - 1) % digit) - '0'; // 3 求数字
    }
}

public class _44_findNthDigit {
    public static void main(String[] args) {
        Solution_44 solution = new Solution_44();
        System.out.println(solution.findNthDigit(0));
        System.out.println(solution.findNthDigit(1));
        System.out.println(solution.findNthDigit(2));
        System.out.println(solution.findNthDigit(3));
        System.out.println(solution.findNthDigit(4));
        System.out.println(solution.findNthDigit(5));
        System.out.println(solution.findNthDigit(6));
        System.out.println(solution.findNthDigit(7));
        System.out.println(solution.findNthDigit(8));
        System.out.println(solution.findNthDigit(9));
        System.out.println(solution.findNthDigit(10));
        System.out.println(solution.findNthDigit(11));
    }
}
