/**
 * // 17. 打印从1到最大的n位数
 * // 难度：简单
 * // 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * //
 * // 示例 1:
 * //
 * // 输入: n = 1
 * // 输出: [1,2,3,4,5,6,7,8,9]
 * //
 * // 说明：
 * // 用返回一个整数列表来代替打印
 * // n 为正整数
 */

package com.offer;

class Solution_17 {
    public int[] printNumbers(int n) {
        int bound = 1;  // 求数字的上边界
        while (n != 0) {
            bound *= 10;
            n--;
        }
        int[] ans = new int[bound - 1];
        for (int i = 1; i < bound; i++) {
            ans[i - 1] = i;
        }
        return ans;
    }
}

public class _17_printNumbers {
    public static void main(String[] args) {
        Solution_17 solution = new Solution_17();
        int[] ans = solution.printNumbers(3);
        System.out.println(ans);
    }
}
