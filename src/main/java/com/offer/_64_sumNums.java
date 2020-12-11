/**
 * // 64. 求1+2+…+n
 * // 难度：中等
 * // 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * //
 * // 示例 1：
 * // 输入: n = 3
 * // 输出: 6
 * //
 * // 示例 2：
 * // 输入: n = 9
 * // 输出: 45
 * //  
 * // 限制：
 * // 1 <= n <= 10000
 */

package com.offer;

class Solution_64 {
    public int sumNums(int n) {
        // sum(1+...+n) = n(n+1)/2
        // 用递归实现，结束条件用逻辑运算符
        boolean flag = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}

public class _64_sumNums {
    public static void main(String[] args) {
        // 3
        Solution_64 solution = new Solution_64();
        int sum = solution.sumNums(5);
        System.out.println(sum);
    }
}
