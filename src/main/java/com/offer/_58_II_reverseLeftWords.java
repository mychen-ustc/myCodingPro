/**
 * // 58 - II. 左旋转字符串
 * // 难度：简单
 * // 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * //
 * // 示例 1：
 * // 输入: s = "abcdefg", k = 2
 * // 输出: "cdefgab"
 * //
 * // 示例 2：
 * // 输入: s = "lrloseumgh", k = 6
 * // 输出: "umghlrlose"
 * //
 * // 限制：
 * // 1 <= k < s.length <= 10000
 */

package com.offer;

class Solution_58_II {
    public String reverseLeftWords(String s, int n) {
        if (n >= s.length() || n <= 0) return s;
        StringBuilder sbuild = new StringBuilder();
        sbuild.append(s.substring(n)).append(s.substring(0, n));
        return sbuild.toString();
    }
}

public class _58_II_reverseLeftWords {
    public static void main(String[] args) {
        // "abcdefg"
        // 2
        Solution_58_II solution = new Solution_58_II();
        String ans = solution.reverseLeftWords("abcdefg", 1);
        System.out.println(ans);
    }
}
