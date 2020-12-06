/**
 * // 46. 把数字翻译成字符串
 * // 难度：中等
 * // 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * //
 * // 示例 1:
 * // 输入: 12258
 * // 输出: 5
 * // 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 * //
 * // 提示：
 * // 0 <= num < 231
 * //
 * // 思路：
 * // 动态规划，dp[i]表示前面i位数字构成的编码数量
 * // 初始状态： dp[0] = dp[1] = 1，即 “无数字” 和 “第 1 位数字” 的翻译方法数量均为1
 * // 状态转移：主要看当前数字x和前面数字y组成的整数的范围
 * // dp[i] = dp[i-1] + dp[i-2], if 10 <= xy <= 25
 * // dp[i] = dp[i-1], if 10 <= xy <= 25
 */

package com.offer;

class Solution_46 {
    public int translateNum(int num) {
        String numStr = String.valueOf(num);    // 转换为字符串方便处理
        int len = numStr.length();
        if (len == 0 || len == 1)
            return 1;
        int[] dp = new int[len + 1];    // dp[i]表示截止到第i个字符能组成的方法数量,i从0开始
        dp[0] = 1;  // 只有0位数的情况
        dp[1] = 1;  // 只有1位数的情况
        for (int i = 2; i <= len; i++) {
            int k = Integer.valueOf(numStr.substring(i - 2, i));
            if (k >= 10 && k <= 25) {  // 第i个字符可独立编码，或者与前面一个字符编码成1位
                dp[i] = dp[i - 2] + dp[i - 1];
            } else {
                dp[i] = dp[i - 1];  // 第i个字符只能独立编码
            }
        }
        return dp[len];
    }
}

public class _46_translateNum {
    public static void main(String[] args) {
        Solution_46 solution = new Solution_46();
        int ans = solution.translateNum(12258);
        System.out.println(ans);
    }
}
