/**
 * // 5. 最长回文子串
 * // 难度：中等
 * // 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * //
 * // 示例 1：
 * // 输入: "babad"
 * // 输出: "bab"
 * // 注意: "aba" 也是一个有效答案。
 * //
 * // 示例 2：
 * // 输入: "cbbd"
 * // 输出: "bb"
 */

package com.code.main._0_100;

class Solution_0005_2 {
    public String longestPalindrome(String s) {
        // 动态规划: O(n^2)相比暴力解法，减少了判断子串是否为回文串的O(n)时间消耗，在递推过程中，就已经做了判断
        int n = s.length();
        boolean[][] dp = new boolean[n][n];     // 状态数组
        String ans = "";
        for (int offset = 0; offset < n; offset++) {     // 遍历终点到起点的偏移大小(用于计算长度，offset=0则只有一个字符)，从0开始是为了后面形式更简洁
            for (int i = 0; i + offset < n; i++) {   // 遍历字符串起始位置
                int j = i + offset;     // 子串终点
                if (offset == 0) {  // 只有一个字符: 是回文串
                    dp[i][j] = true;
                } else if (offset == 1) {   // 有2个字符: 字符必须相同
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);     // 长度更短的子串的状态一定已经计算
                }
                if (dp[i][j] && offset + 1 > ans.length()) {
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
    }
}

public class _0005_longestPalindrome_2 {
    public static void main(String[] args) {
        // "babad"
        Solution_0005_2 solution = new Solution_0005_2();
        System.out.println(solution.longestPalindrome("babababab"));
//        System.out.println(solution.longestPalindrome("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"));
//        System.out.println(solution.judge("aba"));
//        System.out.println(solution.judge("abab"));
//        System.out.println(solution.judge("abcba"));
    }
}
